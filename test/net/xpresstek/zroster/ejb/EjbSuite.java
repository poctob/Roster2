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

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author apavlune
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({net.xpresstek.zroster.ejb.PrivilegeTest.class, net.xpresstek.zroster.ejb.ClockEventTest.class, net.xpresstek.zroster.ejb.ClockEventTransTest.class, net.xpresstek.zroster.ejb.TimeOffStatusTest.class, net.xpresstek.zroster.ejb.S3cr3tPKTest.class, net.xpresstek.zroster.ejb.WeeklyHoursTest.class, net.xpresstek.zroster.ejb.ShiftTest.class, net.xpresstek.zroster.ejb.ClockOutReasonsTest.class, net.xpresstek.zroster.ejb.LogInBeanTest.class, net.xpresstek.zroster.ejb.ConfigurationTest.class, net.xpresstek.zroster.ejb.ViewShiftsTest.class, net.xpresstek.zroster.ejb.EmployeeHoursTest.class, net.xpresstek.zroster.ejb.TimeOffTest.class, net.xpresstek.zroster.ejb.PositionTest.class, net.xpresstek.zroster.ejb.S3cr3tTest.class, net.xpresstek.zroster.ejb.EmployeeTest.class, net.xpresstek.zroster.ejb.NavigationBeanTest.class, net.xpresstek.zroster.ejb.ShiftColumnTest.class})
public class EjbSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
