/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.xpresstek.zroster.ejb;

import com.gzlabs.utils.DateUtils;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alex
 */
public class ShiftColumn {

    List<Shift> shifts;
    Position position;

    public ShiftColumn(List<Shift> shifts, Position position) {
        this.shifts = shifts;
        this.position = position;
    }

    public List<Shift> getShifts() {
        return shifts;
    }

    public void setShifts(List<Shift> shifts) {
        this.shifts = shifts;
    }

    public int getShiftID(String time) {
        for (Shift s : getShiftByTime(time)) {
            if (s != null) {
                return s.getPkid();
            }
        }
        return -1;
    }
    
     public int getShiftIDByTimeandEmployee(String time, int employeeID) {
        for (Shift s : getShiftByTimeAndEmployee(time, employeeID)) {
            if (s != null) {
                return s.getPkid();
            }
        }
        return -1;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getPositionName() {
        if (position != null) {
            return position.getName();
        }
        return null;
    }

    public String getEmployeeName(String time) {
        String retval = "";
        for (Shift s : getShiftByTime(time)) {
            if (s != null) {
                retval += s.getEmployeeObject().getName() + " ";
            }
        }
        return retval;
    }

    public List<Employee> getEmployeeNames(String time) {
        List<Employee> retval = new ArrayList();
        List<Shift> shifts = getShiftByTime(time);
        if (shifts != null) {
            for (Shift s : shifts) {
                if (s != null) {
                    retval.add(s.getEmployeeObject());
                }
            }
        }
        return retval;
    }

    public List<Shift> getShiftByTime(String time) {

        if (time == null || time.length() == 0) {
            return null;
        }
        ArrayList<Shift> retval = new ArrayList();
        if (shifts == null) {
            return null;
        }
        for (Shift s : shifts) {

            if (s != null) {
                String strdate = DateUtils.DateToString(s.getStart());
                String c_strdate = strdate.substring(0, 11);
                String time_slot = time + ":00.0";
                c_strdate += time_slot;
                int employeeid = s.isEmployeeOn(position.getPkID(), c_strdate);
                if (employeeid > 0) {
                    retval.add(s);
                }
            }
        }
        return retval;
    }
    public List<Shift> getShiftByTimeAndEmployee(String time, int employeeID) {

        if (time == null || time.length() == 0 || 
                employeeID<=0) {
            return null;
        }
        ArrayList<Shift> retval = new ArrayList();
        if (shifts == null) {
            return null;
        }
        for (Shift s : shifts) {

            if (s != null) {
                String strdate = DateUtils.DateToString(s.getStart());
                String c_strdate = strdate.substring(0, 11);
                String time_slot = time + ":00.0";
                c_strdate += time_slot;
                int employeeid = s.isEmployeeOn(position.getPkID(), c_strdate);
                if (employeeid == employeeID) {
                    retval.add(s);
                }
            }
        }
        return retval;
    }
}
