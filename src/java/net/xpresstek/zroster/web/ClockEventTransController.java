package net.xpresstek.zroster.web;

import com.gzlabs.utils.DateUtils;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
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
import net.xpresstek.zroster.ejb.ClockOutReasons;
import net.xpresstek.zroster.ejb.Configuration;
import net.xpresstek.zroster.ejb.Employee;
import net.xpresstek.zroster.ejb.Shift;
import net.xpresstek.zroster.web.ClockEventController.ClockEventControllerConverter;
import net.xpresstek.zroster.web.EmployeeController.EmployeeControllerConverter;
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
    private List<ClockEventTrans> currentEvents;
    private Employee currentApprover;
    private String approverPassword;
    @EJB
    private net.xpresstek.zroster.web.ClockEventTransFacade ejbFacade;

    public ClockEventTransController() {

        Date dt = new Date();
        String str_dt = DateUtils.DateToString(dt);
        str_dt = str_dt.substring(0, 11);
        str_dt += "00:00:00.0";

        current_date = DateUtils.StringToDate(str_dt);
    }

    /**
     * @return currentEvents.
     */
    public List<ClockEventTrans> getCurrentEvents() {

        updateCurrentEvents();
        return currentEvents;
    }

    /**
     *
     * @param currentEvents Event list
     */
    public void setCurrentEvents(List<ClockEventTrans> currentEvents) {
        this.currentEvents = currentEvents;
    }

    /**
     * Updates list of current events based on the current date.
     */
    public void updateCurrentEvents() {
        if (ejbFacade != null) {
            currentEvents = ejbFacade.findClockEventsByInterval(TimeUtils.getDayStart(current_date),
                    TimeUtils.getDayEnd(current_date));
        }
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
        updateCurrentEvents();
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
                    = ClockEventControllerConverter.getController();
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
                S3cr3tController sc = S3cr3tController.S3cr3tControllerConverter.
                        getController();
                retval = sc.isPasswordCorrect(currentApprover.getPkID(), approverPassword);
                if(!retval)
                {
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
        Configuration conf
                = (Configuration) ConfigurationController.ConfigurationControllerConverter.getController().
                getObject("EarlyClockInMinutes");

        int minutes = 0;
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
        if (currentEvents != null) {
            for (ClockEventTrans item : currentEvents) {
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
                = ClockEventControllerConverter.getController();
        current.setClockEventid(controller.getClockOutId());
        current.setClockOutReasonid(reason);        
        super.create();
        
        EmployeeController econtroller=EmployeeControllerConverter.getController();
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
        ClockEvent clockout = ClockEventControllerConverter.
                getController().getClockOutId();

        if (item != null && item.getClockEventid().getPkid() == clockout.getPkid()) {
            ClockEventTrans lastlogin = ejbFacade.getLastClockIn(item.getEmployeeid(),
                    item);
            hours = item.getTimestamp().getTime()
                    - lastlogin.getTimestamp().getTime();
        }
        double sh = hours / (1000 * 60 * 60);
        return Math.round(sh * 4) / 4f;
    }

    private double calculateNextDayRollover(ClockEventTrans eventtrans) {
        double retval = 0;
        if (eventtrans.getClockEventid().getName()
                .equals(ClockEventFacade.CLOCK_OUT_NAME)) {
            Calendar cal = new GregorianCalendar();
            cal.setTime(eventtrans.getTimestamp());
            cal.add(Calendar.DAY_OF_MONTH, -1);
            Date yesterday = cal.getTime();

            List<ClockEventTrans> clockevents
                    = findClockEventsByEmployeeAndInterval(eventtrans.getEmployeeid(),
                            TimeUtils.getDayStart(yesterday),
                            TimeUtils.getDayEnd(yesterday));

            if (clockevents != null && clockevents.size() > 0) {
                ClockEventTrans lastevent = clockevents.get(clockevents.size() - 1);
                if (lastevent != null
                        && lastevent.getClockEventid().getName().
                        equals(ClockEventFacade.CLOCK_IN_NAME)) {

                    double millis = TimeUtils.getDayEnd(yesterday).getTime()
                            - lastevent.getTimestamp().getTime();

                    millis += (eventtrans.getTimestamp().getTime()
                            - TimeUtils.getDayStart(eventtrans.getTimestamp()).getTime());

                    retval += (millis / 1000) / 3600;

                }
            }

        }
        return retval;
    }

    /**
     * Calculates worked hours for a specified employee and time period.
     *
     * @param employee Employee to calculate time for.
     * @param start Start of a period
     * @param end End of a period.
     * @return Worked hours
     */
    public double calculateWorkedHours(Employee employee,
            Date start,
            Date end) {
        List<ClockEventTrans> clockevents
                = findClockEventsByEmployeeAndInterval(employee, start, end);

        Collections.sort(clockevents);

        double interval = 0;
        ClockEventTrans eventtrans;
        for (int i = 0; i < clockevents.size(); i++) {

            eventtrans = clockevents.get(i);

            if (i == 0) {
                interval += calculateNextDayRollover(eventtrans);
            }

            if (eventtrans != null
                    && eventtrans.getClockEventid().getName().
                    equals(ClockEventFacade.CLOCK_IN_NAME)) {

                int next = i + 1;
                if (next < clockevents.size()) {
                    ClockEventTrans next_event = clockevents.get(next);
                    if (next_event != null
                            && next_event.getClockEventid().getName()
                            .equals(ClockEventFacade.CLOCK_OUT_NAME)) {
                        double millis = next_event.getTimestamp().getTime()
                                - eventtrans.getTimestamp().getTime();

                        interval += (millis / 1000) / 3600;
                    }
                }

            }

        }
        return Math.round(interval * 4) / 4f;
    }

    /**
     * Retrieves clock events using employee id and specified start and end
     * interval.
     *
     * @param employee Employee
     * @param start Start interval.
     * @param end End interval.
     * @return List of the shifts that employee is schedules to work.
     */
    public List<ClockEventTrans> findClockEventsByEmployeeAndInterval(Employee employee,
            Date start,
            Date end) {

        return ejbFacade.
                findClockEventsByEmployeeAndInterval(employee, start, end);
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

        public static ClockEventTransController getController() {
            FacesContext fc = FacesContext.getCurrentInstance();
            return (ClockEventTransController) fc.getApplication().getELResolver().
                    getValue(fc.getELContext(), null, "clockEventTransController");
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
