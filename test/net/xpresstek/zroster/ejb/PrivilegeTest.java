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
public class PrivilegeTest {
    
    public PrivilegeTest() {
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
     * Test of getPkid method, of class Privilege.
     */
    @Test
    public void testGetPkid() {
        System.out.println("getPkid");
        Privilege instance = new Privilege();
        Integer expResult = null;
        Integer result = instance.getPkid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPkid method, of class Privilege.
     */
    @Test
    public void testSetPkid() {
        System.out.println("setPkid");
        Integer pkid = null;
        Privilege instance = new Privilege();
        instance.setPkid(pkid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Privilege.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Privilege instance = new Privilege();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Privilege.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Privilege instance = new Privilege();
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmployeeCollection method, of class Privilege.
     */
    @Test
    public void testGetEmployeeCollection() {
        System.out.println("getEmployeeCollection");
        Privilege instance = new Privilege();
        Collection<Employee> expResult = null;
        Collection<Employee> result = instance.getEmployeeCollection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmployeeCollection method, of class Privilege.
     */
    @Test
    public void testSetEmployeeCollection() {
        System.out.println("setEmployeeCollection");
        Collection<Employee> employeeCollection = null;
        Privilege instance = new Privilege();
        instance.setEmployeeCollection(employeeCollection);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Privilege.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Privilege instance = new Privilege();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Privilege.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Privilege instance = new Privilege();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Privilege.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Privilege instance = new Privilege();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isAdministrator method, of class Privilege.
     */
    @Test
    public void testIsAdministrator() {
        System.out.println("isAdministrator");
        Privilege instance = new Privilege();
        boolean expResult = false;
        boolean result = instance.isAdministrator();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
