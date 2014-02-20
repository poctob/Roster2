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
import javax.ejb.embeddable.EJBContainer;
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
public class ClockEventFacadeTest {
    
    public ClockEventFacadeTest() {
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
     * Test of create method, of class ClockEventFacade.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        ClockEvent entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ClockEventFacade instance = (ClockEventFacade)container.getContext().lookup("java:global/classes/ClockEventFacade");
        instance.create(entity);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class ClockEventFacade.
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        ClockEvent entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ClockEventFacade instance = (ClockEventFacade)container.getContext().lookup("java:global/classes/ClockEventFacade");
        instance.edit(entity);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class ClockEventFacade.
     */
    @Test
    public void testRemove() throws Exception {
        System.out.println("remove");
        ClockEvent entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ClockEventFacade instance = (ClockEventFacade)container.getContext().lookup("java:global/classes/ClockEventFacade");
        instance.remove(entity);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of refresh method, of class ClockEventFacade.
     */
    @Test
    public void testRefresh() throws Exception {
        System.out.println("refresh");
        ClockEvent entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ClockEventFacade instance = (ClockEventFacade)container.getContext().lookup("java:global/classes/ClockEventFacade");
        instance.refresh(entity);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class ClockEventFacade.
     */
    @Test
    public void testFind() throws Exception {
        System.out.println("find");
        Object id = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ClockEventFacade instance = (ClockEventFacade)container.getContext().lookup("java:global/classes/ClockEventFacade");
        ClockEvent expResult = null;
        ClockEvent result = instance.find(id);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class ClockEventFacade.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ClockEventFacade instance = (ClockEventFacade)container.getContext().lookup("java:global/classes/ClockEventFacade");
        List<ClockEvent> expResult = null;
        List<ClockEvent> result = instance.findAll();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findRange method, of class ClockEventFacade.
     */
    @Test
    public void testFindRange() throws Exception {
        System.out.println("findRange");
        int[] range = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ClockEventFacade instance = (ClockEventFacade)container.getContext().lookup("java:global/classes/ClockEventFacade");
        List<ClockEvent> expResult = null;
        List<ClockEvent> result = instance.findRange(range);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of count method, of class ClockEventFacade.
     */
    @Test
    public void testCount() throws Exception {
        System.out.println("count");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ClockEventFacade instance = (ClockEventFacade)container.getContext().lookup("java:global/classes/ClockEventFacade");
        int expResult = 0;
        int result = instance.count();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getClockOutEvent method, of class ClockEventFacade.
     */
    @Test
    public void testGetClockOutEvent() throws Exception {
        System.out.println("getClockOutEvent");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ClockEventFacade instance = (ClockEventFacade)container.getContext().lookup("java:global/classes/ClockEventFacade");
        ClockEvent expResult = null;
        ClockEvent result = instance.getClockOutEvent();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getClockInEvent method, of class ClockEventFacade.
     */
    @Test
    public void testGetClockInEvent() throws Exception {
        System.out.println("getClockInEvent");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ClockEventFacade instance = (ClockEventFacade)container.getContext().lookup("java:global/classes/ClockEventFacade");
        ClockEvent expResult = null;
        ClockEvent result = instance.getClockInEvent();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
