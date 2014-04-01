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
import net.xpresstek.zroster.ejb.Shift;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import net.xpresstek.zroster.ejb.ClockEventTrans;
import net.xpresstek.zroster.ejb.Employee;
import net.xpresstek.zroster.ejb.EmployeeHours;
import net.xpresstek.zroster.ejb.Position;
import net.xpresstek.zroster.ejb.ShiftColumn;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleModel;

@Named("shiftController")
@SessionScoped
public class ShiftController extends ControllerBase {

    private Shift current;
    private Date current_date;
    private int current_pkid;
    private ScheduleModel shiftModel;
    @EJB
    private net.xpresstek.zroster.web.ShiftFacade ejbFacade;
    private List<ShiftColumn> columns;

    public ShiftController() {
        Date dt = new Date();
        String str_dt = DateUtils.DateToString(dt);
        str_dt = str_dt.substring(0, 11);
        str_dt += "00:00:00.0";

        current_date = DateUtils.StringToDate(str_dt);

        current_pkid = 0;
        prepareCreate();
    }

    @Override
    AbstractFacade getFacade() {
        return ejbFacade;
    }

    private void buildModel() {
        List<Shift> shifts = ejbFacade.findAll();
        shiftModel = new DefaultScheduleModel();
        for (Shift s : shifts) {
            String title = s.getEmployeeObject().getName();
            shiftModel.addEvent(new DefaultScheduleEvent(title, s.getStart(), s.getEnd()));
        }
    }

    public List<EmployeeHours> getCurrentEmployeeHours() {
        ClockEventTransController transcontroller = ControllerFactory.getClockEventTransController();
        transcontroller.setCurrent_date(current_date);
        List<ClockEventTrans> events = transcontroller.getCurrentEvents();

        EmployeeController employeeController = ControllerFactory.getEmployeeController();
        return employeeController.getCurrentEmployeeHours(events);
    }

    /**
     * Calculates scheduled and worked hours for all active employees.
     *
     * @return List of the employee hours.
     */
    public List<EmployeeHours> getActiveEmployeeHours() {
        EmployeeController employeeController = ControllerFactory.getEmployeeController();
        return employeeController.getCurrentEmployeeHours(current_date, true);
    }

    public ScheduleModel getEventModel() {
        buildModel();
        return shiftModel;
    }

    public int getCurrent_pkid() {
        return current_pkid;
    }

    public void setCurrent_pkid(int current_pkid) {
        this.current_pkid = current_pkid;
        this.current = ejbFacade.find(current_pkid);
    }

    public Shift getShift(Integer id) {
        return (Shift) getObject(id);
    }

    @Override
    public void setCurrent(Object obj) {
        current = (Shift) obj;
    }

    @Override
    void createNewCurrent() {
        current = new Shift();
    }

    public Date getCurrent_date() {
        return current_date;
    }

    public void setCurrent_date(Date current_date) {
        this.current_date = current_date;
        reset();
    }

    public List<Shift> getByStartAndEmployee(int id, Date start) {
        Calendar today = new GregorianCalendar();
        today.set(Calendar.HOUR_OF_DAY, 0);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);
        Date dt_start = today.getTime();
        if (start != null) {
            dt_start = start;
        }

        return ejbFacade.findByStartAndEmployee(dt_start, id);
    }

    public List<ShiftColumn> getShiftColumns() {

        if (columns == null || columns.isEmpty()) {
            List<Position> pos = ControllerFactory.getPositionController().getAllItems();
            List<Shift> shifts = ejbFacade.findByStart1AndStart2(current_date);
            columns = new ArrayList();

            for (Position p : pos) {

                Iterator<Shift> iter = shifts.iterator();
                List<Shift> a_shifts=new ArrayList();
                while (iter.hasNext()) {
                    Shift s=iter.next();
                   if (s.getPositionID() == p.getPkID()) {
                        a_shifts.add(s);                        
                        iter.remove();
                    }
                }
                
                if(a_shifts.size() > 0)
                {
                    columns.add(new ShiftColumn(a_shifts, p));
                    a_shifts.clear();
                }
            }
        }
        return columns;
    }

    public Object addShift() {
        if (current != null) {
            super.create();
        }
        reset();
        return null;
    }

    public Object reset() {

        columns = null;
        current_pkid = 0;
        prepareCreate();
        return null;
    }

    public Object updateShift() {
        if (current != null) {
            current.setPkid(current_pkid);
            super.update();
        }
        reset();
        return null;
    }

    public Object deleteShift() {
        if (current != null) {
            super.destroy();
        }
        reset();
        return null;
    }

    public String convertDateToTimeLabel(Date date) {
        String strdate = DateUtils.DateToString(date);
        if (strdate != null) {
            return strdate.substring(11, 16);
        }
        return null;
    }

    public List<Shift> getAllItems() {
        return ejbFacade.findAll();
    }

    public List getStartTimes() {
        String strdate = DateUtils.DateToString(current_date);
        strdate = strdate.substring(0, 10);
        return ControllerFactory.getConfigurationController().getTimeSlotsDate(strdate);
    }

    public List getEndTimes() {
        if (current == null) {
            return null;
        }
        List startTimes = getStartTimes();
        int index = startTimes.indexOf(current.getStart());
        index = index < 0 ? 0 : index;
        if (index >= startTimes.size()) {
            return null;
        }
        return startTimes.subList(index + 1, startTimes.size());
    }

    public List<Employee> getAvailableEmployees() {
        List<Employee> empl = ControllerFactory.getEmployeeController().
                getAllowedItems(current.getPositionID(),
                DateUtils.DateToString(current.getStart()),
                DateUtils.DateToString(current.getEnd()));
        if (empl == null) {
            return null;
        }
        List<Shift> s = ejbFacade.findByStartandEnd(current.getStart(), current.getEnd());
        for (Shift sh : s) {
            empl.remove(sh.getEmployeeObject());
        }

        if (checkCurrentEmployee()) {
            empl.add(current.getEmployeeObject());
        }
        return empl;
    }

    public boolean checkCurrentEmployee() {
        if (current_pkid > 0 && current != null) {
            if (EmployeeController.isEmployeeAllowed(current.getEmployeeObject(),
                    current.getPositionID(),
                    DateUtils.DateToString(current.getStart()),
                    DateUtils.DateToString(current.getEnd()))) {
                List<Shift> s = ejbFacade.findByEmployeeIDAndStart(current.getEmployeeObject().getPkID(),
                        current.getStart(),
                        current.getEnd());
                if (s == null || s.isEmpty()) {
                    return true;
                } else if (s.size() == 1) {
                    Shift shift = s.get(0);
                    if (shift.getPkid() == current.getPkid()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void processShiftClick(String position, String time) {
        int i;
    }

    public List<Shift> getItemsFromTheWeekStart() {
        Calendar start = new GregorianCalendar();
        start.set(Calendar.HOUR_OF_DAY, 0);
        start.set(Calendar.MINUTE, 0);
        start.set(Calendar.SECOND, 0);
        Date dt_start = DateUtils.getWeekStart(false, start).getTime();
        return ejbFacade.findByStart(dt_start);
    }

    @Override
    Object getCurrent() {
        return current;
    }

    @FacesConverter(forClass = Shift.class)
    public static class ShiftControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ShiftController controller = (ShiftController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "shiftController");
            return controller.getShift(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        public static ShiftController getController() {
            FacesContext fc = FacesContext.getCurrentInstance();
            return (ShiftController) fc.getApplication().getELResolver().
                    getValue(fc.getELContext(), null, "shiftController");
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
            if (object instanceof Shift) {
                Shift o = (Shift) object;
                return getStringKey(o.getPkid());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Shift.class.getName());
            }
        }
    }

    @FacesConverter(forClass = java.util.Date.class, value = "shiftDateConverter")
    public static class ShiftControllerDateConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            Date test = DateUtils.StringToDate(value);
            return DateUtils.StringToDate(value);
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            return DateUtils.DateToString((Date) object);
        }
    }
}
