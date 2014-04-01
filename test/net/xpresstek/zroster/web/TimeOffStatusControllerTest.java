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

import net.xpresstek.zroster.ejb.TimeOffStatus;
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
public class TimeOffStatusControllerTest {
    
    public TimeOffStatusControllerTest() {
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
     * Test of getFacade method, of class TimeOffStatusController.
     */
    @Test
    public void testGetFacade() {
        System.out.println("getFacade");
        TimeOffStatusController instance = new TimeOffStatusController();
        AbstractFacade expResult = null;
        AbstractFacade result = instance.getFacade();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrent method, of class TimeOffStatusController.
     */
    @Test
    public void testGetCurrent() {
        System.out.println("getCurrent");
        TimeOffStatusController instance = new TimeOffStatusController();
        Object expResult = null;
        Object result = instance.getCurrent();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTimeOffStatus method, of class TimeOffStatusController.
     */
    @Test
    public void testGetTimeOffStatus() {
        System.out.println("getTimeOffStatus");
        Integer id = null;
        TimeOffStatusController instance = new TimeOffStatusController();
        TimeOffStatus expResult = null;
//        TimeOffStatus result = instance.getTimeOffStatus(id);
     //   assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDefaultStatus method, of class TimeOffStatusController.
     */
    @Test
    public void testGetDefaultStatus() {
        System.out.println("getDefaultStatus");
        TimeOffStatusController instance = new TimeOffStatusController();
        TimeOffStatus expResult = null;
    //    TimeOffStatus result = instance.getDefaultStatus();
      //  assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of prepareEdit method, of class TimeOffStatusController.
     */
    @Test
    public void testPrepareEdit() {
        System.out.println("prepareEdit");
        int id = 0;
        TimeOffStatusController instance = new TimeOffStatusController();
        instance.prepareEdit(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCurrent method, of class TimeOffStatusController.
     */
    @Test
    public void testSetCurrent() {
        System.out.println("setCurrent");
        Object obj = null;
        TimeOffStatusController instance = new TimeOffStatusController();
        instance.setCurrent(obj);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createNewCurrent method, of class TimeOffStatusController.
     */
    @Test
    public void testCreateNewCurrent() {
        System.out.println("createNewCurrent");
        TimeOffStatusController instance = new TimeOffStatusController();
        instance.createNewCurrent();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
