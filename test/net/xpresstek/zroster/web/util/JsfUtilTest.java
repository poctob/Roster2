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
package net.xpresstek.zroster.web.util;

import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.convert.Converter;
import javax.faces.model.SelectItem;
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
public class JsfUtilTest {
    
    public JsfUtilTest() {
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
     * Test of getSelectItems method, of class JsfUtil.
     */
    @Test
    public void testGetSelectItems() {
        System.out.println("getSelectItems");
        List entities = null;
        boolean selectOne = false;
        SelectItem[] expResult = null;
        SelectItem[] result = JsfUtil.getSelectItems(entities, selectOne);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addErrorMessage method, of class JsfUtil.
     */
    @Test
    public void testAddErrorMessage_Exception_String() {
        System.out.println("addErrorMessage");
        Exception ex = null;
        String defaultMsg = "";
        JsfUtil.addErrorMessage(ex, defaultMsg);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addErrorMessages method, of class JsfUtil.
     */
    @Test
    public void testAddErrorMessages() {
        System.out.println("addErrorMessages");
        List<String> messages = null;
        JsfUtil.addErrorMessages(messages);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addErrorMessage method, of class JsfUtil.
     */
    @Test
    public void testAddErrorMessage_String() {
        System.out.println("addErrorMessage");
        String msg = "";
        JsfUtil.addErrorMessage(msg);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addSuccessMessage method, of class JsfUtil.
     */
    @Test
    public void testAddSuccessMessage() {
        System.out.println("addSuccessMessage");
        String msg = "";
        JsfUtil.addSuccessMessage(msg);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRequestParameter method, of class JsfUtil.
     */
    @Test
    public void testGetRequestParameter() {
        System.out.println("getRequestParameter");
        String key = "";
        String expResult = "";
        String result = JsfUtil.getRequestParameter(key);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getObjectFromRequestParameter method, of class JsfUtil.
     */
    @Test
    public void testGetObjectFromRequestParameter() {
        System.out.println("getObjectFromRequestParameter");
        String requestParameterName = "";
        Converter converter = null;
        UIComponent component = null;
        Object expResult = null;
        Object result = JsfUtil.getObjectFromRequestParameter(requestParameterName, converter, component);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
