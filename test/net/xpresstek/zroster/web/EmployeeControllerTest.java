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
import net.xpresstek.zroster.ejb.Employee;
import net.xpresstek.zroster.ejb.EmployeeHours;
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
public class EmployeeControllerTest {
    
    public EmployeeControllerTest() {
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
     * Test of getFilteredEmployees method, of class EmployeeController.
     */
    @Test
    public void testGetFilteredEmployees() {
        System.out.println("getFilteredEmployees");
        EmployeeController instance = new EmployeeController();
        List<Employee> expResult = null;
        List<Employee> result = instance.getFilteredEmployees();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFilteredEmployees method, of class EmployeeController.
     */
    @Test
    public void testSetFilteredEmployees() {
        System.out.println("setFilteredEmployees");
        List<Employee> filteredEmployees = null;
        EmployeeController instance = new EmployeeController();
        instance.setFilteredEmployees(filteredEmployees);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getActiveOptions method, of class EmployeeController.
     */
    @Test
    public void testGetActiveOptions() {
        System.out.println("getActiveOptions");
        EmployeeController instance = new EmployeeController();
        SelectItem[] expResult = null;
        SelectItem[] result = instance.getActiveOptions();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setActiveOptions method, of class EmployeeController.
     */
    @Test
    public void testSetActiveOptions() {
        System.out.println("setActiveOptions");
        SelectItem[] activeOptions = null;
        EmployeeController instance = new EmployeeController();
        instance.setActiveOptions(activeOptions);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDefaultFilter method, of class EmployeeController.
     */
    @Test
    public void testGetDefaultFilter() {
        System.out.println("getDefaultFilter");
        EmployeeController instance = new EmployeeController();
        String expResult = "";
        String result = instance.getDefaultFilter();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPassword method, of class EmployeeController.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        EmployeeController instance = new EmployeeController();
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPassword method, of class EmployeeController.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "";
        EmployeeController instance = new EmployeeController();
        instance.setPassword(password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class EmployeeController.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        EmployeeController instance = new EmployeeController();
        instance.create();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class EmployeeController.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        EmployeeController instance = new EmployeeController();
        instance.update();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFacade method, of class EmployeeController.
     */
    @Test
    public void testGetFacade() {
        System.out.println("getFacade");
        EmployeeController instance = new EmployeeController();
        AbstractFacade expResult = null;
        AbstractFacade result = instance.getFacade();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrent method, of class EmployeeController.
     */
    @Test
    public void testGetCurrent() {
        System.out.println("getCurrent");
        EmployeeController instance = new EmployeeController();
        Object expResult = null;
        Object result = instance.getCurrent();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentEmployee method, of class EmployeeController.
     */
    @Test
    public void testGetCurrentEmployee() {
        System.out.println("getCurrentEmployee");
        EmployeeController instance = new EmployeeController();
        Employee expResult = null;
        Employee result = instance.getCurrentEmployee();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of refresh method, of class EmployeeController.
     */
    @Test
    public void testRefresh() {
        System.out.println("refresh");
        EmployeeController instance = new EmployeeController();
        instance.refresh();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmployee method, of class EmployeeController.
     */
    @Test
    public void testGetEmployee() {
        System.out.println("getEmployee");
        Integer id = null;
        EmployeeController instance = new EmployeeController();
        Employee expResult = null;
//        Employee result = instance.getEmployee(id);
  //      assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmployeeByName method, of class EmployeeController.
     */
    @Test
    public void testGetEmployeeByName() {
        System.out.println("getEmployeeByName");
        String name = "";
        EmployeeController instance = new EmployeeController();
        Employee expResult = null;
        Employee result = instance.getEmployeeByName(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of prepareEdit method, of class EmployeeController.
     */
    @Test
    public void testPrepareEdit() {
        System.out.println("prepareEdit");
        int id = 0;
        EmployeeController instance = new EmployeeController();
        instance.prepareEdit(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCurrent method, of class EmployeeController.
     */
    @Test
    public void testSetCurrent() {
        System.out.println("setCurrent");
        Object obj = null;
        EmployeeController instance = new EmployeeController();
        instance.setCurrent(obj);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createNewCurrent method, of class EmployeeController.
     */
    @Test
    public void testCreateNewCurrent() {
        System.out.println("createNewCurrent");
        EmployeeController instance = new EmployeeController();
        instance.createNewCurrent();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateTimeOff method, of class EmployeeController.
     */
    @Test
    public void testUpdateTimeOff() {
        System.out.println("updateTimeOff");
        EmployeeController instance = new EmployeeController();
        instance.updateTimeOff();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllItems method, of class EmployeeController.
     */
    @Test
    public void testGetAllItems() {
        System.out.println("getAllItems");
        EmployeeController instance = new EmployeeController();
        List<Employee> expResult = null;
        List<Employee> result = instance.getAllItems();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getActiveEmployees method, of class EmployeeController.
     */
    @Test
    public void testGetActiveEmployees() {
        System.out.println("getActiveEmployees");
        EmployeeController instance = new EmployeeController();
        List<Employee> expResult = null;
        List<Employee> result = instance.getActiveEmployees();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTimeApprovers method, of class EmployeeController.
     */
    @Test
    public void testGetTimeApprovers() {
        System.out.println("getTimeApprovers");
        EmployeeController instance = new EmployeeController();
        List<Employee> expResult = null;
        List<Employee> result = instance.getTimeApprovers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllowedItems method, of class EmployeeController.
     */
    @Test
    public void testGetAllowedItems() {
        System.out.println("getAllowedItems");
        int position = 0;
        String start = "";
        String end = "";
        EmployeeController instance = new EmployeeController();
        List<Employee> expResult = null;
//        List<Employee> result = instance.getAllowedItems(position, start, end);
  //      assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEmployeeAllowed method, of class EmployeeController.
     */
    @Test
    public void testIsEmployeeAllowed() {
        System.out.println("isEmployeeAllowed");
        Employee e = null;
        int position = 0;
        String start = "";
        String end = "";
        boolean expResult = false;
     //   boolean result = EmployeeController.isEmployeeAllowed(e, position, start, end);
       // assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmployeeHours method, of class EmployeeController.
     */
    @Test
    public void testGetEmployeeHours() {
        System.out.println("getEmployeeHours");
        EmployeeController instance = new EmployeeController();
        EmployeeHours expResult = null;
        EmployeeHours result = instance.getEmployeeHours();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateEmployeeHours method, of class EmployeeController.
     */
    @Test
    public void testUpdateEmployeeHours() {
        System.out.println("updateEmployeeHours");
        EmployeeController instance = new EmployeeController();
      //  instance.updateEmployeeHours();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmployeeHours method, of class EmployeeController.
     */
    @Test
    public void testSetEmployeeHours() {
        System.out.println("setEmployeeHours");
        EmployeeHours employeeHours = null;
        EmployeeController instance = new EmployeeController();
        instance.setEmployeeHours(employeeHours);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentEmployeeHours method, of class EmployeeController.
     */
    @Test
    public void testGetCurrentEmployeeHours_List() {
        System.out.println("getCurrentEmployeeHours");
        List<ClockEventTrans> events = null;
        EmployeeController instance = new EmployeeController();
        List<EmployeeHours> expResult = null;
//        List<EmployeeHours> result = instance.getCurrentEmployeeHours(events);
      //  assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentEmployeeHours method, of class EmployeeController.
     */
    @Test
    public void testGetCurrentEmployeeHours_Date_boolean() {
        System.out.println("getCurrentEmployeeHours");
        Date date = null;
        boolean active = false;
        EmployeeController instance = new EmployeeController();
        List<EmployeeHours> expResult = null;
      //  List<EmployeeHours> result = instance.getCurrentEmployeeHours(date, active);
     //   assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
