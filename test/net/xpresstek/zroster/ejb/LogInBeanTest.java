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
public class LogInBeanTest {
    
    public LogInBeanTest() {
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
     * Test of getUser method, of class LogInBean.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        LogInBean instance = new LogInBean();
        String expResult = "";
        String result = instance.getUser();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUser method, of class LogInBean.
     */
    @Test
    public void testSetUser() {
        System.out.println("setUser");
        String user = "";
        LogInBean instance = new LogInBean();
        instance.setUser(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPassword method, of class LogInBean.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        LogInBean instance = new LogInBean();
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPassword method, of class LogInBean.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "";
        LogInBean instance = new LogInBean();
        instance.setPassword(password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isLoggedIn method, of class LogInBean.
     */
    @Test
    public void testIsLoggedIn() {
        System.out.println("isLoggedIn");
        LogInBean instance = new LogInBean();
        boolean expResult = false;
        boolean result = instance.isLoggedIn();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLoggedIn method, of class LogInBean.
     */
    @Test
    public void testSetLoggedIn() {
        System.out.println("setLoggedIn");
        boolean loggedIn = false;
        LogInBean instance = new LogInBean();
        instance.setLoggedIn(loggedIn);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of logout method, of class LogInBean.
     */
    @Test
    public void testLogout() {
        System.out.println("logout");
        LogInBean instance = new LogInBean();
        String expResult = "";
        String result = instance.logout();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of login method, of class LogInBean.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        LogInBean instance = new LogInBean();
        String expResult = "";
        String result = instance.login();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addCurrentMessage method, of class LogInBean.
     */
    @Test
    public void testAddCurrentMessage() {
        System.out.println("addCurrentMessage");
        LogInBean instance = new LogInBean();
        instance.addCurrentMessage();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
