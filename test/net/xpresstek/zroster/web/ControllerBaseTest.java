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

import javax.faces.model.DataModel;
import javax.faces.model.SelectItem;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author apavlune
 */
public class ControllerBaseTest {
    
    public ControllerBaseTest() {
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
     * Test of create method, of class ControllerBase.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        ControllerBase instance = new ControllerBaseImpl();
        instance.create();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSelected method, of class ControllerBase.
     */
    @Test
    public void testGetSelected() {
        System.out.println("getSelected");
        ControllerBase instance = new ControllerBaseImpl();
        Object expResult = null;
        Object result = instance.getSelected();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStatus method, of class ControllerBase.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        ControllerBase instance = new ControllerBaseImpl();
        String expResult = "";
        String result = instance.getStatus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of destroy method, of class ControllerBase.
     */
    @Test
    public void testDestroy() {
        System.out.println("destroy");
        ControllerBase instance = new ControllerBaseImpl();
        instance.destroy();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of destroyAndView method, of class ControllerBase.
     */
    @Test
    public void testDestroyAndView() {
        System.out.println("destroyAndView");
        ControllerBase instance = new ControllerBaseImpl();
        instance.destroyAndView();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFacade method, of class ControllerBase.
     */
    @Test
    public void testGetFacade() {
        System.out.println("getFacade");
        ControllerBase instance = new ControllerBaseImpl();
        AbstractFacade expResult = null;
        AbstractFacade result = instance.getFacade();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrent method, of class ControllerBase.
     */
    @Test
    public void testGetCurrent() {
        System.out.println("getCurrent");
        ControllerBase instance = new ControllerBaseImpl();
        Object expResult = null;
        Object result = instance.getCurrent();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCurrent method, of class ControllerBase.
     */
    @Test
    public void testSetCurrent() {
        System.out.println("setCurrent");
        Object obj = null;
        ControllerBase instance = new ControllerBaseImpl();
        instance.setCurrent(obj);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createNewCurrent method, of class ControllerBase.
     */
    @Test
    public void testCreateNewCurrent() {
        System.out.println("createNewCurrent");
        ControllerBase instance = new ControllerBaseImpl();
        instance.createNewCurrent();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getItems method, of class ControllerBase.
     */
    @Test
    public void testGetItems() {
        System.out.println("getItems");
        ControllerBase instance = new ControllerBaseImpl();
        DataModel expResult = null;
        DataModel result = instance.getItems();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getItemsAvailableSelectMany method, of class ControllerBase.
     */
    @Test
    public void testGetItemsAvailableSelectMany() {
        System.out.println("getItemsAvailableSelectMany");
        ControllerBase instance = new ControllerBaseImpl();
        SelectItem[] expResult = null;
        SelectItem[] result = instance.getItemsAvailableSelectMany();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getItemsAvailableSelectOne method, of class ControllerBase.
     */
    @Test
    public void testGetItemsAvailableSelectOne() {
        System.out.println("getItemsAvailableSelectOne");
        ControllerBase instance = new ControllerBaseImpl();
        SelectItem[] expResult = null;
        SelectItem[] result = instance.getItemsAvailableSelectOne();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getObject method, of class ControllerBase.
     */
    @Test
    public void testGetObject_Integer() {
        System.out.println("getObject");
        Integer id = null;
        ControllerBase instance = new ControllerBaseImpl();
        Object expResult = null;
        Object result = instance.getObject(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getObject method, of class ControllerBase.
     */
    @Test
    public void testGetObject_String() {
        System.out.println("getObject");
        String id = "";
        ControllerBase instance = new ControllerBaseImpl();
        Object expResult = null;
        Object result = instance.getObject(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of performDestroy method, of class ControllerBase.
     */
    @Test
    public void testPerformDestroy() {
        System.out.println("performDestroy");
        ControllerBase instance = new ControllerBaseImpl();
        instance.performDestroy();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of prepareCreate method, of class ControllerBase.
     */
    @Test
    public void testPrepareCreate() {
        System.out.println("prepareCreate");
        ControllerBase instance = new ControllerBaseImpl();
        instance.prepareCreate();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of prepareEdit method, of class ControllerBase.
     */
    @Test
    public void testPrepareEdit() {
        System.out.println("prepareEdit");
        ControllerBase instance = new ControllerBaseImpl();
        instance.prepareEdit();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of prepareList method, of class ControllerBase.
     */
    @Test
    public void testPrepareList() {
        System.out.println("prepareList");
        ControllerBase instance = new ControllerBaseImpl();
        String expResult = "";
        String result = instance.prepareList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of recreateModel method, of class ControllerBase.
     */
    @Test
    public void testRecreateModel() {
        System.out.println("recreateModel");
        ControllerBase instance = new ControllerBaseImpl();
        instance.recreateModel();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class ControllerBase.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        ControllerBase instance = new ControllerBaseImpl();
        instance.update();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateCurrentItem method, of class ControllerBase.
     */
    @Test
    public void testUpdateCurrentItem() {
        System.out.println("updateCurrentItem");
        ControllerBase instance = new ControllerBaseImpl();
        instance.updateCurrentItem();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of onRowEdit method, of class ControllerBase.
     */
    @Test
    public void testOnRowEdit() {
        System.out.println("onRowEdit");
        RowEditEvent event = null;
        ControllerBase instance = new ControllerBaseImpl();
        instance.onRowEdit(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of onRowEditCancel method, of class ControllerBase.
     */
    @Test
    public void testOnRowEditCancel() {
        System.out.println("onRowEditCancel");
        RowEditEvent event = null;
        ControllerBase instance = new ControllerBaseImpl();
        instance.onRowEditCancel(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class ControllerBaseImpl extends ControllerBase {

        public AbstractFacade getFacade() {
            return null;
        }

        public Object getCurrent() {
            return null;
        }

        public void setCurrent(Object obj) {
        }

        public void createNewCurrent() {
        }
    }
    
}
