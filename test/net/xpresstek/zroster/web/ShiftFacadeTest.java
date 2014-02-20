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
import net.xpresstek.zroster.ejb.Shift;
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
public class ShiftFacadeTest {
    
    public ShiftFacadeTest() {
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
     * Test of create method, of class ShiftFacade.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Shift entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ShiftFacade instance = (ShiftFacade)container.getContext().lookup("java:global/classes/ShiftFacade");
        instance.create(entity);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class ShiftFacade.
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        Shift entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ShiftFacade instance = (ShiftFacade)container.getContext().lookup("java:global/classes/ShiftFacade");
        instance.edit(entity);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class ShiftFacade.
     */
    @Test
    public void testRemove() throws Exception {
        System.out.println("remove");
        Shift entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ShiftFacade instance = (ShiftFacade)container.getContext().lookup("java:global/classes/ShiftFacade");
        instance.remove(entity);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of refresh method, of class ShiftFacade.
     */
    @Test
    public void testRefresh() throws Exception {
        System.out.println("refresh");
        Shift entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ShiftFacade instance = (ShiftFacade)container.getContext().lookup("java:global/classes/ShiftFacade");
        instance.refresh(entity);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class ShiftFacade.
     */
    @Test
    public void testFind() throws Exception {
        System.out.println("find");
        Object id = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ShiftFacade instance = (ShiftFacade)container.getContext().lookup("java:global/classes/ShiftFacade");
        Shift expResult = null;
        Shift result = instance.find(id);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class ShiftFacade.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ShiftFacade instance = (ShiftFacade)container.getContext().lookup("java:global/classes/ShiftFacade");
        List<Shift> expResult = null;
        List<Shift> result = instance.findAll();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findRange method, of class ShiftFacade.
     */
    @Test
    public void testFindRange() throws Exception {
        System.out.println("findRange");
        int[] range = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ShiftFacade instance = (ShiftFacade)container.getContext().lookup("java:global/classes/ShiftFacade");
        List<Shift> expResult = null;
        List<Shift> result = instance.findRange(range);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of count method, of class ShiftFacade.
     */
    @Test
    public void testCount() throws Exception {
        System.out.println("count");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ShiftFacade instance = (ShiftFacade)container.getContext().lookup("java:global/classes/ShiftFacade");
        int expResult = 0;
        int result = instance.count();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByPositionIdAndStart method, of class ShiftFacade.
     */
    @Test
    public void testFindByPositionIdAndStart() throws Exception {
        System.out.println("findByPositionIdAndStart");
        int id = 0;
        Date start = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ShiftFacade instance = (ShiftFacade)container.getContext().lookup("java:global/classes/ShiftFacade");
        List<Shift> expResult = null;
        List<Shift> result = instance.findByPositionIdAndStart(id, start);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByPositionIdAndEmployeeIDAndStart method, of class ShiftFacade.
     */
    @Test
    public void testFindByPositionIdAndEmployeeIDAndStart() throws Exception {
        System.out.println("findByPositionIdAndEmployeeIDAndStart");
        int pos_id = 0;
        int emp_id = 0;
        Date start = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ShiftFacade instance = (ShiftFacade)container.getContext().lookup("java:global/classes/ShiftFacade");
        List<Shift> expResult = null;
        List<Shift> result = instance.findByPositionIdAndEmployeeIDAndStart(pos_id, emp_id, start);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByEmployeeIDAndStart method, of class ShiftFacade.
     */
    @Test
    public void testFindByEmployeeIDAndStart() throws Exception {
        System.out.println("findByEmployeeIDAndStart");
        int emp_id = 0;
        Date start = null;
        Date end = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ShiftFacade instance = (ShiftFacade)container.getContext().lookup("java:global/classes/ShiftFacade");
        List<Shift> expResult = null;
        List<Shift> result = instance.findByEmployeeIDAndStart(emp_id, start, end);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByStartAndEmployee method, of class ShiftFacade.
     */
    @Test
    public void testFindByStartAndEmployee() throws Exception {
        System.out.println("findByStartAndEmployee");
        Date start = null;
        int emp_id = 0;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ShiftFacade instance = (ShiftFacade)container.getContext().lookup("java:global/classes/ShiftFacade");
        List<Shift> expResult = null;
        List<Shift> result = instance.findByStartAndEmployee(start, emp_id);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByStartandEnd method, of class ShiftFacade.
     */
    @Test
    public void testFindByStartandEnd() throws Exception {
        System.out.println("findByStartandEnd");
        Date start = null;
        Date end = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ShiftFacade instance = (ShiftFacade)container.getContext().lookup("java:global/classes/ShiftFacade");
        List<Shift> expResult = null;
        List<Shift> result = instance.findByStartandEnd(start, end);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByPeriod method, of class ShiftFacade.
     */
    @Test
    public void testFindByPeriod() throws Exception {
        System.out.println("findByPeriod");
        Date start = null;
        Date end = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ShiftFacade instance = (ShiftFacade)container.getContext().lookup("java:global/classes/ShiftFacade");
        List<Shift> expResult = null;
        List<Shift> result = instance.findByPeriod(start, end);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByStart method, of class ShiftFacade.
     */
    @Test
    public void testFindByStart() throws Exception {
        System.out.println("findByStart");
        Date start = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ShiftFacade instance = (ShiftFacade)container.getContext().lookup("java:global/classes/ShiftFacade");
        List<Shift> expResult = null;
        List<Shift> result = instance.findByStart(start);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findShiftsByEmployeeAndInterval method, of class ShiftFacade.
     */
    @Test
    public void testFindShiftsByEmployeeAndInterval() throws Exception {
        System.out.println("findShiftsByEmployeeAndInterval");
        int empl_id = 0;
        Date start = null;
        Date end = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ShiftFacade instance = (ShiftFacade)container.getContext().lookup("java:global/classes/ShiftFacade");
        List<Shift> expResult = null;
        List<Shift> result = instance.findShiftsByEmployeeAndInterval(empl_id, start, end);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
