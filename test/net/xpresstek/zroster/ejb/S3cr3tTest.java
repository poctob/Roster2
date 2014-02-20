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
public class S3cr3tTest {
    
    public S3cr3tTest() {
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
     * Test of getS3cr3tPK method, of class S3cr3t.
     */
    @Test
    public void testGetS3cr3tPK() {
        System.out.println("getS3cr3tPK");
        S3cr3t instance = new S3cr3t();
        S3cr3tPK expResult = null;
        S3cr3tPK result = instance.getS3cr3tPK();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setS3cr3tPK method, of class S3cr3t.
     */
    @Test
    public void testSetS3cr3tPK() {
        System.out.println("setS3cr3tPK");
        S3cr3tPK s3cr3tPK = null;
        S3cr3t instance = new S3cr3t();
        instance.setS3cr3tPK(s3cr3tPK);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmployee method, of class S3cr3t.
     */
    @Test
    public void testGetEmployee() {
        System.out.println("getEmployee");
        S3cr3t instance = new S3cr3t();
        Employee expResult = null;
        Employee result = instance.getEmployee();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmployee method, of class S3cr3t.
     */
    @Test
    public void testSetEmployee() {
        System.out.println("setEmployee");
        Employee employee = null;
        S3cr3t instance = new S3cr3t();
        instance.setEmployee(employee);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class S3cr3t.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        S3cr3t instance = new S3cr3t();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class S3cr3t.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        S3cr3t instance = new S3cr3t();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class S3cr3t.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        S3cr3t instance = new S3cr3t();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
