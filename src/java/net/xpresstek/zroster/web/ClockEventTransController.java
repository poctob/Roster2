/* 
 * Copyright (C) 2014 Alex Pavlunenko <alexp at xpresstek.net>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.xpresstek.zroster.web;

import com.gzlabs.utils.DateUtils;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Objects;
import net.xpresstek.zroster.ejb.ClockEventTrans;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.SelectItem;
import net.xpresstek.zroster.ejb.ClockEvent;
import net.xpresstek.zroster.ejb.ClockEventDataManager;
import net.xpresstek.zroster.ejb.ClockOutReasons;
import net.xpresstek.zroster.ejb.Configuration;
import net.xpresstek.zroster.ejb.Employee;
import net.xpresstek.zroster.ejb.Shift;
import net.xpresstek.zroster.web.ShiftController.ShiftControllerConverter;
import net.xpresstek.zroster.web.util.JsfUtil;
import net.xpresstek.zroster.web.util.TimeUtils;
import org.primefaces.context.RequestContext;

@SessionScoped
@Named("clockEventTransController")
public class ClockEventTransController extends ControllerBase {

    private ClockEventTrans current;
    private ClockOutReasons reason;
    private SelectItem[] availableEmployees;
    private Date current_date;
    private Employee currentApprover;
    private String approverPassword;
    private ClockEventDataManager clockEventDM;
    
    @EJB
    private net.xpresstek.zroster.web.ClockEventTransFacade ejbFacade;

    public ClockEventTransController() {

        Date dt = new Date();
        String str_dt = DateUtils.DateToString(dt);
        str_dt = str_dt.substring(0, 11);
        str_dt += "00:00:00.0";

        current_date = DateUtils.StringToDate(str_dt);
        clockEventDM = ClockEventDataManager.getInstance();
    }

    /**
     * Finds clock events by interval.
     * @param start Start of the interval
     * @param end End of the interval
     * @return List of the clock events during the interval.
     */
    public List<ClockEventTrans> findClockEventsByInterval(Date start, Date end)
    {
        List<ClockEventTrans> retval = new ArrayList();
        if(ejbFacade != null)
            retval = ejbFacade.findClockEventsByInterval(start,end);
        
        return retval;        
    }
    
    /**
     * @return currentEvents.
     */
    public List<ClockEventTrans> getCurrentEvents() {
        return clockEventDM.getCurrentEvents();
    }


    /**
     *
     * @return Current set date
     */
    public Date getCurrent_date() {
        return current_date;
    }

    public Employee getCurrentApprover() {
        return currentApprover;
    }

    public void setCurrentApprover(Employee currentApprover) {
        this.currentApprover = currentApprover;
    }

    public void setApproverPassword(String approverPassword) {
        this.approverPassword = approverPassword;
    }

    public String getApproverPassword() {
        return "";
    }

    /**
     *
     * @param current_date Date to set the current date to.
     */
    public void setCurrent_date(Date current_date) {
         
        this.current_date = current_date;
        clockEventDM.setCurrentDate(current_date);
        clockEventDM.updateData();
    }
    
    public void updateCurrentEvents()
    {
        clockEventDM.updateData();
    }

    /**
     * Performs clock in event for specified employee.
     *
     * @param employee Employee to clock in.
     */
    public void ClockIn(Employee employee) {
        if (isApproved(employee)) {

            current.setEmployeeid(employee);
            ClockEventController controller
                    = ControllerFactory.getClockEventController();
            current.setClockEventid(controller.getClockInId());
            super.create();
        }
    }

    private boolean isApproved(Employee employee) {
        boolean retval = true;
        if (isEarly(employee)) {
            if (currentApprover == null || approverPassword == null) {
                RequestContext context = RequestContext.getCurrentInstance();
                JsfUtil.addErrorMessage("Approval Required!");
                context.execute("approvalDialog.show();");
                retval = false;
            } else {
                S3cr3tController sc = ControllerFactory.getS3cr3tController();
                retval = sc.isPasswordCorrect(currentApprover.getPkID(), approverPassword);
                if (!retval) {
                    JsfUtil.addErrorMessage("Invalid Credentials");
                }
                currentApprover = null;
                approverPassword = "";
            }
        }
        return retval;
    }

    private boolean isEarly(Employee employee) {
        boolean retval = true;
        Calendar now = new GregorianCalendar();
        ShiftController shiftController
                = ShiftControllerConverter.getController();
        List<Shift> shifts = shiftController.getByStartAndEmployee(employee.getPkID(), now.getTime());
        Configuration conf;
        conf = (Configuration) ControllerFactory.getConfigurationController().
                getObject("EarlyClockInMinutes");

        int minutes;
        try {
            minutes = Integer.parseInt(conf.getConfigValue());
        } catch (NumberFormatException e) {
            return false;
        }

        long millis = minutes * 60 * 1000;
        for (Shift shift : shifts) {
            long diff = shift.getStart().getTime() - now.getTimeInMillis();
            if (diff > 0 && diff <= millis) {
                return false;
            }
        }
        return retval;
    }

    public SelectItem[] getAvailableEmployees() {
        ArrayList<String> names = new ArrayList();
        names.add("Select");
        List<ClockEventTrans> events=findClockEventsByInterval(TimeUtils.getDayStart(current_date),
                    TimeUtils.getDayEnd(current_date));
        if (events != null) {
            for (ClockEventTrans item : events) {
                String name = item.getEmployeeid().getName();
                if (!names.contains(name)) {
                    names.add(name);
                }
            }
        }

        availableEmployees = new SelectItem[names.size()];
        for (int i = 0; i < names.size(); i++) {
            availableEmployees[i] = new SelectItem(names.get(i), names.get(i));
        }
        return availableEmployees;
    }

    /**
     * Performs clock out event for specified employee.
     *
     * @param employee Employee to clock out.
     */
    public void ClockOut(Employee employee) {
        current.setEmployeeid(employee);
        ClockEventController controller
                = ControllerFactory.getClockEventController();
        current.setClockEventid(controller.getClockOutId());
        current.setClockOutReasonid(reason);
        super.create();

        EmployeeController econtroller
                = ControllerFactory.getEmployeeController();
        econtroller.updateEmployeeHours();
    }

    /**
     * Current clock out reason accessors.
     *
     * @return Current clock out reasons
     */
    public ClockOutReasons getReason() {
        return reason;
    }

    /**
     * Clock out reason setter.
     *
     * @param reason Reason to set.
     */
    public void setReason(ClockOutReasons reason) {
        this.reason = reason;
    }

    /**
     * Retrieves last event for the employee.
     *
     * @param employee Employee to use in the search.
     * @return Name of the last clock event.
     */
    public String getLastEventName(Employee employee) {
        ClockEventTrans event = ejbFacade.getLastEvent(employee);
        if (event != null) {
            return event.getClockEventid().getName();
        }
        return "";
    }

    /**
     * Retrieves last event time for the employee.
     *
     * @param employee Employee to use in the search.
     * @return Time of the last event.
     */
    public Date getLastEventTime(Employee employee) {
        ClockEventTrans event = ejbFacade.getLastEvent(employee);
        if (event != null) {
            return event.getTimestamp();
        }
        return null;
    }

    /**
     * Checks if the employee is clocked in.
     *
     * @param employee Employee object to check
     * @return True if employee is currently clocked in, false otherwise.
     */
    public boolean isClockedIn(Employee employee) {
        return getLastEventName(employee).
                equals(ClockEventFacade.CLOCK_IN_NAME);
    }

    @Override
    AbstractFacade getFacade() {
        return ejbFacade;
    }

    public void prepareEdit(int id) {
        setCurrent(getClockEventTrans(id));
        selectedItemIndex = id;
    }

    public ClockEventTrans getClockEventTrans(java.lang.Integer id) {
        return ejbFacade.find(id);
    }

    public double calculateShiftHours(ClockEventTrans item) {
        double hours = 0;
        ClockEvent clockout = ControllerFactory.getClockEventController().getClockOutId();

        if (item != null && Objects.equals(item.getClockEventid().getPkid(), clockout.getPkid())) {
            ClockEventTrans lastlogin = ejbFacade.getLastClockIn(item.getEmployeeid(),
                    item);
            hours = item.getTimestamp().getTime()
                    - lastlogin.getTimestamp().getTime();
        }
        double sh = hours / (1000 * 60 * 60);
        return Math.round(sh * 4) / 4f;
    }

    @Override
    Object getCurrent() {
        return current;
    }

    @Override
    void setCurrent(Object obj) {
        current = (ClockEventTrans) obj;
    }

    @Override
    void createNewCurrent() {
        current = new ClockEventTrans();
        current.setTimestamp(new Date());
    }

    @Override
    public List findAll() {
        return ejbFacade.findAll();
    }

    @FacesConverter(forClass = ClockEventTrans.class)
    public static class ClockEventTransControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ClockEventTransController controller = (ClockEventTransController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "clockEventTransController");
            return controller.getClockEventTrans(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof ClockEventTrans) {
                ClockEventTrans o = (ClockEventTrans) object;
                return getStringKey(o.getPkid());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + ClockEventTrans.class.getName());
            }
        }
    }
}
