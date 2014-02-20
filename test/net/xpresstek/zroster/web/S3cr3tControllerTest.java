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

import net.xpresstek.zroster.ejb.S3cr3t;
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
public class S3cr3tControllerTest {
    
    public S3cr3tControllerTest() {
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
     * Test of getFacade method, of class S3cr3tController.
     */
    @Test
    public void testGetFacade() {
        System.out.println("getFacade");
        S3cr3tController instance = new S3cr3tController();
        AbstractFacade expResult = null;
        AbstractFacade result = instance.getFacade();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrent method, of class S3cr3tController.
     */
    @Test
    public void testGetCurrent() {
        System.out.println("getCurrent");
        S3cr3tController instance = new S3cr3tController();
        Object expResult = null;
        Object result = instance.getCurrent();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCurrent method, of class S3cr3tController.
     */
    @Test
    public void testSetCurrent() {
        System.out.println("setCurrent");
        Object obj = null;
        S3cr3tController instance = new S3cr3tController();
        instance.setCurrent(obj);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createNewCurrent method, of class S3cr3tController.
     */
    @Test
    public void testCreateNewCurrent() {
        System.out.println("createNewCurrent");
        S3cr3tController instance = new S3cr3tController();
        instance.createNewCurrent();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class S3cr3tController.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        S3cr3tController instance = new S3cr3tController();
        instance.create();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class S3cr3tController.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        S3cr3tController instance = new S3cr3tController();
        instance.update();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isPasswordCorrect method, of class S3cr3tController.
     */
    @Test
    public void testIsPasswordCorrect() {
        System.out.println("isPasswordCorrect");
        int employeeID = 0;
        String password = "";
        S3cr3tController instance = new S3cr3tController();
        boolean expResult = false;
        boolean result = instance.isPasswordCorrect(employeeID, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getS3cr3t method, of class S3cr3tController.
     */
    @Test
    public void testGetS3cr3t() {
        System.out.println("getS3cr3t");
        Integer id = null;
        S3cr3tController instance = new S3cr3tController();
        S3cr3t expResult = null;
        S3cr3t result = instance.getS3cr3t(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
