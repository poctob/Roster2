/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
     * @param date Date to use in calculation
     * @return Date with hour min and sec set to 0
     */
    public static Date getDayStart(Date date)
    {
        Calendar start = new GregorianCalendar();
        start.setTime(date);
        start.set(Calendar.HOUR, 0);
        start.set(Calendar.MINUTE, 0);
        start.set(Calendar.SECOND, 0);
        return start.getTime();
    }
    
    /**
     * Calculates end of the day
     * @param date Date to use in calculation
     * @return Date with hour set to 23 min and sec set to 59
     */
     public static Date getDayEnd(Date date)
    {
        Calendar end = new GregorianCalendar();
        end.setTime(date);
        end.set(Calendar.HOUR, 23);
        end.set(Calendar.MINUTE, 59);
        end.set(Calendar.SECOND, 59);
        return end.getTime();
    }
}
