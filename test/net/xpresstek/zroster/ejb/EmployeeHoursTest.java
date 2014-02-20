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
public class EmployeeHoursTest {
    
    public EmployeeHoursTest() {
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
     * Test of calculateHours method, of class EmployeeHours.
     */
    @Test
    public void testCalculateHours() {
        System.out.println("calculateHours");
        Date date = null;
        EmployeeHours instance = null;
        instance.calculateHours(date);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculateDailyWorkedHours method, of class EmployeeHours.
     */
    @Test
    public void testCalculateDailyWorkedHours() {
        System.out.println("calculateDailyWorkedHours");
        Date date = null;
        EmployeeHours instance = null;
        double expResult = 0.0;
        double result = instance.calculateDailyWorkedHours(date);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDayScheduledHours method, of class EmployeeHours.
     */
    @Test
    public void testGetDayScheduledHours() {
        System.out.println("getDayScheduledHours");
        EmployeeHours instance = null;
        double expResult = 0.0;
        double result = instance.getDayScheduledHours();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDayScheduledHours method, of class EmployeeHours.
     */
    @Test
    public void testSetDayScheduledHours() {
        System.out.println("setDayScheduledHours");
        double todayScheduledHours = 0.0;
        EmployeeHours instance = null;
        instance.setDayScheduledHours(todayScheduledHours);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDayWorkedHours method, of class EmployeeHours.
     */
    @Test
    public void testGetDayWorkedHours() {
        System.out.println("getDayWorkedHours");
        EmployeeHours instance = null;
        double expResult = 0.0;
        double result = instance.getDayWorkedHours();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDayWorkedHours method, of class EmployeeHours.
     */
    @Test
    public void testSetDayWorkedHours() {
        System.out.println("setDayWorkedHours");
        double todayWorkedHours = 0.0;
        EmployeeHours instance = null;
        instance.setDayWorkedHours(todayWorkedHours);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDayRemainingHours method, of class EmployeeHours.
     */
    @Test
    public void testGetDayRemainingHours() {
        System.out.println("getDayRemainingHours");
        EmployeeHours instance = null;
        double expResult = 0.0;
        double result = instance.getDayRemainingHours();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDayRemainingHours method, of class EmployeeHours.
     */
    @Test
    public void testSetDayRemainingHours() {
        System.out.println("setDayRemainingHours");
        double todayRemainingHours = 0.0;
        EmployeeHours instance = null;
        instance.setDayRemainingHours(todayRemainingHours);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWeekScheduledHours method, of class EmployeeHours.
     */
    @Test
    public void testGetWeekScheduledHours() {
        System.out.println("getWeekScheduledHours");
        EmployeeHours instance = null;
        double expResult = 0.0;
        double result = instance.getWeekScheduledHours();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setWeekScheduledHours method, of class EmployeeHours.
     */
    @Test
    public void testSetWeekScheduledHours() {
        System.out.println("setWeekScheduledHours");
        double weekScheduledHours = 0.0;
        EmployeeHours instance = null;
        instance.setWeekScheduledHours(weekScheduledHours);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWeekWorkedHours method, of class EmployeeHours.
     */
    @Test
    public void testGetWeekWorkedHours() {
        System.out.println("getWeekWorkedHours");
        EmployeeHours instance = null;
        double expResult = 0.0;
        double result = instance.getWeekWorkedHours();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setWeekWorkedHours method, of class EmployeeHours.
     */
    @Test
    public void testSetWeekWorkedHours() {
        System.out.println("setWeekWorkedHours");
        double weekWorkedHours = 0.0;
        EmployeeHours instance = null;
        instance.setWeekWorkedHours(weekWorkedHours);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWeekRemainingHours method, of class EmployeeHours.
     */
    @Test
    public void testGetWeekRemainingHours() {
        System.out.println("getWeekRemainingHours");
        EmployeeHours instance = null;
        double expResult = 0.0;
        double result = instance.getWeekRemainingHours();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setWeekRemainingHours method, of class EmployeeHours.
     */
    @Test
    public void testSetWeekRemainingHours() {
        System.out.println("setWeekRemainingHours");
        double weekRemainingHours = 0.0;
        EmployeeHours instance = null;
        instance.setWeekRemainingHours(weekRemainingHours);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmployee method, of class EmployeeHours.
     */
    @Test
    public void testGetEmployee() {
        System.out.println("getEmployee");
        EmployeeHours instance = null;
        Employee expResult = null;
        Employee result = instance.getEmployee();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmployee method, of class EmployeeHours.
     */
    @Test
    public void testSetEmployee() {
        System.out.println("setEmployee");
        Employee employee = null;
        EmployeeHours instance = null;
        instance.setEmployee(employee);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
