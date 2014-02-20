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

import java.util.Date;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import net.xpresstek.zroster.ejb.ClockEventTrans;
import net.xpresstek.zroster.ejb.Employee;
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
public class ClockEventTransFacadeTest {
    
    public ClockEventTransFacadeTest() {
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
     * Test of create method, of class ClockEventTransFacade.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        ClockEventTrans entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ClockEventTransFacade instance = (ClockEventTransFacade)container.getContext().lookup("java:global/classes/ClockEventTransFacade");
        instance.create(entity);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class ClockEventTransFacade.
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        ClockEventTrans entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ClockEventTransFacade instance = (ClockEventTransFacade)container.getContext().lookup("java:global/classes/ClockEventTransFacade");
        instance.edit(entity);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class ClockEventTransFacade.
     */
    @Test
    public void testRemove() throws Exception {
        System.out.println("remove");
        ClockEventTrans entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ClockEventTransFacade instance = (ClockEventTransFacade)container.getContext().lookup("java:global/classes/ClockEventTransFacade");
        instance.remove(entity);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of refresh method, of class ClockEventTransFacade.
     */
    @Test
    public void testRefresh() throws Exception {
        System.out.println("refresh");
        ClockEventTrans entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ClockEventTransFacade instance = (ClockEventTransFacade)container.getContext().lookup("java:global/classes/ClockEventTransFacade");
        instance.refresh(entity);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class ClockEventTransFacade.
     */
    @Test
    public void testFind() throws Exception {
        System.out.println("find");
        Object id = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ClockEventTransFacade instance = (ClockEventTransFacade)container.getContext().lookup("java:global/classes/ClockEventTransFacade");
        ClockEventTrans expResult = null;
        ClockEventTrans result = instance.find(id);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class ClockEventTransFacade.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ClockEventTransFacade instance = (ClockEventTransFacade)container.getContext().lookup("java:global/classes/ClockEventTransFacade");
        List<ClockEventTrans> expResult = null;
        List<ClockEventTrans> result = instance.findAll();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findRange method, of class ClockEventTransFacade.
     */
    @Test
    public void testFindRange() throws Exception {
        System.out.println("findRange");
        int[] range = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ClockEventTransFacade instance = (ClockEventTransFacade)container.getContext().lookup("java:global/classes/ClockEventTransFacade");
        List<ClockEventTrans> expResult = null;
        List<ClockEventTrans> result = instance.findRange(range);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of count method, of class ClockEventTransFacade.
     */
    @Test
    public void testCount() throws Exception {
        System.out.println("count");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ClockEventTransFacade instance = (ClockEventTransFacade)container.getContext().lookup("java:global/classes/ClockEventTransFacade");
        int expResult = 0;
        int result = instance.count();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastEvent method, of class ClockEventTransFacade.
     */
    @Test
    public void testGetLastEvent() throws Exception {
        System.out.println("getLastEvent");
        Employee employee_id = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ClockEventTransFacade instance = (ClockEventTransFacade)container.getContext().lookup("java:global/classes/ClockEventTransFacade");
        ClockEventTrans expResult = null;
        ClockEventTrans result = instance.getLastEvent(employee_id);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastClockIn method, of class ClockEventTransFacade.
     */
    @Test
    public void testGetLastClockIn() throws Exception {
        System.out.println("getLastClockIn");
        Employee employee_id = null;
        ClockEventTrans clock_out = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ClockEventTransFacade instance = (ClockEventTransFacade)container.getContext().lookup("java:global/classes/ClockEventTransFacade");
        ClockEventTrans expResult = null;
        ClockEventTrans result = instance.getLastClockIn(employee_id, clock_out);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findClockEventsByEmployeeAndInterval method, of class ClockEventTransFacade.
     */
    @Test
    public void testFindClockEventsByEmployeeAndInterval() throws Exception {
        System.out.println("findClockEventsByEmployeeAndInterval");
        Employee employee = null;
        Date start = null;
        Date end = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ClockEventTransFacade instance = (ClockEventTransFacade)container.getContext().lookup("java:global/classes/ClockEventTransFacade");
        List<ClockEventTrans> expResult = null;
        List<ClockEventTrans> result = instance.findClockEventsByEmployeeAndInterval(employee, start, end);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findClockEventsByInterval method, of class ClockEventTransFacade.
     */
    @Test
    public void testFindClockEventsByInterval() throws Exception {
        System.out.println("findClockEventsByInterval");
        Date start = null;
        Date end = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ClockEventTransFacade instance = (ClockEventTransFacade)container.getContext().lookup("java:global/classes/ClockEventTransFacade");
        List<ClockEventTrans> expResult = null;
        List<ClockEventTrans> result = instance.findClockEventsByInterval(start, end);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
