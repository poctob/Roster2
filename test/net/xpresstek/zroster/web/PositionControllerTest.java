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
public class PositionControllerTest {
    
    public PositionControllerTest() {
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
     * Test of getFacade method, of class PositionController.
     */
    @Test
    public void testGetFacade() {
        System.out.println("getFacade");
        PositionController instance = new PositionController();
        AbstractFacade expResult = null;
        AbstractFacade result = instance.getFacade();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrent method, of class PositionController.
     */
    @Test
    public void testGetCurrent() {
        System.out.println("getCurrent");
        PositionController instance = new PositionController();
        Object expResult = null;
        Object result = instance.getCurrent();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPosition method, of class PositionController.
     */
    @Test
    public void testGetPosition() {
        System.out.println("getPosition");
        Integer id = null;
        PositionController instance = new PositionController();
        Position expResult = null;
        Position result = instance.getPosition(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPositionByName method, of class PositionController.
     */
    @Test
    public void testGetPositionByName() {
        System.out.println("getPositionByName");
        String name = "";
        PositionController instance = new PositionController();
        Position expResult = null;
        Position result = instance.getPositionByName(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCurrent method, of class PositionController.
     */
    @Test
    public void testSetCurrent() {
        System.out.println("setCurrent");
        Object obj = null;
        PositionController instance = new PositionController();
        instance.setCurrent(obj);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createNewCurrent method, of class PositionController.
     */
    @Test
    public void testCreateNewCurrent() {
        System.out.println("createNewCurrent");
        PositionController instance = new PositionController();
        instance.createNewCurrent();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllItems method, of class PositionController.
     */
    @Test
    public void testGetAllItems() {
        System.out.println("getAllItems");
        PositionController instance = new PositionController();
        List<Position> expResult = null;
        List<Position> result = instance.getAllItems();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
