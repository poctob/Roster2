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
import javax.faces.model.SelectItem;
import net.xpresstek.zroster.ejb.ClockEventTrans;
import net.xpresstek.zroster.ejb.ClockOutReasons;
import net.xpresstek.zroster.ejb.Employee;
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
public class ClockEventTransControllerTest {
    
    public ClockEventTransControllerTest() {
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
     * Test of getCurrentEvents method, of class ClockEventTransController.
     */
    @Test
    public void testGetCurrentEvents() {
        System.out.println("getCurrentEvents");
        ClockEventTransController instance = new ClockEventTransController();
        List<ClockEventTrans> expResult = null;
//        List<ClockEventTrans> result = instance.getCurrentEvents();
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCurrentEvents method, of class ClockEventTransController.
     */
    @Test
    public void testSetCurrentEvents() {
        System.out.println("setCurrentEvents");
        List<ClockEventTrans> currentEvents = null;
        ClockEventTransController instance = new ClockEventTransController();
     //   instance.setCurrentEvents(currentEvents);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateCurrentEvents method, of class ClockEventTransController.
     */
    @Test
    public void testUpdateCurrentEvents() {
        System.out.println("updateCurrentEvents");
        ClockEventTransController instance = new ClockEventTransController();
//        instance.updateCurrentEvents();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrent_date method, of class ClockEventTransController.
     */
    @Test
    public void testGetCurrent_date() {
        System.out.println("getCurrent_date");
        ClockEventTransController instance = new ClockEventTransController();
        Date expResult = null;
        Date result = instance.getCurrent_date();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentApprover method, of class ClockEventTransController.
     */
    @Test
    public void testGetCurrentApprover() {
        System.out.println("getCurrentApprover");
        ClockEventTransController instance = new ClockEventTransController();
        Employee expResult = null;
        Employee result = instance.getCurrentApprover();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCurrentApprover method, of class ClockEventTransController.
     */
    @Test
    public void testSetCurrentApprover() {
        System.out.println("setCurrentApprover");
        Employee currentApprover = null;
        ClockEventTransController instance = new ClockEventTransController();
        instance.setCurrentApprover(currentApprover);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setApproverPassword method, of class ClockEventTransController.
     */
    @Test
    public void testSetApproverPassword() {
        System.out.println("setApproverPassword");
        String approverPassword = "";
        ClockEventTransController instance = new ClockEventTransController();
        instance.setApproverPassword(approverPassword);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getApproverPassword method, of class ClockEventTransController.
     */
    @Test
    public void testGetApproverPassword() {
        System.out.println("getApproverPassword");
        ClockEventTransController instance = new ClockEventTransController();
        String expResult = "";
        String result = instance.getApproverPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCurrent_date method, of class ClockEventTransController.
     */
    @Test
    public void testSetCurrent_date() {
        System.out.println("setCurrent_date");
        Date current_date = null;
        ClockEventTransController instance = new ClockEventTransController();
        instance.setCurrent_date(current_date);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ClockIn method, of class ClockEventTransController.
     */
    @Test
    public void testClockIn() {
        System.out.println("ClockIn");
        Employee employee = null;
        ClockEventTransController instance = new ClockEventTransController();
        instance.ClockIn(employee);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAvailableEmployees method, of class ClockEventTransController.
     */
    @Test
    public void testGetAvailableEmployees() {
        System.out.println("getAvailableEmployees");
        ClockEventTransController instance = new ClockEventTransController();
        SelectItem[] expResult = null;
        SelectItem[] result = instance.getAvailableEmployees();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ClockOut method, of class ClockEventTransController.
     */
    @Test
    public void testClockOut() {
        System.out.println("ClockOut");
        Employee employee = null;
        ClockEventTransController instance = new ClockEventTransController();
        instance.ClockOut(employee);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getReason method, of class ClockEventTransController.
     */
    @Test
    public void testGetReason() {
        System.out.println("getReason");
        ClockEventTransController instance = new ClockEventTransController();
        ClockOutReasons expResult = null;
        ClockOutReasons result = instance.getReason();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setReason method, of class ClockEventTransController.
     */
    @Test
    public void testSetReason() {
        System.out.println("setReason");
        ClockOutReasons reason = null;
        ClockEventTransController instance = new ClockEventTransController();
        instance.setReason(reason);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastEventName method, of class ClockEventTransController.
     */
    @Test
    public void testGetLastEventName() {
        System.out.println("getLastEventName");
        Employee employee = null;
        ClockEventTransController instance = new ClockEventTransController();
        String expResult = "";
        String result = instance.getLastEventName(employee);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastEventTime method, of class ClockEventTransController.
     */
    @Test
    public void testGetLastEventTime() {
        System.out.println("getLastEventTime");
        Employee employee = null;
        ClockEventTransController instance = new ClockEventTransController();
        Date expResult = null;
        Date result = instance.getLastEventTime(employee);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isClockedIn method, of class ClockEventTransController.
     */
    @Test
    public void testIsClockedIn() {
        System.out.println("isClockedIn");
        Employee employee = null;
        ClockEventTransController instance = new ClockEventTransController();
        boolean expResult = false;
        boolean result = instance.isClockedIn(employee);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFacade method, of class ClockEventTransController.
     */
    @Test
    public void testGetFacade() {
        System.out.println("getFacade");
        ClockEventTransController instance = new ClockEventTransController();
        AbstractFacade expResult = null;
        AbstractFacade result = instance.getFacade();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of prepareEdit method, of class ClockEventTransController.
     */
    @Test
    public void testPrepareEdit() {
        System.out.println("prepareEdit");
        int id = 0;
        ClockEventTransController instance = new ClockEventTransController();
        instance.prepareEdit(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getClockEventTrans method, of class ClockEventTransController.
     */
    @Test
    public void testGetClockEventTrans() {
        System.out.println("getClockEventTrans");
        Integer id = null;
        ClockEventTransController instance = new ClockEventTransController();
        ClockEventTrans expResult = null;
        ClockEventTrans result = instance.getClockEventTrans(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculateShiftHours method, of class ClockEventTransController.
     */
    @Test
    public void testCalculateShiftHours() {
        System.out.println("calculateShiftHours");
        ClockEventTrans item = null;
        ClockEventTransController instance = new ClockEventTransController();
        double expResult = 0.0;
        double result = instance.calculateShiftHours(item);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculateWorkedHours method, of class ClockEventTransController.
     */
    @Test
    public void testCalculateWorkedHours() {
        System.out.println("calculateWorkedHours");
        Employee employee = null;
        Date start = null;
        Date end = null;
        ClockEventTransController instance = new ClockEventTransController();
        double expResult = 0.0;
//        double result = instance.calculateWorkedHours(employee, start, end);
    //    assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findClockEventsByEmployeeAndInterval method, of class ClockEventTransController.
     */
    @Test
    public void testFindClockEventsByEmployeeAndInterval() {
        System.out.println("findClockEventsByEmployeeAndInterval");
        Employee employee = null;
        Date start = null;
        Date end = null;
        ClockEventTransController instance = new ClockEventTransController();
        List<ClockEventTrans> expResult = null;
    //    List<ClockEventTrans> result = instance.findClockEventsByEmployeeAndInterval(employee, start, end);
      //  assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrent method, of class ClockEventTransController.
     */
    @Test
    public void testGetCurrent() {
        System.out.println("getCurrent");
        ClockEventTransController instance = new ClockEventTransController();
        Object expResult = null;
        Object result = instance.getCurrent();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCurrent method, of class ClockEventTransController.
     */
    @Test
    public void testSetCurrent() {
        System.out.println("setCurrent");
        Object obj = null;
        ClockEventTransController instance = new ClockEventTransController();
        instance.setCurrent(obj);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createNewCurrent method, of class ClockEventTransController.
     */
    @Test
    public void testCreateNewCurrent() {
        System.out.println("createNewCurrent");
        ClockEventTransController instance = new ClockEventTransController();
        instance.createNewCurrent();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
