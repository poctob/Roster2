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

import java.util.List;
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
public class ShiftColumnTest {
    
    public ShiftColumnTest() {
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
     * Test of getShifts method, of class ShiftColumn.
     */
    @Test
    public void testGetShifts() {
        System.out.println("getShifts");
        ShiftColumn instance = null;
        List<Shift> expResult = null;
        List<Shift> result = instance.getShifts();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setShifts method, of class ShiftColumn.
     */
    @Test
    public void testSetShifts() {
        System.out.println("setShifts");
        List<Shift> shifts = null;
        ShiftColumn instance = null;
        instance.setShifts(shifts);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getShiftID method, of class ShiftColumn.
     */
    @Test
    public void testGetShiftID() {
        System.out.println("getShiftID");
        String time = "";
        ShiftColumn instance = null;
        int expResult = 0;
        int result = instance.getShiftID(time);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getShiftIDByTimeandEmployee method, of class ShiftColumn.
     */
    @Test
    public void testGetShiftIDByTimeandEmployee() {
        System.out.println("getShiftIDByTimeandEmployee");
        String time = "";
        int employeeID = 0;
        ShiftColumn instance = null;
        int expResult = 0;
        int result = instance.getShiftIDByTimeandEmployee(time, employeeID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPosition method, of class ShiftColumn.
     */
    @Test
    public void testGetPosition() {
        System.out.println("getPosition");
        ShiftColumn instance = null;
        Position expResult = null;
        Position result = instance.getPosition();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPosition method, of class ShiftColumn.
     */
    @Test
    public void testSetPosition() {
        System.out.println("setPosition");
        Position position = null;
        ShiftColumn instance = null;
        instance.setPosition(position);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPositionName method, of class ShiftColumn.
     */
    @Test
    public void testGetPositionName() {
        System.out.println("getPositionName");
        ShiftColumn instance = null;
        String expResult = "";
        String result = instance.getPositionName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmployeeName method, of class ShiftColumn.
     */
    @Test
    public void testGetEmployeeName() {
        System.out.println("getEmployeeName");
        String time = "";
        ShiftColumn instance = null;
        String expResult = "";
        String result = instance.getEmployeeName(time);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmployeeNames method, of class ShiftColumn.
     */
    @Test
    public void testGetEmployeeNames() {
        System.out.println("getEmployeeNames");
        String time = "";
        ShiftColumn instance = null;
        List<Employee> expResult = null;
        List<Employee> result = instance.getEmployeeNames(time);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getShiftByTime method, of class ShiftColumn.
     */
    @Test
    public void testGetShiftByTime() {
        System.out.println("getShiftByTime");
        String time = "";
        ShiftColumn instance = null;
        List<Shift> expResult = null;
        List<Shift> result = instance.getShiftByTime(time);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getShiftByTimeAndEmployee method, of class ShiftColumn.
     */
    @Test
    public void testGetShiftByTimeAndEmployee() {
        System.out.println("getShiftByTimeAndEmployee");
        String time = "";
        int employeeID = 0;
        ShiftColumn instance = null;
        List<Shift> expResult = null;
        List<Shift> result = instance.getShiftByTimeAndEmployee(time, employeeID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
