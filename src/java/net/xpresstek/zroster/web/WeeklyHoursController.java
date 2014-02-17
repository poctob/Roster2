package net.xpresstek.zroster.web;

import com.gzlabs.utils.DateUtils;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import net.xpresstek.zroster.ejb.WeeklyHours;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import net.xpresstek.zroster.ejb.ClockEventTrans;
import net.xpresstek.zroster.ejb.Employee;
import net.xpresstek.zroster.web.ClockEventTransController.ClockEventTransControllerConverter;
import net.xpresstek.zroster.web.EmployeeController.EmployeeControllerConverter;
import net.xpresstek.zroster.web.util.TimeUtils;

@Named("weeklyHoursController")
@SessionScoped
public class WeeklyHoursController extends ControllerBase {

    private WeeklyHours current;
    @EJB
    private net.xpresstek.zroster.web.WeeklyHoursFacade ejbFacade;

    public WeeklyHoursController() {
    }

    @Override
    public DataModel getItems() {
        if (ejbFacade != null) {
            ejbFacade.refreshData();
        }
        recreateModel();
        return super.getItems();
    }

    @Override
    AbstractFacade getFacade() {
        return ejbFacade;
    }

    @Override
    Object getCurrent() {
        return current;
    }

    @Override
    void setCurrent(Object obj) {
        current = (WeeklyHours) obj;
    }

    @Override
    void createNewCurrent() {
        current = new WeeklyHours();
    }

    public WeeklyHours getWeeklyHours(String id) {
        return (WeeklyHours) getObject(id);
    }

    public List<WeeklyHours> getWeeklyHoursByEmployee(String name) {
        return ejbFacade.findByEmployee(name);
    }

    public List<WeeklyHours> getWeeklyHoursByDate(Date date) {
        Calendar cdate = new GregorianCalendar();
        cdate.setTime(date);

        //Hack to get week start on monday
        if (cdate.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            cdate.add(Calendar.DAY_OF_MONTH, -1);
        }

        Calendar start = DateUtils.getWeekStart(false, cdate);
        Calendar end = new GregorianCalendar();
        end.setTime(start.getTime());
        end.add(Calendar.DAY_OF_MONTH, 6);

        if (ejbFacade != null) {
            ejbFacade.refreshData();
        }
        recreateModel();

        return ejbFacade.findTotalForPeriod(start.getTime(),
                TimeUtils.getDayEnd(end.getTime()));
    }
       

    /**
     * Returns total worked hours for a specified date.
     *
     * @param date Date to check.
     * @return List of the total worked hours for a specified date.
     */
    public List<WeeklyHours> getDailyHoursByDate(Date date) {

        if (ejbFacade != null) {
            ejbFacade.refreshData();
        }
        recreateModel();

        return ejbFacade.findTotalForPeriod(
                TimeUtils.getDayStart(date),
                TimeUtils.getDayEnd(date));

    }

    /**
     * Returns total worked hours for a specified date.
     *
     * @param empl Employee name
     * @param date Date to check.
     * @return List of the total worked hours for a specified date.
     */
    public double getDailyHoursByEmployee(String empl, Date date) {

        double retval = 0;
        
        Date current_date = new Date();
        if (date != null) {
            current_date = date;
        }
        List<WeeklyHours> hours = ejbFacade.findTotalForPeriodByEmployee(
                TimeUtils.getDayStart(current_date),
                TimeUtils.getDayEnd(current_date),
                empl);
        for (WeeklyHours h : hours) {
            if(h.getEmployee() != null && 
                    h.getTotalMinutes()!=null &&
                    h.getTotalHours()!=null)
            {
                retval += h.getTotalHours().doubleValue();
            }
        }
        return Math.round(retval * 4) / 4f;
    }

    /**
     * Calculates worked hours for a specified date.
     *
     * @param employee Employee
     * @param date Date
     * @return Total worked hours for the day.
     */
    public double getDailyWorkedHours(String employee, Date date) {
        Employee empl
                = EmployeeControllerConverter.getController().
                getEmployeeByName(employee);

        Date current_date = new Date();
        if (date != null) {
            current_date = date;
        }

        return calculateWorkedHours(empl,
                TimeUtils.getDayStart(current_date),
                TimeUtils.getDayEnd(current_date));
    }
    
    public double getDailyRemainingHours(String employee, Date date)
    {
        return getDailyHoursByEmployee(employee, date) - 
                getDailyWorkedHours(employee, date);
    }
    
     /**
     * Returns total worked hours for a specified date.
     *
     * @param empl Employee name
     * @return List of the total worked hours for a specified date.
     */
    public double getWeeklyHoursByEmployeeDouble(String empl) {

        double retval = 0;        
        
        List<WeeklyHours> hours = getWeeklyHoursByEmployee(empl);
        for (WeeklyHours h : hours) {
            if(h.getEmployee() != null && 
                    h.getTotalMinutes()!=null &&
                    h.getTotalHours()!=null)
            {
                retval += h.getTotalHours().doubleValue();
            }
        }
        return Math.round(retval * 4) / 4f;
    }

    /**
     * Calculates worked hours for a specified date.
     *
     * @param employee Employee
     * @param date Date
     * @return Total worked hours for the day.
     */
    public double getWeeklyWorkedHours(String employee) {
        Employee empl
                = EmployeeControllerConverter.getController().
                getEmployeeByName(employee);

        Date current_date = new Date();
        Calendar cal=new GregorianCalendar();
        Calendar start = DateUtils.getWeekStart(false, cal);
        Calendar end = DateUtils.getWeekEnd(false, cal);

        return calculateWorkedHours(empl,
                start.getTime(), end.getTime());
    }
    
    public double getWeeklyRemainingHours(String employee)
    {
        return getWeeklyHoursByEmployeeDouble(employee) - 
                getWeeklyWorkedHours(employee);
    }

    /**
     * Calculates worked hours for a specified employee and time period.
     *
     * @param employee Employee to calculate time for.
     * @param start Start of a period
     * @param end End of a period.
     * @return Worked hours
     */
    private double calculateWorkedHours(Employee employee,
            Date start,
            Date end) {
        List<ClockEventTrans> clockevents
                = ClockEventTransControllerConverter.getController().
                findClockEventsByEmployeeAndInterval(employee, start, end);

        Collections.sort(clockevents);

        double interval = 0;
        ClockEventTrans current;
        for (int i = 0; i < clockevents.size(); i++) {

            current = clockevents.get(i);

            if (current != null
                    && current.getClockEventid().getName().
                    equals(ClockEventFacade.CLOCK_IN_NAME)) {

                int next = i + 1;
                if (next < clockevents.size()) {
                    ClockEventTrans next_event = clockevents.get(next);
                    if (next_event != null
                            && next_event.getClockEventid().getName()
                            .equals(ClockEventFacade.CLOCK_OUT_NAME)) {
                        double millis = next_event.getTimestamp().getTime()
                                - current.getTimestamp().getTime();

                        interval += (millis / 1000) / 3600;
                    }
                }

            }

        }
        return Math.round(interval * 4) / 4f;
    }

    @FacesConverter(forClass = WeeklyHours.class)
    public static class WeeklyHoursControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            WeeklyHoursController controller = (WeeklyHoursController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "weeklyHoursController");
            return controller.getWeeklyHours(value);
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof WeeklyHours) {
                WeeklyHours o = (WeeklyHours) object;
                return o.getEmployee();
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + WeeklyHours.class.getName());
            }
        }
    }
}
