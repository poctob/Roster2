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

import com.gzlabs.utils.DateUtils;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import net.xpresstek.zroster.web.ClockEventTransController;
import net.xpresstek.zroster.web.WeeklyHoursController;
import net.xpresstek.zroster.web.WeeklyHoursFacade;
import net.xpresstek.zroster.web.util.TimeUtils;

/**
 *
 * @author apavlune
 */
public class EmployeeHours {

    private Employee employee;

    private double dayScheduledHours = 0;
    private double dayWorkedHours = 0;
    private double dayRemainingHours = 0;
    private double weekScheduledHours = 0;
    private double weekWorkedHours = 0;
    private double weekRemainingHours = 0;

    public EmployeeHours(Employee employee) {
        this.employee = employee;
    }

    public void calculateHours(Date date) {
        Date current_date = new Date();
        if (date != null) {
            current_date = date;
        }

        setWeekWorkedHours(calculateWeeklyWorkedHours(current_date));
        setWeekScheduledHours(calculateWeeklyScheduledHours(current_date));
        setDayScheduledHours(calculateDailyScheduledHours(current_date));
        setDayWorkedHours(calculateDailyWorkedHours(current_date));
    }

    /**
     * Calculates worked hours for a specified week.
     *
     * @param date Date to check.
     * @return Total worked hours for the week.
     */
    private double calculateWeeklyWorkedHours(Date date) {

        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        Calendar start = TimeUtils.getWeekStart(false, cal);
        Calendar end = TimeUtils.getWeekEnd(false, cal);
        ClockEventTransController econtroller
                = ClockEventTransController.ClockEventTransControllerConverter.getController();

        return econtroller.calculateWorkedHours(employee,
                start.getTime(), end.getTime());
    }

    /**
     * Calculates scheduled hours for a this week.
     *
     * @return Total worked hours for the day. List of the total worked hours
     * for this week.
     */
    private double calculateWeeklyScheduledHours(Date date) {

        double retval = 0;
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        Calendar start = TimeUtils.getWeekStart(false, cal);
        Calendar end = TimeUtils.getWeekEnd(false, cal);

        WeeklyHoursFacade weeklyFacade
                = WeeklyHoursController.WeeklyHoursControllerConverter.
                getController().
                getWeeklyHoursFacade();

        List<WeeklyHours> hours = weeklyFacade.findTotalForPeriodByEmployee(
                start.getTime(), end.getTime(),
                employee.getName());

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
     * @param date Date to check.
     * @return Total worked hours for a specified date.
     */
    public double calculateDailyWorkedHours(Date date) {

        ClockEventTransController econtroller
                = ClockEventTransController.
                        ClockEventTransControllerConverter.getController();

        return econtroller.calculateWorkedHours(employee,
                TimeUtils.getDayStart(date),
                TimeUtils.getDayEnd(date));
    }

    /**
     * Calculates daily scheduled hours for current employee.
     *
     * @param date Date to check.
     * @return List of the total scheduled hours for a specified date.
     */
    private double calculateDailyScheduledHours(Date date) {

        double retval = 0;

        WeeklyHoursFacade weeklyFacade
                = WeeklyHoursController.WeeklyHoursControllerConverter.getController().
                getWeeklyHoursFacade();

        List<WeeklyHours> hours = weeklyFacade.findTotalForPeriodByEmployee(
                TimeUtils.getDayStart(date),
                TimeUtils.getDayEnd(date),
                employee.getName());

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
     *
     * @return Scheduled hours for today.
     */
    public double getDayScheduledHours() {
        return dayScheduledHours;

    }

    /**
     * Setter for today's scheduled hours
     *
     * @param todayScheduledHours
     */
    public void setDayScheduledHours(double todayScheduledHours) {
        this.dayScheduledHours = todayScheduledHours;
        this.dayRemainingHours
                = this.dayScheduledHours - this.dayWorkedHours;
    }

    /**
     *
     * @return Worked hours for today
     */
    public double getDayWorkedHours() {
        return dayWorkedHours;
    }

    /**
     * Setter for today's worked hours
     *
     * @param todayWorkedHours
     */
    public void setDayWorkedHours(double todayWorkedHours) {
        this.dayWorkedHours = todayWorkedHours;
        this.dayRemainingHours
                = this.dayScheduledHours - this.dayWorkedHours;
    }

    /**
     *
     * @return todays Worked hours
     */
    public double getDayRemainingHours() {
        return dayRemainingHours;
    }

    /**
     * Setter for today's worked hours
     *
     * @param todayRemainingHours
     */
    public void setDayRemainingHours(double todayRemainingHours) {
        this.dayRemainingHours = todayRemainingHours;

    }

    /**
     *
     * @return Scheduled hours for the week
     */
    public double getWeekScheduledHours() {
        return weekScheduledHours;
    }

    /**
     * Setter for scheduled hours for the week
     *
     * @param weekScheduledHours
     */
    public void setWeekScheduledHours(double weekScheduledHours) {
        this.weekScheduledHours = weekScheduledHours;
        this.weekRemainingHours
                = this.weekScheduledHours - this.weekWorkedHours;
    }

    /**
     *
     * @return Worked hours for the week
     */
    public double getWeekWorkedHours() {
        return weekWorkedHours;
    }

    /**
     * Setter for worked hours for the week
     *
     * @param weekWorkedHours
     */
    public void setWeekWorkedHours(double weekWorkedHours) {
        this.weekWorkedHours = weekWorkedHours;
        this.weekRemainingHours
                = this.weekScheduledHours - this.weekWorkedHours;
    }

    /**
     *
     * @return Remaining hours for the week
     */
    public double getWeekRemainingHours() {
        return weekRemainingHours;
    }

    /**
     * Setter for the remaining hours for the week
     *
     * @param weekRemainingHours
     */
    public void setWeekRemainingHours(double weekRemainingHours) {
        this.weekRemainingHours = weekRemainingHours;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    
    
}
