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
public class S3cr3tPKTest {
    
    public S3cr3tPKTest() {
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
     * Test of getUserId method, of class S3cr3tPK.
     */
    @Test
    public void testGetUserId() {
        System.out.println("getUserId");
        S3cr3tPK instance = new S3cr3tPK();
        int expResult = 0;
        int result = instance.getUserId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserId method, of class S3cr3tPK.
     */
    @Test
    public void testSetUserId() {
        System.out.println("setUserId");
        int userId = 0;
        S3cr3tPK instance = new S3cr3tPK();
        instance.setUserId(userId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPass method, of class S3cr3tPK.
     */
    @Test
    public void testGetPass() {
        System.out.println("getPass");
        S3cr3tPK instance = new S3cr3tPK();
        String expResult = "";
        String result = instance.getPass();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPass method, of class S3cr3tPK.
     */
    @Test
    public void testSetPass() {
        System.out.println("setPass");
        String pass = "";
        S3cr3tPK instance = new S3cr3tPK();
        instance.setPass(pass);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSalt method, of class S3cr3tPK.
     */
    @Test
    public void testGetSalt() {
        System.out.println("getSalt");
        S3cr3tPK instance = new S3cr3tPK();
        String expResult = "";
        String result = instance.getSalt();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSalt method, of class S3cr3tPK.
     */
    @Test
    public void testSetSalt() {
        System.out.println("setSalt");
        String salt = "";
        S3cr3tPK instance = new S3cr3tPK();
        instance.setSalt(salt);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class S3cr3tPK.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        S3cr3tPK instance = new S3cr3tPK();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class S3cr3tPK.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        S3cr3tPK instance = new S3cr3tPK();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class S3cr3tPK.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        S3cr3tPK instance = new S3cr3tPK();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
