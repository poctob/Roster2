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
import java.util.TimeZone;
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
public class TimeOffTest {
    
    public TimeOffTest() {
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
     * Test of getPkid method, of class TimeOff.
     */
    @Test
    public void testGetPkid() {
        System.out.println("getPkid");
        TimeOff instance = new TimeOff();
        Integer expResult = null;
        Integer result = instance.getPkid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPkid method, of class TimeOff.
     */
    @Test
    public void testSetPkid() {
        System.out.println("setPkid");
        Integer pkid = null;
        TimeOff instance = new TimeOff();
        instance.setPkid(pkid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStart method, of class TimeOff.
     */
    @Test
    public void testGetStart() {
        System.out.println("getStart");
        TimeOff instance = new TimeOff();
        Date expResult = null;
        Date result = instance.getStart();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStart method, of class TimeOff.
     */
    @Test
    public void testSetStart() {
        System.out.println("setStart");
        Date start = null;
        TimeOff instance = new TimeOff();
        instance.setStart(start);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEnd method, of class TimeOff.
     */
    @Test
    public void testGetEnd() {
        System.out.println("getEnd");
        TimeOff instance = new TimeOff();
        Date expResult = null;
        Date result = instance.getEnd();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEnd method, of class TimeOff.
     */
    @Test
    public void testSetEnd() {
        System.out.println("setEnd");
        Date end = null;
        TimeOff instance = new TimeOff();
        instance.setEnd(end);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTimeOffStatusid method, of class TimeOff.
     */
    @Test
    public void testGetTimeOffStatusid() {
        System.out.println("getTimeOffStatusid");
        TimeOff instance = new TimeOff();
        TimeOffStatus expResult = null;
        TimeOffStatus result = instance.getTimeOffStatusid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTimeOffStatusid method, of class TimeOff.
     */
    @Test
    public void testSetTimeOffStatusid() {
        System.out.println("setTimeOffStatusid");
        TimeOffStatus timeOffStatusid = null;
        TimeOff instance = new TimeOff();
        instance.setTimeOffStatusid(timeOffStatusid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmployeeid method, of class TimeOff.
     */
    @Test
    public void testGetEmployeeid() {
        System.out.println("getEmployeeid");
        TimeOff instance = new TimeOff();
        Employee expResult = null;
        Employee result = instance.getEmployeeid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmployeeid method, of class TimeOff.
     */
    @Test
    public void testSetEmployeeid() {
        System.out.println("setEmployeeid");
        Employee employeeid = null;
        TimeOff instance = new TimeOff();
        instance.setEmployeeid(employeeid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTimezone method, of class TimeOff.
     */
    @Test
    public void testGetTimezone() {
        System.out.println("getTimezone");
        TimeOff instance = new TimeOff();
        TimeZone expResult = null;
        TimeZone result = instance.getTimezone();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class TimeOff.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        TimeOff instance = new TimeOff();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class TimeOff.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        TimeOff instance = new TimeOff();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class TimeOff.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        TimeOff instance = new TimeOff();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isConflicting method, of class TimeOff.
     */
    @Test
    public void testIsConflicting() {
        System.out.println("isConflicting");
        String start = "";
        String end = "";
        TimeOff instance = new TimeOff();
        boolean expResult = false;
        boolean result = instance.isConflicting(start, end);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of compareTo method, of class TimeOff.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Object o = null;
        TimeOff instance = new TimeOff();
        int expResult = 0;
        int result = instance.compareTo(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
