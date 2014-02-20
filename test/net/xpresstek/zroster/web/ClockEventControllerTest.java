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

import java.util.List;
import net.xpresstek.zroster.ejb.ClockEvent;
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
public class ClockEventControllerTest {
    
    public ClockEventControllerTest() {
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
     * Test of getFacade method, of class ClockEventController.
     */
    @Test
    public void testGetFacade() {
        System.out.println("getFacade");
        ClockEventController instance = new ClockEventController();
        AbstractFacade expResult = null;
        AbstractFacade result = instance.getFacade();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrent method, of class ClockEventController.
     */
    @Test
    public void testGetCurrent() {
        System.out.println("getCurrent");
        ClockEventController instance = new ClockEventController();
        Object expResult = null;
        Object result = instance.getCurrent();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCurrent method, of class ClockEventController.
     */
    @Test
    public void testSetCurrent() {
        System.out.println("setCurrent");
        Object obj = null;
        ClockEventController instance = new ClockEventController();
        instance.setCurrent(obj);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createNewCurrent method, of class ClockEventController.
     */
    @Test
    public void testCreateNewCurrent() {
        System.out.println("createNewCurrent");
        ClockEventController instance = new ClockEventController();
        instance.createNewCurrent();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getClockOutId method, of class ClockEventController.
     */
    @Test
    public void testGetClockOutId() {
        System.out.println("getClockOutId");
        ClockEventController instance = new ClockEventController();
        ClockEvent expResult = null;
        ClockEvent result = instance.getClockOutId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllItems method, of class ClockEventController.
     */
    @Test
    public void testGetAllItems() {
        System.out.println("getAllItems");
        ClockEventController instance = new ClockEventController();
        List<ClockEvent> expResult = null;
        List<ClockEvent> result = instance.getAllItems();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getClockInId method, of class ClockEventController.
     */
    @Test
    public void testGetClockInId() {
        System.out.println("getClockInId");
        ClockEventController instance = new ClockEventController();
        ClockEvent expResult = null;
        ClockEvent result = instance.getClockInId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getClockEvent method, of class ClockEventController.
     */
    @Test
    public void testGetClockEvent() {
        System.out.println("getClockEvent");
        Integer id = null;
        ClockEventController instance = new ClockEventController();
        ClockEvent expResult = null;
        ClockEvent result = instance.getClockEvent(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
