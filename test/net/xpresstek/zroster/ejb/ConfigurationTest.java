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
public class ConfigurationTest {
    
    public ConfigurationTest() {
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
     * Test of getConfigID method, of class Configuration.
     */
    @Test
    public void testGetConfigID() {
        System.out.println("getConfigID");
        Configuration instance = new Configuration();
        String expResult = "";
        String result = instance.getConfigID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setConfigID method, of class Configuration.
     */
    @Test
    public void testSetConfigID() {
        System.out.println("setConfigID");
        String configID = "";
        Configuration instance = new Configuration();
        instance.setConfigID(configID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getConfigValue method, of class Configuration.
     */
    @Test
    public void testGetConfigValue() {
        System.out.println("getConfigValue");
        Configuration instance = new Configuration();
        String expResult = "";
        String result = instance.getConfigValue();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setConfigValue method, of class Configuration.
     */
    @Test
    public void testSetConfigValue() {
        System.out.println("setConfigValue");
        String configValue = "";
        Configuration instance = new Configuration();
        instance.setConfigValue(configValue);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Configuration.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Configuration instance = new Configuration();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Configuration.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Configuration instance = new Configuration();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Configuration.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Configuration instance = new Configuration();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
