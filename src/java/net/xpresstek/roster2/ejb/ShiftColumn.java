/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.xpresstek.roster2.ejb;

import com.gzlabs.utils.DateUtils;
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
    
    public int getShiftID(String time)
    {
        Shift s=getShiftByTime(time);
        if(s!=null)
        {
            return s.getPkid();
        }
        return -1;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
    
    public String getPositionName()
    {
        if(position!=null)
        {
            return position.getName();
        }
        return null;
    }
    
    public String getEmployeeName(String time)
    {
       Shift s=getShiftByTime(time);
       if(s!=null)
       {
           return s.getEmployeeObject().getName();
       }
       return null;
    }
    
    public Shift getShiftByTime(String time)
    {
         if(shifts==null)
        {
            return null;
        }
        for(Shift s : shifts)
        {
            String strdate = DateUtils.DateToString(s.getStart());
            String c_strdate = strdate.substring(0, 11);
            String time_slot = time + ":00.0";
            c_strdate += time_slot;
            int employeeid = s.isEmployeeOn(position.getPkID(), c_strdate);
            if (employeeid > 0) {
                return s;
            }            
        }
        return null;
    }
    
    public int getShiftIdByTimeAsString(String time)
    {
       Shift s=getShiftByTime(time);
       if(s!=null)
       {
           return s.getPkid(); 
       }
       return 0;
    }
    
}
