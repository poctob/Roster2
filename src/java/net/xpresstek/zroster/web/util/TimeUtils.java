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
package net.xpresstek.zroster.web.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author apavlune
 */
public class TimeUtils {

    /**
     * Calculates start of the day
     *
     * @param date Date to use in calculation
     * @return Date with hour min and sec set to 0
     */
    public static Date getDayStart(Date date) {
        Calendar start = new GregorianCalendar();
        start.setTime(date);
        start.set(Calendar.HOUR_OF_DAY, 0);
        start.set(Calendar.MINUTE, 0);
        start.set(Calendar.SECOND, 0);
        return start.getTime();
    }

    /**
     * Calculates end of the day
     *
     * @param date Date to use in calculation
     * @return Date with hour set to 23 min and sec set to 59
     */
    public static Date getDayEnd(Date date) {
        Calendar end = new GregorianCalendar();
        end.setTime(date);
        end.set(Calendar.HOUR_OF_DAY, 23);
        end.set(Calendar.MINUTE, 59);
        end.set(Calendar.SECOND, 59);
        return end.getTime();
    }

    /**
     * Returns a date corresponding to the first day of the week.
     *
     * @param startSunday Whether the week starts on Sunday.
     * @param date A date to calculate the start for.
     * @return Calendar representation of the first day of the week.
     */
    public static Calendar getWeekStart(boolean startSunday, Calendar date) {
        
        Calendar start=new GregorianCalendar();
        if (date != null) {
            start.setTime(date.getTime());
        }
        int current_dow = start.get(Calendar.DAY_OF_WEEK);
        start.add(Calendar.DAY_OF_MONTH, -current_dow);
        start.add(Calendar.DAY_OF_MONTH, startSunday ? Calendar.SUNDAY : 
                Calendar.MONDAY);
        start.setTime(getDayStart(start.getTime()));
        return start;
    }

    /**
     * Returns a date corresponding to the last day of the week.
     *
     * @param startSunday Whether the week starts on Sunday.
     * @param date A date to calculate the end for.
     * @return Calendar representation of the last day of the week.
     */
    public static Calendar getWeekEnd(boolean startSunday, Calendar date) {
        if (date == null) {
            date = new GregorianCalendar();
        }
        Calendar end = getWeekStart(startSunday, date);
        end.add(Calendar.DAY_OF_MONTH, 6);
        end.setTime(getDayEnd(end.getTime()));
        return end;

    }
}
