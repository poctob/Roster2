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
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apavlune
 */
public class TimeUtilsTest {
    
    public TimeUtilsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getDayStart method, of class TimeUtils.
     */
    @Test
    public void testGetDayStart() {
        System.out.println("getDayStart");
        Date date = null;
        Date expResult = null;
        Date result = TimeUtils.getDayStart(date);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDayEnd method, of class TimeUtils.
     */
    @Test
    public void testGetDayEnd() {
        System.out.println("getDayEnd");
        Date date = null;
        Date expResult = null;
        Date result = TimeUtils.getDayEnd(date);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWeekStart method, of class TimeUtils.
     */
    @Test
    public void testGetWeekStart() {
        System.out.println("getWeekStart");
        boolean startSunday = false;
        Calendar date = null;
        Calendar expResult = null;
        Calendar result = TimeUtils.getWeekStart(startSunday, date);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWeekEnd method, of class TimeUtils.
     */
    @Test
    public void testGetWeekEnd() {
        System.out.println("getWeekEnd");
        boolean startSunday = false;
        Calendar date = null;
        Calendar expResult = null;
        Calendar result = TimeUtils.getWeekEnd(startSunday, date);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
