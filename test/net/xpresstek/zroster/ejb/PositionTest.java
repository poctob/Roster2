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

import java.util.Collection;
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
public class PositionTest {
    
    public PositionTest() {
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
     * Test of getPkID method, of class Position.
     */
    @Test
    public void testGetPkID() {
        System.out.println("getPkID");
        Position instance = new Position();
        Integer expResult = null;
        Integer result = instance.getPkID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPkID method, of class Position.
     */
    @Test
    public void testSetPkID() {
        System.out.println("setPkID");
        Integer pkID = null;
        Position instance = new Position();
        instance.setPkID(pkID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Position.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Position instance = new Position();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Position.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Position instance = new Position();
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getComment method, of class Position.
     */
    @Test
    public void testGetComment() {
        System.out.println("getComment");
        Position instance = new Position();
        String expResult = "";
        String result = instance.getComment();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setComment method, of class Position.
     */
    @Test
    public void testSetComment() {
        System.out.println("setComment");
        String comment = "";
        Position instance = new Position();
        instance.setComment(comment);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmployeeCollection method, of class Position.
     */
    @Test
    public void testGetEmployeeCollection() {
        System.out.println("getEmployeeCollection");
        Position instance = new Position();
        Collection<Employee> expResult = null;
        Collection<Employee> result = instance.getEmployeeCollection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmployeeCollection method, of class Position.
     */
    @Test
    public void testSetEmployeeCollection() {
        System.out.println("setEmployeeCollection");
        Collection<Employee> employeeCollection = null;
        Position instance = new Position();
        instance.setEmployeeCollection(employeeCollection);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Position.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Position instance = new Position();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Position.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Position instance = new Position();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Position.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Position instance = new Position();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
