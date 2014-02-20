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

import javax.faces.model.DataModel;
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
public class PaginationHelperTest {
    
    public PaginationHelperTest() {
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
     * Test of getItemsCount method, of class PaginationHelper.
     */
    @Test
    public void testGetItemsCount() {
        System.out.println("getItemsCount");
        PaginationHelper instance = null;
        int expResult = 0;
        int result = instance.getItemsCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createPageDataModel method, of class PaginationHelper.
     */
    @Test
    public void testCreatePageDataModel() {
        System.out.println("createPageDataModel");
        PaginationHelper instance = null;
        DataModel expResult = null;
        DataModel result = instance.createPageDataModel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPageFirstItem method, of class PaginationHelper.
     */
    @Test
    public void testGetPageFirstItem() {
        System.out.println("getPageFirstItem");
        PaginationHelper instance = null;
        int expResult = 0;
        int result = instance.getPageFirstItem();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPageLastItem method, of class PaginationHelper.
     */
    @Test
    public void testGetPageLastItem() {
        System.out.println("getPageLastItem");
        PaginationHelper instance = null;
        int expResult = 0;
        int result = instance.getPageLastItem();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isHasNextPage method, of class PaginationHelper.
     */
    @Test
    public void testIsHasNextPage() {
        System.out.println("isHasNextPage");
        PaginationHelper instance = null;
        boolean expResult = false;
        boolean result = instance.isHasNextPage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nextPage method, of class PaginationHelper.
     */
    @Test
    public void testNextPage() {
        System.out.println("nextPage");
        PaginationHelper instance = null;
        instance.nextPage();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isHasPreviousPage method, of class PaginationHelper.
     */
    @Test
    public void testIsHasPreviousPage() {
        System.out.println("isHasPreviousPage");
        PaginationHelper instance = null;
        boolean expResult = false;
        boolean result = instance.isHasPreviousPage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of previousPage method, of class PaginationHelper.
     */
    @Test
    public void testPreviousPage() {
        System.out.println("previousPage");
        PaginationHelper instance = null;
        instance.previousPage();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPageSize method, of class PaginationHelper.
     */
    @Test
    public void testGetPageSize() {
        System.out.println("getPageSize");
        PaginationHelper instance = null;
        int expResult = 0;
        int result = instance.getPageSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class PaginationHelperImpl extends PaginationHelper {

        public PaginationHelperImpl() {
            super(0);
        }

        public int getItemsCount() {
            return 0;
        }

        public DataModel createPageDataModel() {
            return null;
        }
    }
    
}
