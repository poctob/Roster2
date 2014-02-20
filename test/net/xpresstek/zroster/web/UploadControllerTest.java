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
public class UploadControllerTest {
    
    public UploadControllerTest() {
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
     * Test of getProgress method, of class UploadController.
     */
    @Test
    public void testGetProgress() {
        System.out.println("getProgress");
        UploadController instance = new UploadController();
        Integer expResult = null;
        Integer result = instance.getProgress();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProgress method, of class UploadController.
     */
    @Test
    public void testSetProgress() {
        System.out.println("setProgress");
        Integer progress = null;
        UploadController instance = new UploadController();
        instance.setProgress(progress);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of upload method, of class UploadController.
     */
    @Test
    public void testUpload() {
        System.out.println("upload");
        UploadController instance = new UploadController();
        instance.upload();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUrl method, of class UploadController.
     */
    @Test
    public void testGetUrl() {
        System.out.println("getUrl");
        UploadController instance = new UploadController();
        String expResult = "";
        String result = instance.getUrl();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUrl method, of class UploadController.
     */
    @Test
    public void testSetUrl() {
        System.out.println("setUrl");
        String url = "";
        UploadController instance = new UploadController();
        instance.setUrl(url);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDb_user method, of class UploadController.
     */
    @Test
    public void testGetDb_user() {
        System.out.println("getDb_user");
        UploadController instance = new UploadController();
        String expResult = "";
        String result = instance.getDb_user();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDb_user method, of class UploadController.
     */
    @Test
    public void testSetDb_user() {
        System.out.println("setDb_user");
        String db_user = "";
        UploadController instance = new UploadController();
        instance.setDb_user(db_user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDb_pass method, of class UploadController.
     */
    @Test
    public void testGetDb_pass() {
        System.out.println("getDb_pass");
        UploadController instance = new UploadController();
        String expResult = "";
        String result = instance.getDb_pass();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDb_pass method, of class UploadController.
     */
    @Test
    public void testSetDb_pass() {
        System.out.println("setDb_pass");
        String db_pass = "";
        UploadController instance = new UploadController();
        instance.setDb_pass(db_pass);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getResponse method, of class UploadController.
     */
    @Test
    public void testGetResponse() {
        System.out.println("getResponse");
        UploadController instance = new UploadController();
        String expResult = "";
        String result = instance.getResponse();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setResponse method, of class UploadController.
     */
    @Test
    public void testSetResponse() {
        System.out.println("setResponse");
        String response = "";
        UploadController instance = new UploadController();
        instance.setResponse(response);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cancel method, of class UploadController.
     */
    @Test
    public void testCancel() {
        System.out.println("cancel");
        UploadController instance = new UploadController();
        instance.cancel();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of onComplete method, of class UploadController.
     */
    @Test
    public void testOnComplete() {
        System.out.println("onComplete");
        UploadController instance = new UploadController();
        instance.onComplete();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
