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
public class ClockEventTransTest {
    
    public ClockEventTransTest() {
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
     * Test of getPkid method, of class ClockEventTrans.
     */
    @Test
    public void testGetPkid() {
        System.out.println("getPkid");
        ClockEventTrans instance = new ClockEventTrans();
        Integer expResult = null;
        Integer result = instance.getPkid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPkid method, of class ClockEventTrans.
     */
    @Test
    public void testSetPkid() {
        System.out.println("setPkid");
        Integer pkid = null;
        ClockEventTrans instance = new ClockEventTrans();
        instance.setPkid(pkid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTimestamp method, of class ClockEventTrans.
     */
    @Test
    public void testGetTimestamp() {
        System.out.println("getTimestamp");
        ClockEventTrans instance = new ClockEventTrans();
        Date expResult = null;
        Date result = instance.getTimestamp();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTimestamp method, of class ClockEventTrans.
     */
    @Test
    public void testSetTimestamp() {
        System.out.println("setTimestamp");
        Date timestamp = null;
        ClockEventTrans instance = new ClockEventTrans();
        instance.setTimestamp(timestamp);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getClockOutReasonid method, of class ClockEventTrans.
     */
    @Test
    public void testGetClockOutReasonid() {
        System.out.println("getClockOutReasonid");
        ClockEventTrans instance = new ClockEventTrans();
        ClockOutReasons expResult = null;
        ClockOutReasons result = instance.getClockOutReasonid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setClockOutReasonid method, of class ClockEventTrans.
     */
    @Test
    public void testSetClockOutReasonid() {
        System.out.println("setClockOutReasonid");
        ClockOutReasons clockOutReasonid = null;
        ClockEventTrans instance = new ClockEventTrans();
        instance.setClockOutReasonid(clockOutReasonid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getClockEventid method, of class ClockEventTrans.
     */
    @Test
    public void testGetClockEventid() {
        System.out.println("getClockEventid");
        ClockEventTrans instance = new ClockEventTrans();
        ClockEvent expResult = null;
        ClockEvent result = instance.getClockEventid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setClockEventid method, of class ClockEventTrans.
     */
    @Test
    public void testSetClockEventid() {
        System.out.println("setClockEventid");
        ClockEvent clockEventid = null;
        ClockEventTrans instance = new ClockEventTrans();
        instance.setClockEventid(clockEventid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmployeeid method, of class ClockEventTrans.
     */
    @Test
    public void testGetEmployeeid() {
        System.out.println("getEmployeeid");
        ClockEventTrans instance = new ClockEventTrans();
        Employee expResult = null;
        Employee result = instance.getEmployeeid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmployeeid method, of class ClockEventTrans.
     */
    @Test
    public void testSetEmployeeid() {
        System.out.println("setEmployeeid");
        Employee employeeid = null;
        ClockEventTrans instance = new ClockEventTrans();
        instance.setEmployeeid(employeeid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class ClockEventTrans.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        ClockEventTrans instance = new ClockEventTrans();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class ClockEventTrans.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        ClockEventTrans instance = new ClockEventTrans();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class ClockEventTrans.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        ClockEventTrans instance = new ClockEventTrans();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of compareTo method, of class ClockEventTrans.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        ClockEventTrans o = null;
        ClockEventTrans instance = new ClockEventTrans();
        int expResult = 0;
        int result = instance.compareTo(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
