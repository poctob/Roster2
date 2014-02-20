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
public class PositionFacadeTest {
    
    public PositionFacadeTest() {
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
     * Test of create method, of class PositionFacade.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Position entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        PositionFacade instance = (PositionFacade)container.getContext().lookup("java:global/classes/PositionFacade");
        instance.create(entity);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class PositionFacade.
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        Position entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        PositionFacade instance = (PositionFacade)container.getContext().lookup("java:global/classes/PositionFacade");
        instance.edit(entity);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class PositionFacade.
     */
    @Test
    public void testRemove() throws Exception {
        System.out.println("remove");
        Position entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        PositionFacade instance = (PositionFacade)container.getContext().lookup("java:global/classes/PositionFacade");
        instance.remove(entity);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of refresh method, of class PositionFacade.
     */
    @Test
    public void testRefresh() throws Exception {
        System.out.println("refresh");
        Position entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        PositionFacade instance = (PositionFacade)container.getContext().lookup("java:global/classes/PositionFacade");
        instance.refresh(entity);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class PositionFacade.
     */
    @Test
    public void testFind() throws Exception {
        System.out.println("find");
        Object id = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        PositionFacade instance = (PositionFacade)container.getContext().lookup("java:global/classes/PositionFacade");
        Position expResult = null;
        Position result = instance.find(id);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class PositionFacade.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        PositionFacade instance = (PositionFacade)container.getContext().lookup("java:global/classes/PositionFacade");
        List<Position> expResult = null;
        List<Position> result = instance.findAll();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findRange method, of class PositionFacade.
     */
    @Test
    public void testFindRange() throws Exception {
        System.out.println("findRange");
        int[] range = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        PositionFacade instance = (PositionFacade)container.getContext().lookup("java:global/classes/PositionFacade");
        List<Position> expResult = null;
        List<Position> result = instance.findRange(range);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of count method, of class PositionFacade.
     */
    @Test
    public void testCount() throws Exception {
        System.out.println("count");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        PositionFacade instance = (PositionFacade)container.getContext().lookup("java:global/classes/PositionFacade");
        int expResult = 0;
        int result = instance.count();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
