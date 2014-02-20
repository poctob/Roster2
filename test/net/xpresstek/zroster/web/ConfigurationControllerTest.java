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
import net.xpresstek.zroster.ejb.Configuration;
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
public class ConfigurationControllerTest {
    
    public ConfigurationControllerTest() {
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
     * Test of getTimeSlots method, of class ConfigurationController.
     */
    @Test
    public void testGetTimeSlots() {
        System.out.println("getTimeSlots");
        ConfigurationController instance = new ConfigurationController();
        List expResult = null;
        List result = instance.getTimeSlots();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTimeSlotsDate method, of class ConfigurationController.
     */
    @Test
    public void testGetTimeSlotsDate() {
        System.out.println("getTimeSlotsDate");
        String date = "";
        ConfigurationController instance = new ConfigurationController();
        List expResult = null;
        List result = instance.getTimeSlotsDate(date);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getConfiguration method, of class ConfigurationController.
     */
    @Test
    public void testGetConfiguration() {
        System.out.println("getConfiguration");
        String id = "";
        ConfigurationController instance = new ConfigurationController();
        Configuration expResult = null;
        Configuration result = instance.getConfiguration(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrent method, of class ConfigurationController.
     */
    @Test
    public void testGetCurrent() {
        System.out.println("getCurrent");
        ConfigurationController instance = new ConfigurationController();
        Object expResult = null;
        Object result = instance.getCurrent();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCurrent method, of class ConfigurationController.
     */
    @Test
    public void testSetCurrent() {
        System.out.println("setCurrent");
        Object obj = null;
        ConfigurationController instance = new ConfigurationController();
        instance.setCurrent(obj);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createNewCurrent method, of class ConfigurationController.
     */
    @Test
    public void testCreateNewCurrent() {
        System.out.println("createNewCurrent");
        ConfigurationController instance = new ConfigurationController();
        instance.createNewCurrent();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFacade method, of class ConfigurationController.
     */
    @Test
    public void testGetFacade() {
        System.out.println("getFacade");
        ConfigurationController instance = new ConfigurationController();
        AbstractFacade expResult = null;
        AbstractFacade result = instance.getFacade();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
