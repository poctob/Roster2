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

import java.util.Date;
import java.util.List;
import javax.faces.model.DataModel;
import net.xpresstek.zroster.ejb.WeeklyHours;
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
public class WeeklyHoursControllerTest {
    
    public WeeklyHoursControllerTest() {
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
     * Test of getItems method, of class WeeklyHoursController.
     */
    @Test
    public void testGetItems() {
        System.out.println("getItems");
        WeeklyHoursController instance = new WeeklyHoursController();
        DataModel expResult = null;
        DataModel result = instance.getItems();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFacade method, of class WeeklyHoursController.
     */
    @Test
    public void testGetFacade() {
        System.out.println("getFacade");
        WeeklyHoursController instance = new WeeklyHoursController();
        AbstractFacade expResult = null;
        AbstractFacade result = instance.getFacade();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWeeklyHoursFacade method, of class WeeklyHoursController.
     */
    @Test
    public void testGetWeeklyHoursFacade() {
        System.out.println("getWeeklyHoursFacade");
        WeeklyHoursController instance = new WeeklyHoursController();
        WeeklyHoursFacade expResult = null;
        WeeklyHoursFacade result = instance.getWeeklyHoursFacade();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrent method, of class WeeklyHoursController.
     */
    @Test
    public void testGetCurrent() {
        System.out.println("getCurrent");
        WeeklyHoursController instance = new WeeklyHoursController();
        Object expResult = null;
        Object result = instance.getCurrent();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCurrent method, of class WeeklyHoursController.
     */
    @Test
    public void testSetCurrent() {
        System.out.println("setCurrent");
        Object obj = null;
        WeeklyHoursController instance = new WeeklyHoursController();
        instance.setCurrent(obj);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createNewCurrent method, of class WeeklyHoursController.
     */
    @Test
    public void testCreateNewCurrent() {
        System.out.println("createNewCurrent");
        WeeklyHoursController instance = new WeeklyHoursController();
        instance.createNewCurrent();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWeeklyHours method, of class WeeklyHoursController.
     */
    @Test
    public void testGetWeeklyHours() {
        System.out.println("getWeeklyHours");
        String id = "";
        WeeklyHoursController instance = new WeeklyHoursController();
        WeeklyHours expResult = null;
        WeeklyHours result = instance.getWeeklyHours(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWeeklyHoursByEmployee method, of class WeeklyHoursController.
     */
    @Test
    public void testGetWeeklyHoursByEmployee() {
        System.out.println("getWeeklyHoursByEmployee");
        String name = "";
        WeeklyHoursController instance = new WeeklyHoursController();
        List<WeeklyHours> expResult = null;
        List<WeeklyHours> result = instance.getWeeklyHoursByEmployee(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWeeklyHoursByDate method, of class WeeklyHoursController.
     */
    @Test
    public void testGetWeeklyHoursByDate() {
        System.out.println("getWeeklyHoursByDate");
        Date date = null;
        WeeklyHoursController instance = new WeeklyHoursController();
        List<WeeklyHours> expResult = null;
        List<WeeklyHours> result = instance.getWeeklyHoursByDate(date);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDailyHoursByDate method, of class WeeklyHoursController.
     */
    @Test
    public void testGetDailyHoursByDate() {
        System.out.println("getDailyHoursByDate");
        Date date = null;
        WeeklyHoursController instance = new WeeklyHoursController();
        List<WeeklyHours> expResult = null;
        List<WeeklyHours> result = instance.getDailyHoursByDate(date);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
