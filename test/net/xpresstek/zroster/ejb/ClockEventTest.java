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
package net.xpresstek.zroster.ejb;

import java.util.ArrayList;
import java.util.Collection;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
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
public class ClockEventTest {

    private final static String LONG_STRING = "Really long"
            + " string that is longer than "
            + "expected for this type of database field.  "
            + "Lorem ipsum dolor sit amet, consectetur adipisicing elit, "
            + "sed do eiusmod tempor incididunt ut labore et dolore magna"
            + " aliqua. Ut enim ad minim veniam, quis nostrud exercitation"
            + " ullamco laboris nisi ut aliquip ex ea commodo consequat. "
            + "Duis aute irure dolor in reprehenderit in voluptate velit "
            + "esse cillum dolore eu fugiat nulla pariatur. Excepteur sint "
            + "occaecat cupidatat non proident, sunt in culpa qui officia "
            + "deserunt mollit anim id est laborum.";

    public ClockEventTest() {
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
     * Test of getPkid and setPkid method, of class ClockEvent.
     */
    @Test
    public void testGetAndSetPkid() {
        System.out.println("getPkid");
        ClockEvent instance = new ClockEvent();
        Integer expResult = 200;
        instance.setPkid(expResult);
        Integer result = instance.getPkid();
        assertThat(expResult, is(result));

        Integer wrongResult = 0;
        instance.setPkid(wrongResult);
        result = instance.getPkid();
        assertThat(result, not(wrongResult));
        assertThat(expResult, is(result));

    }

    /**
     * Test of getName and setName methods, of class ClockEvent.
     */
    @Test
    public void testGetAndSetName() {
        System.out.println("getName");
        ClockEvent instance = new ClockEvent();
        String expResult = "Test Event Name";

        instance.setName(expResult);
        String result = instance.getName();
        assertThat(expResult, is(result));

        String wrongResult = null;
        instance.setName(wrongResult);
        result = instance.getName();
        assertThat(result, not(wrongResult));

        wrongResult = "";
        instance.setName(wrongResult);
        result = instance.getName();
        assertThat(result, not(wrongResult));

        wrongResult = LONG_STRING;
        instance.setName(wrongResult);
        result = instance.getName();
        assertThat(result, not(wrongResult));

    }

    /**
     * Test of getDescription and set Description methods, of class ClockEvent.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        ClockEvent instance = new ClockEvent();
        String expResult = "Test Description";

        instance.setDescription(expResult);
        String result = instance.getDescription();
        assertThat(expResult, is(result));

        String wrongResult = null;
        instance.setDescription(wrongResult);
        result = instance.getDescription();
        assertThat(wrongResult, is(result));

        wrongResult = "";
        instance.setDescription(wrongResult);
        result = instance.getDescription();
        assertThat(wrongResult, is(result));

        wrongResult = LONG_STRING;
        instance.setDescription(wrongResult);
        result = instance.getDescription();
        assertThat(result, not(wrongResult));
    }

    /**
     * Test of getClockEventTransCollection and method
     * setClockEventTransCollection, of class ClockEvent.
     */
    @Test
    public void testGetClockEventTransCollection() {
        System.out.println("getClockEventTransCollection");
        ClockEvent instance = new ClockEvent();
        Collection<ClockEventTrans> expResult = null;
        instance.setClockEventTransCollection(expResult);
        Collection<ClockEventTrans> result = instance.getClockEventTransCollection();
        assertThat(expResult, is(result));

        ClockEventTrans eventtrans = new ClockEventTrans();
        expResult = new ArrayList();
        expResult.add(eventtrans);
        instance.setClockEventTransCollection(expResult);
        result = instance.getClockEventTransCollection();
        assertThat(expResult, is(result));
    }

    /**
     * Test of hashCode method, of class ClockEvent.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        ClockEvent instance = new ClockEvent();

        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);

        Integer pkid = 200;
        instance.setPkid(pkid);
        result = instance.hashCode();
        assertThat(result, is(pkid.hashCode()));
    }

    /**
     * Test of equals method, of class ClockEvent.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        ClockEvent instance = new ClockEvent();
        ClockEvent instance2 = new ClockEvent();       
        
        boolean result = instance.equals(instance2);        
        assertThat(true, is(result));
        
        instance.setPkid(200);
        result = instance.equals(instance2);        
        assertThat(false, is(result));
        
        instance2.setPkid(200);
        result = instance.equals(instance2);        
        assertThat(true, is(result));
    }

    /**
     * Test of toString method, of class ClockEvent.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        ClockEvent instance = new ClockEvent();
        String expResult = "net.xpresstek.zroster.ejb.ClockEvent[ pkid=null ]";
        String result = instance.toString();
        assertEquals(expResult, result);

    }

}
