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
public class ShiftTest {
    
    public ShiftTest() {
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
     * Test of getPkid method, of class Shift.
     */
    @Test
    public void testGetPkid() {
        System.out.println("getPkid");
        Shift instance = new Shift();
        Integer expResult = null;
        Integer result = instance.getPkid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPkid method, of class Shift.
     */
    @Test
    public void testSetPkid() {
        System.out.println("setPkid");
        Integer pkid = null;
        Shift instance = new Shift();
        instance.setPkid(pkid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmployeeID method, of class Shift.
     */
    @Test
    public void testGetEmployeeID() {
        System.out.println("getEmployeeID");
        Shift instance = new Shift();
        int expResult = 0;
        int result = instance.getEmployeeID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmployeeID method, of class Shift.
     */
    @Test
    public void testSetEmployeeID() {
        System.out.println("setEmployeeID");
        int employeeID = 0;
        Shift instance = new Shift();
        instance.setEmployeeID(employeeID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPositionID method, of class Shift.
     */
    @Test
    public void testGetPositionID() {
        System.out.println("getPositionID");
        Shift instance = new Shift();
        int expResult = 0;
        int result = instance.getPositionID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPositionID method, of class Shift.
     */
    @Test
    public void testSetPositionID() {
        System.out.println("setPositionID");
        int positionID = 0;
        Shift instance = new Shift();
        instance.setPositionID(positionID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStart method, of class Shift.
     */
    @Test
    public void testGetStart() {
        System.out.println("getStart");
        Shift instance = new Shift();
        Date expResult = null;
        Date result = instance.getStart();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStart method, of class Shift.
     */
    @Test
    public void testSetStart() {
        System.out.println("setStart");
        Date start = null;
        Shift instance = new Shift();
        instance.setStart(start);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEnd method, of class Shift.
     */
    @Test
    public void testGetEnd() {
        System.out.println("getEnd");
        Shift instance = new Shift();
        Date expResult = null;
        Date result = instance.getEnd();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEnd method, of class Shift.
     */
    @Test
    public void testSetEnd() {
        System.out.println("setEnd");
        Date end = null;
        Shift instance = new Shift();
        instance.setEnd(end);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Shift.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Shift instance = new Shift();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Shift.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Shift instance = new Shift();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Shift.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Shift instance = new Shift();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEmployeeOn method, of class Shift.
     */
    @Test
    public void testIsEmployeeOn() {
        System.out.println("isEmployeeOn");
        int position = 0;
        String date = "";
        Shift instance = new Shift();
        int expResult = 0;
        int result = instance.isEmployeeOn(position, date);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmployeeObject method, of class Shift.
     */
    @Test
    public void testGetEmployeeObject() {
        System.out.println("getEmployeeObject");
        Shift instance = new Shift();
        Employee expResult = null;
        Employee result = instance.getEmployeeObject();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPositionObject method, of class Shift.
     */
    @Test
    public void testGetPositionObject() {
        System.out.println("getPositionObject");
        Shift instance = new Shift();
        Position expResult = null;
        Position result = instance.getPositionObject();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getShiftHours method, of class Shift.
     */
    @Test
    public void testGetShiftHours() {
        System.out.println("getShiftHours");
        Shift instance = new Shift();
        double expResult = 0.0;
        double result = instance.getShiftHours();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
