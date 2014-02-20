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

import java.util.List;
import net.xpresstek.zroster.ejb.Employee;
import net.xpresstek.zroster.ejb.TimeOff;
import net.xpresstek.zroster.ejb.TimeOffStatus;
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
public class TimeOffControllerTest {
    
    public TimeOffControllerTest() {
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
     * Test of getCurrent_filter method, of class TimeOffController.
     */
    @Test
    public void testGetCurrent_filter() {
        System.out.println("getCurrent_filter");
        TimeOffController instance = new TimeOffController();
        String expResult = "";
        String result = instance.getCurrent_filter();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCurrent_filter method, of class TimeOffController.
     */
    @Test
    public void testSetCurrent_filter() {
        System.out.println("setCurrent_filter");
        String current_filter = "";
        TimeOffController instance = new TimeOffController();
        instance.setCurrent_filter(current_filter);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFilterOptions method, of class TimeOffController.
     */
    @Test
    public void testGetFilterOptions() {
        System.out.println("getFilterOptions");
        TimeOffController instance = new TimeOffController();
        List<String> expResult = null;
        List<String> result = instance.getFilterOptions();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFilterOptions method, of class TimeOffController.
     */
    @Test
    public void testSetFilterOptions() {
        System.out.println("setFilterOptions");
        List<String> filterOptions = null;
        TimeOffController instance = new TimeOffController();
        instance.setFilterOptions(filterOptions);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDefaultFilter method, of class TimeOffController.
     */
    @Test
    public void testGetDefaultFilter() {
        System.out.println("getDefaultFilter");
        TimeOffController instance = new TimeOffController();
        String expResult = "";
        String result = instance.getDefaultFilter();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFacade method, of class TimeOffController.
     */
    @Test
    public void testGetFacade() {
        System.out.println("getFacade");
        TimeOffController instance = new TimeOffController();
        AbstractFacade expResult = null;
        AbstractFacade result = instance.getFacade();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrent method, of class TimeOffController.
     */
    @Test
    public void testGetCurrent() {
        System.out.println("getCurrent");
        TimeOffController instance = new TimeOffController();
        Object expResult = null;
        Object result = instance.getCurrent();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFilteredTimeOffs method, of class TimeOffController.
     */
    @Test
    public void testGetFilteredTimeOffs() {
        System.out.println("getFilteredTimeOffs");
        TimeOffController instance = new TimeOffController();
        List<TimeOff> expResult = null;
        List<TimeOff> result = instance.getFilteredTimeOffs();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFilteredTimeOffs method, of class TimeOffController.
     */
    @Test
    public void testSetFilteredTimeOffs() {
        System.out.println("setFilteredTimeOffs");
        List<TimeOff> filteredTimeOffs = null;
        TimeOffController instance = new TimeOffController();
        instance.setFilteredTimeOffs(filteredTimeOffs);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of prepareCreate method, of class TimeOffController.
     */
    @Test
    public void testPrepareCreate() {
        System.out.println("prepareCreate");
        Employee empl = null;
        TimeOffStatus to = null;
        TimeOffController instance = new TimeOffController();
        instance.prepareCreate(empl, to);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createOrUpdate method, of class TimeOffController.
     */
    @Test
    public void testCreateOrUpdate() {
        System.out.println("createOrUpdate");
        TimeOffController instance = new TimeOffController();
        instance.createOrUpdate();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of prepareEdit method, of class TimeOffController.
     */
    @Test
    public void testPrepareEdit() {
        System.out.println("prepareEdit");
        int id = 0;
        TimeOffController instance = new TimeOffController();
        instance.prepareEdit(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTimeOff method, of class TimeOffController.
     */
    @Test
    public void testGetTimeOff() {
        System.out.println("getTimeOff");
        Integer id = null;
        TimeOffController instance = new TimeOffController();
        TimeOff expResult = null;
        TimeOff result = instance.getTimeOff(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByEmployeeID method, of class TimeOffController.
     */
    @Test
    public void testFindByEmployeeID() {
        System.out.println("findByEmployeeID");
        Employee empl = null;
        TimeOffController instance = new TimeOffController();
        List<TimeOff> expResult = null;
        List<TimeOff> result = instance.findByEmployeeID(empl);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getActiveTimeOffs method, of class TimeOffController.
     */
    @Test
    public void testGetActiveTimeOffs() {
        System.out.println("getActiveTimeOffs");
        TimeOffController instance = new TimeOffController();
        List<TimeOff> expResult = null;
        List<TimeOff> result = instance.getActiveTimeOffs();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCurrentById method, of class TimeOffController.
     */
    @Test
    public void testSetCurrentById() {
        System.out.println("setCurrentById");
        Integer id = null;
        TimeOffController instance = new TimeOffController();
        instance.setCurrentById(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCurrent method, of class TimeOffController.
     */
    @Test
    public void testSetCurrent() {
        System.out.println("setCurrent");
        Object obj = null;
        TimeOffController instance = new TimeOffController();
        instance.setCurrent(obj);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createNewCurrent method, of class TimeOffController.
     */
    @Test
    public void testCreateNewCurrent() {
        System.out.println("createNewCurrent");
        TimeOffController instance = new TimeOffController();
        instance.createNewCurrent();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
