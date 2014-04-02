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
package net.xpresstek.zroster.ejb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import net.xpresstek.zroster.web.ClockEventFacade;
import net.xpresstek.zroster.web.ClockEventTransController;
import net.xpresstek.zroster.web.ControllerFactory;
import net.xpresstek.zroster.web.WeeklyHoursController;
import net.xpresstek.zroster.web.util.TimeUtils;

/**
 *
 * @author Alex Pavlunenko <alexp at xpresstek.net>
 */
@SessionScoped
public class ClockEventDataManager implements Serializable{

    private Date current_date;
    private Date yesterday;
    private List<ClockEventTrans> weekEvents;
    private List<ClockEventTrans> currentEvents;
    private List<ClockEventTrans> yesterdayEvents;
    private final List<EmployeeHours> employeeHours;
    private List<WeeklyHours> weeklyHours;
    private List<WeeklyHours> dailyHours;

    private static ClockEventDataManager instance = null;

    public static ClockEventDataManager getInstance() {
        if (instance == null) {
            instance = new ClockEventDataManager();
        }

        return instance;
    }

    private ClockEventDataManager() {
        setCurrentDate(new Date());
        currentEvents = new ArrayList();
        yesterdayEvents = new ArrayList();
        employeeHours = new ArrayList();
        weeklyHours = new ArrayList();
        weekEvents = new ArrayList();
    }

    /**
     * @return currentEvents.
     */
    public List<ClockEventTrans> getCurrentEvents() {
        return currentEvents;
    }

    public final void setCurrentDate(Date date) {
        this.current_date = date != null ? date : new Date();
        Calendar cal = new GregorianCalendar();
        cal.setTime(current_date);
        cal.add(Calendar.DAY_OF_MONTH, -1);
        yesterday = cal.getTime();
    }

    /**
     * Fetches latest data from the database and performs necessary
     * calculations.
     */
    public void updateData() {
        currentEvents.clear();
        yesterdayEvents.clear();

        ClockEventTransController etc
                = ControllerFactory.getClockEventTransController();

        WeeklyHoursController whc
                = ControllerFactory.getWeeklyHoursController();

        if (etc != null && whc != null) {
            currentEvents = etc.findClockEventsByInterval(TimeUtils.getDayStart(current_date),
                    TimeUtils.getDayEnd(current_date));

            yesterdayEvents = etc.findClockEventsByInterval(TimeUtils.getDayStart(yesterday),
                    TimeUtils.getDayEnd(yesterday));

            dailyHours = whc.findTotalForPeriod(TimeUtils.getDayStart(current_date),
                    TimeUtils.getDayEnd(current_date));
            
            Calendar current_cal= new GregorianCalendar();
            current_cal.setTime(current_date);
            
            if(current_cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
            {
                current_cal.add(Calendar.DAY_OF_MONTH, -1);
            }
            Calendar week_start = TimeUtils.getWeekStart(false, current_cal);
            Calendar week_end = TimeUtils.getWeekEnd(false, current_cal);
            weeklyHours = whc.findTotalForPeriod(week_start.getTime(),
                    week_end.getTime());
            
            weekEvents =  etc.findClockEventsByInterval(week_start.getTime(),
                    week_end.getTime());

            calculateHours();
        }
    }

    /**
     * Calculates employee hours.
     */
    public void calculateHours() {

        employeeHours.clear();
        List<Employee> employees
                = ControllerFactory.
                getEmployeeController().getActiveEmployeesDirect();

        for (Employee employee : employees) {
            EmployeeHours eh = new EmployeeHours(employee);
            eh.setDayWorkedHours(calculateDailyWorkedHours(employee));
            eh.setDayScheduledHours(calculateDailyScheduledHours(employee));
            eh.setWeekWorkedHours(calculateWeeklyWorkedHours(employee));
            eh.setWeekScheduledHours(calculateWeeklyScheduledHours(employee));
            employeeHours.add(eh);
        }

    }


    /**
     * Calculates worked hours for a current week.
     *
     * @param employee Employee to perform calculation for.
     * @return Total worked hours for the week.
     */
    private double calculateWeeklyWorkedHours(Employee employee) {

        return calculateWorkedHours(employee,
               weekEvents);
    }

    /**
     * Calculates scheduled hours for a this week.
     *
     * @param employee Employee to perform calculation for.
     * @return Total worked hours for the day. List of the total worked hours
     * for this week.
     */
    private double calculateWeeklyScheduledHours(Employee employee) {

        double retval = 0;
      
        List<WeeklyHours> hours = findWeeklyHoursByEmployee(employee, weeklyHours);

        for (WeeklyHours h : hours) {
            if (h.getEmployee() != null
                    && h.getTotalMinutes() != null
                    && h.getTotalHours() != null) {
                retval += h.getTotalHours().doubleValue();
            }
        }
        return Math.round(retval * 4) / 4f;
    }

    /**
     * Calculates worked hours for a specified date.
     *
     * @param employee Employee to perform calculation for.
     * @return Total worked hours for a specified date.
     */
    public double calculateDailyWorkedHours(Employee employee) {

        return calculateWorkedHours(employee,
                currentEvents);
    }

    /**
     * Calculates daily scheduled hours for current employee.
     *
     * @param employee Employee to perform calculation for.
     * @return List of the total scheduled hours for a specified date.
     */
    private double calculateDailyScheduledHours(Employee employee) {

        double retval = 0;

        List<WeeklyHours> hours = findWeeklyHoursByEmployee(employee, dailyHours);

        for (WeeklyHours h : hours) {
            if (h.getEmployee() != null
                    && h.getTotalMinutes() != null
                    && h.getTotalHours() != null) {
                retval += h.getTotalHours().doubleValue();
            }
        }
        return Math.round(retval * 4) / 4f;

    }

    /**
     * Calculates worked hours for a specified employee and time period.
     *
     * @param employee Employee to calculate time for.
     * @param events
     * @return Worked hours
     */
    public double calculateWorkedHours(Employee employee,
            List<ClockEventTrans> events) {
        List<ClockEventTrans> clockevents
                = findClockEventsByEmployee(employee, events);

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

    private double calculateNextDayRollover(ClockEventTrans eventtrans) {
        double retval = 0;
        if (eventtrans.getClockEventid().getName()
                .equals(ClockEventFacade.CLOCK_OUT_NAME)) {

            List<ClockEventTrans> clockevents
                    = findClockEventsByEmployee(eventtrans.getEmployeeid(),
                            yesterdayEvents);

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
     * Fetches employee hours for a specified employee.
     *
     * @param e Employee to search for
     * @return Employee hours
     */
    public EmployeeHours getEmployeeHours(Employee e) {
        if(employeeHours.isEmpty())
        {
            updateData();
        }
        for (EmployeeHours eh : employeeHours) {
            if (eh.getEmployee().getPkID().equals(e.getPkID())) {
                return eh;
            }
        }
        return null;
    }

    /**
     * Retrieves clock events using employee id.
     *
     * @param employee Employee
     * @param allevents Events to search
     * @return List of the shifts that employee is schedules to work.
     */
    public static List<ClockEventTrans> findClockEventsByEmployee(Employee employee, List<ClockEventTrans> allevents) {

        List<ClockEventTrans> events = new ArrayList();
        for (ClockEventTrans event : allevents) {
            if (event.getEmployeeid().getPkID().equals(employee.getPkID())) {
                events.add(event);
            }

        }
        return events;
    }

    /**
     * EmployeeHours accessor
     *
     * @return EmplyoeeHours
     */
    public List<EmployeeHours> getEmployeeHours() {
        return employeeHours;
    }

    /**
     * EmployeeHours accessor for active employees
     *
     * @return EmplyoeeHours
     */
    public List<EmployeeHours> getActiveEmployeeHours() {
        List<EmployeeHours> hours = new ArrayList();
        for (EmployeeHours hr : employeeHours) {
            if (hr.getEmployee().getIsActive()) {
                hours.add(hr);
            }
        }
        return hours;
    }

    public static List<WeeklyHours> findWeeklyHoursByEmployee(Employee employee,
            List<WeeklyHours> allhours) {
        List<WeeklyHours> retval = new ArrayList();
        for (WeeklyHours wh : allhours) {
            if (wh.getEmployee().equals(employee.getName())) {
                retval.add(wh);
            }
        }
        return retval;
    }

}
