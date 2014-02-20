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
import net.xpresstek.zroster.ejb.Employee;
import net.xpresstek.zroster.ejb.Position;
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
public class ShiftHelperTest {
    
    public ShiftHelperTest() {
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
     * Test of getEmployee method, of class ShiftHelper.
     */
    @Test
    public void testGetEmployee() {
        System.out.println("getEmployee");
        ShiftHelper instance = new ShiftHelper();
        Employee expResult = null;
        Employee result = instance.getEmployee();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmployee method, of class ShiftHelper.
     */
    @Test
    public void testSetEmployee() {
        System.out.println("setEmployee");
        Employee employee = null;
        ShiftHelper instance = new ShiftHelper();
        instance.setEmployee(employee);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPosition method, of class ShiftHelper.
     */
    @Test
    public void testGetPosition() {
        System.out.println("getPosition");
        ShiftHelper instance = new ShiftHelper();
        Position expResult = null;
        Position result = instance.getPosition();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPosition method, of class ShiftHelper.
     */
    @Test
    public void testSetPosition() {
        System.out.println("setPosition");
        Position position = null;
        ShiftHelper instance = new ShiftHelper();
        instance.setPosition(position);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStart method, of class ShiftHelper.
     */
    @Test
    public void testGetStart() {
        System.out.println("getStart");
        ShiftHelper instance = new ShiftHelper();
        Date expResult = null;
        Date result = instance.getStart();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStart method, of class ShiftHelper.
     */
    @Test
    public void testSetStart() {
        System.out.println("setStart");
        Date start = null;
        ShiftHelper instance = new ShiftHelper();
        instance.setStart(start);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEnd method, of class ShiftHelper.
     */
    @Test
    public void testGetEnd() {
        System.out.println("getEnd");
        ShiftHelper instance = new ShiftHelper();
        Date expResult = null;
        Date result = instance.getEnd();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEnd method, of class ShiftHelper.
     */
    @Test
    public void testSetEnd() {
        System.out.println("setEnd");
        Date end = null;
        ShiftHelper instance = new ShiftHelper();
        instance.setEnd(end);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class ShiftHelper.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        ShiftHelper instance = new ShiftHelper();
        instance.create();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
