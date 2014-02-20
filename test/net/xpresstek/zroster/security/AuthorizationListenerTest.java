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
package net.xpresstek.zroster.security;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
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
public class AuthorizationListenerTest {
    
    public AuthorizationListenerTest() {
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
     * Test of afterPhase method, of class AuthorizationListener.
     */
    @Test
    public void testAfterPhase() {
        System.out.println("afterPhase");
        PhaseEvent event = null;
        AuthorizationListener instance = new AuthorizationListener();
        instance.afterPhase(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of beforePhase method, of class AuthorizationListener.
     */
    @Test
    public void testBeforePhase() {
        System.out.println("beforePhase");
        PhaseEvent event = null;
        AuthorizationListener instance = new AuthorizationListener();
        instance.beforePhase(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPhaseId method, of class AuthorizationListener.
     */
    @Test
    public void testGetPhaseId() {
        System.out.println("getPhaseId");
        AuthorizationListener instance = new AuthorizationListener();
        PhaseId expResult = null;
        PhaseId result = instance.getPhaseId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
