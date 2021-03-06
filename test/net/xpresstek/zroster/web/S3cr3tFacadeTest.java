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
import net.xpresstek.zroster.ejb.S3cr3t;
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
public class S3cr3tFacadeTest {
    
    public S3cr3tFacadeTest() {
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
     * Test of create method, of class S3cr3tFacade.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        S3cr3t entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        S3cr3tFacade instance = (S3cr3tFacade)container.getContext().lookup("java:global/classes/S3cr3tFacade");
        instance.create(entity);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class S3cr3tFacade.
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        S3cr3t entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        S3cr3tFacade instance = (S3cr3tFacade)container.getContext().lookup("java:global/classes/S3cr3tFacade");
        instance.edit(entity);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class S3cr3tFacade.
     */
    @Test
    public void testRemove() throws Exception {
        System.out.println("remove");
        S3cr3t entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        S3cr3tFacade instance = (S3cr3tFacade)container.getContext().lookup("java:global/classes/S3cr3tFacade");
        instance.remove(entity);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of refresh method, of class S3cr3tFacade.
     */
    @Test
    public void testRefresh() throws Exception {
        System.out.println("refresh");
        S3cr3t entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        S3cr3tFacade instance = (S3cr3tFacade)container.getContext().lookup("java:global/classes/S3cr3tFacade");
        instance.refresh(entity);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class S3cr3tFacade.
     */
    @Test
    public void testFind() throws Exception {
        System.out.println("find");
        Object id = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        S3cr3tFacade instance = (S3cr3tFacade)container.getContext().lookup("java:global/classes/S3cr3tFacade");
        S3cr3t expResult = null;
        S3cr3t result = instance.find(id);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class S3cr3tFacade.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        S3cr3tFacade instance = (S3cr3tFacade)container.getContext().lookup("java:global/classes/S3cr3tFacade");
        List<S3cr3t> expResult = null;
        List<S3cr3t> result = instance.findAll();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findRange method, of class S3cr3tFacade.
     */
    @Test
    public void testFindRange() throws Exception {
        System.out.println("findRange");
        int[] range = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        S3cr3tFacade instance = (S3cr3tFacade)container.getContext().lookup("java:global/classes/S3cr3tFacade");
        List<S3cr3t> expResult = null;
        List<S3cr3t> result = instance.findRange(range);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of count method, of class S3cr3tFacade.
     */
    @Test
    public void testCount() throws Exception {
        System.out.println("count");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        S3cr3tFacade instance = (S3cr3tFacade)container.getContext().lookup("java:global/classes/S3cr3tFacade");
        int expResult = 0;
        int result = instance.count();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByEmployeeID method, of class S3cr3tFacade.
     */
    @Test
    public void testFindByEmployeeID() throws Exception {
        System.out.println("findByEmployeeID");
        int employeeID = 0;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        S3cr3tFacade instance = (S3cr3tFacade)container.getContext().lookup("java:global/classes/S3cr3tFacade");
        List<S3cr3t> expResult = null;
        List<S3cr3t> result = instance.findByEmployeeID(employeeID);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteByEmployeeID method, of class S3cr3tFacade.
     */
    @Test
    public void testDeleteByEmployeeID() throws Exception {
        System.out.println("deleteByEmployeeID");
        int employeeID = 0;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        S3cr3tFacade instance = (S3cr3tFacade)container.getContext().lookup("java:global/classes/S3cr3tFacade");
        instance.deleteByEmployeeID(employeeID);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
