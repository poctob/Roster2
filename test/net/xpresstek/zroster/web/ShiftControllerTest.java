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
import net.xpresstek.zroster.ejb.Employee;
import net.xpresstek.zroster.ejb.EmployeeHours;
import net.xpresstek.zroster.ejb.Shift;
import net.xpresstek.zroster.ejb.ShiftColumn;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.primefaces.model.ScheduleModel;

/**
 *
 * @author apavlune
 */
public class ShiftControllerTest {
    
    public ShiftControllerTest() {
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
     * Test of getFacade method, of class ShiftController.
     */
    @Test
    public void testGetFacade() {
        System.out.println("getFacade");
        ShiftController instance = new ShiftController();
        AbstractFacade expResult = null;
        AbstractFacade result = instance.getFacade();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentEmployeeHours method, of class ShiftController.
     */
    @Test
    public void testGetCurrentEmployeeHours() {
        System.out.println("getCurrentEmployeeHours");
        ShiftController instance = new ShiftController();
        List<EmployeeHours> expResult = null;
        List<EmployeeHours> result = instance.getCurrentEmployeeHours();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getActiveEmployeeHours method, of class ShiftController.
     */
    @Test
    public void testGetActiveEmployeeHours() {
        System.out.println("getActiveEmployeeHours");
        ShiftController instance = new ShiftController();
        List<EmployeeHours> expResult = null;
        List<EmployeeHours> result = instance.getActiveEmployeeHours();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEventModel method, of class ShiftController.
     */
    @Test
    public void testGetEventModel() {
        System.out.println("getEventModel");
        ShiftController instance = new ShiftController();
        ScheduleModel expResult = null;
        ScheduleModel result = instance.getEventModel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrent_pkid method, of class ShiftController.
     */
    @Test
    public void testGetCurrent_pkid() {
        System.out.println("getCurrent_pkid");
        ShiftController instance = new ShiftController();
        int expResult = 0;
        int result = instance.getCurrent_pkid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCurrent_pkid method, of class ShiftController.
     */
    @Test
    public void testSetCurrent_pkid() {
        System.out.println("setCurrent_pkid");
        int current_pkid = 0;
        ShiftController instance = new ShiftController();
        instance.setCurrent_pkid(current_pkid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getShift method, of class ShiftController.
     */
    @Test
    public void testGetShift() {
        System.out.println("getShift");
        Integer id = null;
        ShiftController instance = new ShiftController();
        Shift expResult = null;
        Shift result = instance.getShift(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCurrent method, of class ShiftController.
     */
    @Test
    public void testSetCurrent() {
        System.out.println("setCurrent");
        Object obj = null;
        ShiftController instance = new ShiftController();
        instance.setCurrent(obj);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createNewCurrent method, of class ShiftController.
     */
    @Test
    public void testCreateNewCurrent() {
        System.out.println("createNewCurrent");
        ShiftController instance = new ShiftController();
        instance.createNewCurrent();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrent_date method, of class ShiftController.
     */
    @Test
    public void testGetCurrent_date() {
        System.out.println("getCurrent_date");
        ShiftController instance = new ShiftController();
        Date expResult = null;
        Date result = instance.getCurrent_date();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCurrent_date method, of class ShiftController.
     */
    @Test
    public void testSetCurrent_date() {
        System.out.println("setCurrent_date");
        Date current_date = null;
        ShiftController instance = new ShiftController();
        instance.setCurrent_date(current_date);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getByStartAndEmployee method, of class ShiftController.
     */
    @Test
    public void testGetByStartAndEmployee() {
        System.out.println("getByStartAndEmployee");
        int id = 0;
        Date start = null;
        ShiftController instance = new ShiftController();
        List<Shift> expResult = null;
        List<Shift> result = instance.getByStartAndEmployee(id, start);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getShiftColumns method, of class ShiftController.
     */
    @Test
    public void testGetShiftColumns() {
        System.out.println("getShiftColumns");
        ShiftController instance = new ShiftController();
        List<ShiftColumn> expResult = null;
        List<ShiftColumn> result = instance.getShiftColumns();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addShift method, of class ShiftController.
     */
    @Test
    public void testAddShift() {
        System.out.println("addShift");
        ShiftController instance = new ShiftController();
        Object expResult = null;
        Object result = instance.addShift();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reset method, of class ShiftController.
     */
    @Test
    public void testReset() {
        System.out.println("reset");
        ShiftController instance = new ShiftController();
        Object expResult = null;
        Object result = instance.reset();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateShift method, of class ShiftController.
     */
    @Test
    public void testUpdateShift() {
        System.out.println("updateShift");
        ShiftController instance = new ShiftController();
        Object expResult = null;
        Object result = instance.updateShift();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteShift method, of class ShiftController.
     */
    @Test
    public void testDeleteShift() {
        System.out.println("deleteShift");
        ShiftController instance = new ShiftController();
        Object expResult = null;
        Object result = instance.deleteShift();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of convertDateToTimeLabel method, of class ShiftController.
     */
    @Test
    public void testConvertDateToTimeLabel() {
        System.out.println("convertDateToTimeLabel");
        Date date = null;
        ShiftController instance = new ShiftController();
        String expResult = "";
        String result = instance.convertDateToTimeLabel(date);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllItems method, of class ShiftController.
     */
    @Test
    public void testGetAllItems() {
        System.out.println("getAllItems");
        ShiftController instance = new ShiftController();
        List<Shift> expResult = null;
        List<Shift> result = instance.getAllItems();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStartTimes method, of class ShiftController.
     */
    @Test
    public void testGetStartTimes() {
        System.out.println("getStartTimes");
        ShiftController instance = new ShiftController();
        List expResult = null;
        List result = instance.getStartTimes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEndTimes method, of class ShiftController.
     */
    @Test
    public void testGetEndTimes() {
        System.out.println("getEndTimes");
        ShiftController instance = new ShiftController();
        List expResult = null;
        List result = instance.getEndTimes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAvailableEmployees method, of class ShiftController.
     */
    @Test
    public void testGetAvailableEmployees() {
        System.out.println("getAvailableEmployees");
        ShiftController instance = new ShiftController();
        List<Employee> expResult = null;
        List<Employee> result = instance.getAvailableEmployees();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkCurrentEmployee method, of class ShiftController.
     */
    @Test
    public void testCheckCurrentEmployee() {
        System.out.println("checkCurrentEmployee");
        ShiftController instance = new ShiftController();
        boolean expResult = false;
        boolean result = instance.checkCurrentEmployee();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of processShiftClick method, of class ShiftController.
     */
    @Test
    public void testProcessShiftClick() {
        System.out.println("processShiftClick");
        String position = "";
        String time = "";
        ShiftController instance = new ShiftController();
        instance.processShiftClick(position, time);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getItemsFromTheWeekStart method, of class ShiftController.
     */
    @Test
    public void testGetItemsFromTheWeekStart() {
        System.out.println("getItemsFromTheWeekStart");
        ShiftController instance = new ShiftController();
        List<Shift> expResult = null;
        List<Shift> result = instance.getItemsFromTheWeekStart();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrent method, of class ShiftController.
     */
    @Test
    public void testGetCurrent() {
        System.out.println("getCurrent");
        ShiftController instance = new ShiftController();
        Object expResult = null;
        Object result = instance.getCurrent();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
