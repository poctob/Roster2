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
import net.xpresstek.zroster.ejb.ClockOutReasons;
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
public class ClockOutReasonsControllerTest {
    
    public ClockOutReasonsControllerTest() {
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
     * Test of getAllItems method, of class ClockOutReasonsController.
     */
    @Test
    public void testGetAllItems() {
        System.out.println("getAllItems");
        ClockOutReasonsController instance = new ClockOutReasonsController();
        List<ClockOutReasons> expResult = null;
        List<ClockOutReasons> result = instance.getAllItems();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFacade method, of class ClockOutReasonsController.
     */
    @Test
    public void testGetFacade() {
        System.out.println("getFacade");
        ClockOutReasonsController instance = new ClockOutReasonsController();
        AbstractFacade expResult = null;
        AbstractFacade result = instance.getFacade();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrent method, of class ClockOutReasonsController.
     */
    @Test
    public void testGetCurrent() {
        System.out.println("getCurrent");
        ClockOutReasonsController instance = new ClockOutReasonsController();
        Object expResult = null;
        Object result = instance.getCurrent();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCurrent method, of class ClockOutReasonsController.
     */
    @Test
    public void testSetCurrent() {
        System.out.println("setCurrent");
        Object obj = null;
        ClockOutReasonsController instance = new ClockOutReasonsController();
        instance.setCurrent(obj);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createNewCurrent method, of class ClockOutReasonsController.
     */
    @Test
    public void testCreateNewCurrent() {
        System.out.println("createNewCurrent");
        ClockOutReasonsController instance = new ClockOutReasonsController();
        instance.createNewCurrent();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getClockOutReasons method, of class ClockOutReasonsController.
     */
    @Test
    public void testGetClockOutReasons() {
        System.out.println("getClockOutReasons");
        Integer id = null;
        ClockOutReasonsController instance = new ClockOutReasonsController();
        ClockOutReasons expResult = null;
//        ClockOutReasons result = instance.getClockOutReasons(id);
  //      assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
