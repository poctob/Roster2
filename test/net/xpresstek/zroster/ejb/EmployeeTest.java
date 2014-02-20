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
public class EmployeeTest {
    
    public EmployeeTest() {
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
     * Test of getPkID method, of class Employee.
     */
    @Test
    public void testGetPkID() {
        System.out.println("getPkID");
        Employee instance = new Employee();
        Integer expResult = null;
        Integer result = instance.getPkID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPkID method, of class Employee.
     */
    @Test
    public void testSetPkID() {
        System.out.println("setPkID");
        Integer pkID = null;
        Employee instance = new Employee();
        instance.setPkID(pkID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Employee.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Employee instance = new Employee();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Employee.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Employee instance = new Employee();
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAddress method, of class Employee.
     */
    @Test
    public void testGetAddress() {
        System.out.println("getAddress");
        Employee instance = new Employee();
        String expResult = "";
        String result = instance.getAddress();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAddress method, of class Employee.
     */
    @Test
    public void testSetAddress() {
        System.out.println("setAddress");
        String address = "";
        Employee instance = new Employee();
        instance.setAddress(address);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPhone method, of class Employee.
     */
    @Test
    public void testGetPhone() {
        System.out.println("getPhone");
        Employee instance = new Employee();
        String expResult = "";
        String result = instance.getPhone();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPhone method, of class Employee.
     */
    @Test
    public void testSetPhone() {
        System.out.println("setPhone");
        String phone = "";
        Employee instance = new Employee();
        instance.setPhone(phone);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIsActive method, of class Employee.
     */
    @Test
    public void testGetIsActive() {
        System.out.println("getIsActive");
        Employee instance = new Employee();
        boolean expResult = false;
        boolean result = instance.getIsActive();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIsActive method, of class Employee.
     */
    @Test
    public void testSetIsActive() {
        System.out.println("setIsActive");
        boolean isActive = false;
        Employee instance = new Employee();
        instance.setIsActive(isActive);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmail method, of class Employee.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Employee instance = new Employee();
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmail method, of class Employee.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        Employee instance = new Employee();
        instance.setEmail(email);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getComment method, of class Employee.
     */
    @Test
    public void testGetComment() {
        System.out.println("getComment");
        Employee instance = new Employee();
        String expResult = "";
        String result = instance.getComment();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setComment method, of class Employee.
     */
    @Test
    public void testSetComment() {
        System.out.println("setComment");
        String comment = "";
        Employee instance = new Employee();
        instance.setComment(comment);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrivilegeCollection method, of class Employee.
     */
    @Test
    public void testGetPrivilegeCollection() {
        System.out.println("getPrivilegeCollection");
        Employee instance = new Employee();
        Collection<Privilege> expResult = null;
        Collection<Privilege> result = instance.getPrivilegeCollection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPrivilegeCollection method, of class Employee.
     */
    @Test
    public void testSetPrivilegeCollection() {
        System.out.println("setPrivilegeCollection");
        Collection<Privilege> privilegeCollection = null;
        Employee instance = new Employee();
        instance.setPrivilegeCollection(privilegeCollection);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPositionCollection method, of class Employee.
     */
    @Test
    public void testGetPositionCollection() {
        System.out.println("getPositionCollection");
        Employee instance = new Employee();
        Collection<Position> expResult = null;
        Collection<Position> result = instance.getPositionCollection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPositionCollection method, of class Employee.
     */
    @Test
    public void testSetPositionCollection() {
        System.out.println("setPositionCollection");
        Collection<Position> positionCollection = null;
        Employee instance = new Employee();
        instance.setPositionCollection(positionCollection);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTimeOffCollection method, of class Employee.
     */
    @Test
    public void testGetTimeOffCollection() {
        System.out.println("getTimeOffCollection");
        Employee instance = new Employee();
        Collection<TimeOff> expResult = null;
        Collection<TimeOff> result = instance.getTimeOffCollection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTimeOffCollection method, of class Employee.
     */
    @Test
    public void testSetTimeOffCollection() {
        System.out.println("setTimeOffCollection");
        Collection<TimeOff> timeOffCollection = null;
        Employee instance = new Employee();
        instance.setTimeOffCollection(timeOffCollection);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getClockEventTransCollection method, of class Employee.
     */
    @Test
    public void testGetClockEventTransCollection() {
        System.out.println("getClockEventTransCollection");
        Employee instance = new Employee();
        Collection<ClockEventTrans> expResult = null;
        Collection<ClockEventTrans> result = instance.getClockEventTransCollection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setClockEventTransCollection method, of class Employee.
     */
    @Test
    public void testSetClockEventTransCollection() {
        System.out.println("setClockEventTransCollection");
        Collection<ClockEventTrans> clockEventTransCollection = null;
        Employee instance = new Employee();
        instance.setClockEventTransCollection(clockEventTransCollection);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getS3cr3tCollection method, of class Employee.
     */
    @Test
    public void testGetS3cr3tCollection() {
        System.out.println("getS3cr3tCollection");
        Employee instance = new Employee();
        Collection<S3cr3t> expResult = null;
        Collection<S3cr3t> result = instance.getS3cr3tCollection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setS3cr3tCollection method, of class Employee.
     */
    @Test
    public void testSetS3cr3tCollection() {
        System.out.println("setS3cr3tCollection");
        Collection<S3cr3t> s3cr3tCollection = null;
        Employee instance = new Employee();
        instance.setS3cr3tCollection(s3cr3tCollection);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Employee.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Employee instance = new Employee();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Employee.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Employee instance = new Employee();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Employee.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Employee instance = new Employee();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isPositionAllowed method, of class Employee.
     */
    @Test
    public void testIsPositionAllowed() {
        System.out.println("isPositionAllowed");
        int position = 0;
        Employee instance = new Employee();
        boolean expResult = false;
        boolean result = instance.isPositionAllowed(position);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isTimeAllowed method, of class Employee.
     */
    @Test
    public void testIsTimeAllowed() {
        System.out.println("isTimeAllowed");
        String start_time = "";
        String end_time = "";
        Employee instance = new Employee();
        boolean expResult = false;
        boolean result = instance.isTimeAllowed(start_time, end_time);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hasPrivilege method, of class Employee.
     */
    @Test
    public void testHasPrivilege() {
        System.out.println("hasPrivilege");
        String pName = "";
        Employee instance = new Employee();
        boolean expResult = false;
        boolean result = instance.hasPrivilege(pName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
