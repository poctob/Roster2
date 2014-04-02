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

import com.gzlabs.utils.DateUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.ResourceBundle;
import javax.enterprise.context.SessionScoped;
import net.xpresstek.zroster.web.ClockOutReasonsController;
import net.xpresstek.zroster.web.ClockOutReasonsFacade;
import net.xpresstek.zroster.web.ConfigurationController;
import net.xpresstek.zroster.web.ConfigurationFacade;
import net.xpresstek.zroster.web.ControllerFactory;
import net.xpresstek.zroster.web.EmployeeController;
import net.xpresstek.zroster.web.EmployeeFacade;
import net.xpresstek.zroster.web.PositionController;
import net.xpresstek.zroster.web.PositionFacade;
import net.xpresstek.zroster.web.PrivilegeController;
import net.xpresstek.zroster.web.PrivilegeFacade;
import net.xpresstek.zroster.web.TimeOffStatusController;
import net.xpresstek.zroster.web.TimeOffStatusFacade;
import net.xpresstek.zroster.web.util.DataChangeEventListener;
import net.xpresstek.zroster.web.util.DataChangedEvent;

/**
 *
 * @author Alex Pavlunenko <alexp at xpresstek.net>
 */
@SessionScoped
public class ConfigurationDataManager implements Serializable, DataChangeEventListener {

    private static ConfigurationDataManager instance = null;
    private List<Configuration> configuration;
    private List<TimeOffStatus> timeOffStatus;
    private List<Privilege> privilege;
    private List<Position> position;
    private List<Employee> employee;
    private List<ClockOutReasons> clockOutReasons;
    
    private boolean admin;

    private static final String TIMESTART = "ShiftStart";
    private static final String TIMEEND = "ShiftEnd";
    private static final String INTERVAL = "ShiftInterval";

    private static final String BUNDLE = "Bundle";
    private static final String TOS_DEFAULT = "TimeOffStatusDefaultStatus";

    public static ConfigurationDataManager getInstance() {
        if (instance == null) {
            instance = new ConfigurationDataManager();
        }

        return instance;
    }

    private ConfigurationDataManager() {
        configuration = new ArrayList();
        timeOffStatus = new ArrayList();
        privilege = new ArrayList();
        position = new ArrayList();
        clockOutReasons = new ArrayList();
        employee = new ArrayList();
        admin = false;
    }
    
    public void setAdmin()
    {
        admin=true;
    }
    
    public boolean isAdmin()
    {
        return admin;
    }
    
    public void clearData()
    {
        configuration.clear();
        timeOffStatus.clear();
        privilege.clear();
        position.clear();
        clockOutReasons.clear();
        employee.clear();
    }

    public List<Configuration> getConfiguration() {
        return configuration;
    }

    public List<TimeOffStatus> getTimeOffStatus() {
        return timeOffStatus;
    }

    public List<Privilege> getPrivilege() {
        return privilege;
    }

    public List<Position> getPosition() {
        return position;
    }

    public List<Employee> getEmployee() {
        return employee;
    }

    public List<ClockOutReasons> getClockOutReasons() {
        return clockOutReasons;
    }

    public void registerListeners() {
        ConfigurationController configurationController
                = ControllerFactory.getConfigurationController();
        configurationController.addDataChangeListener(this);

        PrivilegeController privilegeController
                = ControllerFactory.getPrivilegeController();
        privilegeController.addDataChangeListener(this);

        TimeOffStatusController timeOffStatusController
                = ControllerFactory.getTimeOffStatusController();
        timeOffStatusController.addDataChangeListener(this);

        PositionController positionController
                = ControllerFactory.getPositionController();
        positionController.addDataChangeListener(this);

        ClockOutReasonsController clockOutReasonsController
                = ControllerFactory.getClockOutReasonsController();
        clockOutReasonsController.addDataChangeListener(this);

        EmployeeController employeeController
                = ControllerFactory.getEmployeeController();
        employeeController.addDataChangeListener(this);
    }

    public void updateAllData() {
        updateConfigurationData();
        updatePrivilegeData();
        updateTimeOffStatusData();
        updatePositionsData();
        updateClockOutReasonsData();
        updateEmployeeData();
    }

    public void updateConfigurationData() {
        ConfigurationController configurationController
                = ControllerFactory.getConfigurationController();
        configuration = configurationController.getAllItems();
    }

    private void updatePrivilegeData() {
        PrivilegeController privilegeController
                = ControllerFactory.getPrivilegeController();
        privilege = privilegeController.getAllItems();
    }

    public void updateTimeOffStatusData() {
        TimeOffStatusController timeOffStatusController
                = ControllerFactory.getTimeOffStatusController();
        timeOffStatus = timeOffStatusController.getAllItems();
    }

    private void updatePositionsData() {
        PositionController positionController
                = ControllerFactory.getPositionController();
        position = positionController.getAllItems();

    }

    private void updateClockOutReasonsData() {
        ClockOutReasonsController clockOutReasonsController
                = ControllerFactory.getClockOutReasonsController();
        clockOutReasons = clockOutReasonsController.getAllItems();
    }

    private void updateEmployeeData() {
        EmployeeController employeeController
                = ControllerFactory.getEmployeeController();
        employee = employeeController.getAllItems();
    }

    public List getTimeSlots() {

        String start = getConfigValue(TIMESTART, false);
        String end = getConfigValue(TIMEEND, false);
        String interval = getConfigValue(INTERVAL, false);

        if (start != null && end != null && interval != null) {
            return getTimeSpan(start, end, interval);
        }
        return null;
    }

    public String getConfigValue(String key, boolean raw) {
        for (Configuration c : configuration) {
            if (c.getConfigID().equals(key)) {
                return raw ? c.getConfigValueRaw() : c.getConfigValue();
            }
        }
        return null;
    }

    /**
     * Generates a list of strings that represent a period between two dates
     * calculated by using specified interval.
     *
     * @param start Start date.
     * @param end End date.
     * @param inter Interval
     * @return List of string with time periods.
     */
    public static ArrayList<Object> getTimeSpan(String start, String end, String inter) {

        ArrayList<Object> retval = new ArrayList<>();
        int start_time = safeParseInt(start);
        int end_time = safeParseInt(end);
        int interval = safeParseInt(inter);

        if (start_time < end_time && interval > 0) {
            Calendar cal = new GregorianCalendar();
            cal.setTime(new Date());
            cal.set(Calendar.HOUR_OF_DAY, start_time);
            cal.set(Calendar.MINUTE, 0);
            retval.add(cal.get(Calendar.HOUR_OF_DAY) + ":00");
            String zminute = "00";
            int hofd = cal.get(Calendar.HOUR_OF_DAY);
            int phofd = hofd;
            while (hofd < end_time) {
                cal.add(Calendar.MINUTE, interval);
                hofd = cal.get(Calendar.HOUR_OF_DAY);
                if (hofd < phofd) {
                    retval.add("23:59");
                    break;
                }

                retval.add(cal.get(Calendar.HOUR_OF_DAY) + ":" + (cal.get(Calendar.MINUTE) == 0 ? zminute : cal.get(Calendar.MINUTE)));
                phofd = hofd;
            }
        }
        return retval;
    }

    /**
     * Safe parsing of an integer from string
     *
     * @param input Input string to parse.
     * @return parsed integer or 0
     */
    private static int safeParseInt(String input) {
        if (input != null) {
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public List getTimeSlotsDate(String date) {
        List time_strings = getTimeSlots();

        ArrayList<Date> retval = new ArrayList();

        if (time_strings != null) {
            for (Object str : time_strings) {
                if (str != null) {
                    String fulldate = date + " " + (String) str + ":00.0";
                    Date dt = DateUtils.StringToDate(fulldate);
                    retval.add(dt);
                }
            }
        }
        return retval;
    }

    public TimeOffStatus getTimeOffStatus(Integer id) {
        for (TimeOffStatus tostatus : timeOffStatus) {
            if (tostatus.getPkid().equals(id)) {
                return tostatus;
            }
        }
        return null;
    }

    /**
     * Retrieves default status, normally it is pending.
     *
     * @return Default status if it is found, null if not.
     */
    public TimeOffStatus getDefaultStatus() {
        ResourceBundle bundle = ResourceBundle.getBundle(BUNDLE);
        String key = bundle.getString(TOS_DEFAULT);
        for (TimeOffStatus tostatus : timeOffStatus) {
            if (tostatus.getName().equals(key)) {
                return tostatus;
            }
        }
        return null;

    }

    public Position getPosition(Integer id) {

        if(position.isEmpty())
        {
            updatePositionsData();
        }
        for (Position p : position) {
            if (p.getPkID().equals(id)) {
                return p;
            }
        }
        return null;
    }

    public Employee getEmployee(Integer id) {

        for (Employee p : employee) {
            if (p.getPkID().equals(id)) {
                return p;
            }
        }
        return null;
    }

    public List<Employee> getAllowedItems(int position, String start, String end) {
        if (position <= 0 || start == null || end == null) {
            return null;
        }

        List<Employee> employees = new ArrayList();
        for (Employee e : employee) {
            if (isEmployeeAllowed(e, position, start, end)) {
                employees.add(e);
            }
        }
        return employees;
    }

    public boolean isEmployeeAllowed(Employee e,
            int position,
            String start,
            String end) {
        return e != null
                && e.getIsActive()
                && e.isPositionAllowed(position)
                && e.isTimeAllowed(start, end);
    }

    @Override
    public void updateData(DataChangedEvent event) {

        Object obj = event.getSource();

        if (obj instanceof ConfigurationFacade) {
            updateConfigurationData();
        } else if (obj instanceof PrivilegeFacade) {
            updatePrivilegeData();
        } else if (obj instanceof PositionFacade) {
            updatePositionsData();
        } else if (obj instanceof EmployeeFacade) {
            updateEmployeeData();
        } else if (obj instanceof TimeOffStatusFacade) {
            updateTimeOffStatusData();
        } else if (obj instanceof ClockOutReasonsFacade) {
            updateClockOutReasonsData();
        }

    }

}
