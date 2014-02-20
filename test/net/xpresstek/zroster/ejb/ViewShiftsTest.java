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

import java.math.BigDecimal;
import java.math.BigInteger;
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
public class ViewShiftsTest {
    
    public ViewShiftsTest() {
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
     * Test of getKey method, of class ViewShifts.
     */
    @Test
    public void testGetKey() {
        System.out.println("getKey");
        ViewShifts instance = new ViewShifts();
        Integer expResult = null;
        Integer result = instance.getKey();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setKey method, of class ViewShifts.
     */
    @Test
    public void testSetKey() {
        System.out.println("setKey");
        Integer key = null;
        ViewShifts instance = new ViewShifts();
        instance.setKey(key);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmployee method, of class ViewShifts.
     */
    @Test
    public void testGetEmployee() {
        System.out.println("getEmployee");
        ViewShifts instance = new ViewShifts();
        String expResult = "";
        String result = instance.getEmployee();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmployee method, of class ViewShifts.
     */
    @Test
    public void testSetEmployee() {
        System.out.println("setEmployee");
        String employee = "";
        ViewShifts instance = new ViewShifts();
        instance.setEmployee(employee);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPosition method, of class ViewShifts.
     */
    @Test
    public void testGetPosition() {
        System.out.println("getPosition");
        ViewShifts instance = new ViewShifts();
        String expResult = "";
        String result = instance.getPosition();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPosition method, of class ViewShifts.
     */
    @Test
    public void testSetPosition() {
        System.out.println("setPosition");
        String position = "";
        ViewShifts instance = new ViewShifts();
        instance.setPosition(position);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStart method, of class ViewShifts.
     */
    @Test
    public void testGetStart() {
        System.out.println("getStart");
        ViewShifts instance = new ViewShifts();
        Date expResult = null;
        Date result = instance.getStart();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStart method, of class ViewShifts.
     */
    @Test
    public void testSetStart() {
        System.out.println("setStart");
        Date start = null;
        ViewShifts instance = new ViewShifts();
        instance.setStart(start);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEnd method, of class ViewShifts.
     */
    @Test
    public void testGetEnd() {
        System.out.println("getEnd");
        ViewShifts instance = new ViewShifts();
        Date expResult = null;
        Date result = instance.getEnd();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEnd method, of class ViewShifts.
     */
    @Test
    public void testSetEnd() {
        System.out.println("setEnd");
        Date end = null;
        ViewShifts instance = new ViewShifts();
        instance.setEnd(end);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMinutes method, of class ViewShifts.
     */
    @Test
    public void testGetMinutes() {
        System.out.println("getMinutes");
        ViewShifts instance = new ViewShifts();
        BigInteger expResult = null;
        BigInteger result = instance.getMinutes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMinutes method, of class ViewShifts.
     */
    @Test
    public void testSetMinutes() {
        System.out.println("setMinutes");
        BigInteger minutes = null;
        ViewShifts instance = new ViewShifts();
        instance.setMinutes(minutes);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTotalHours method, of class ViewShifts.
     */
    @Test
    public void testGetTotalHours() {
        System.out.println("getTotalHours");
        ViewShifts instance = new ViewShifts();
        BigDecimal expResult = null;
        BigDecimal result = instance.getTotalHours();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
