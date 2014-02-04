/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.xpresstek.zroster.web;

import java.io.Serializable;
import java.util.Date;
import net.xpresstek.zroster.ejb.Employee;
import net.xpresstek.zroster.ejb.Position;
import net.xpresstek.zroster.ejb.Shift;
/**
 *
 * @author apavlune
 */
public class ShiftHelper implements Serializable{


    private Employee employee;    
    private Position position;
    private Date start;
    private Date end;

    public ShiftHelper() {
    }

    public ShiftHelper(Employee employee, Position position, Date start, Date end) {
        this.employee = employee;
        this.position = position;
        this.start = start;
        this.end = end;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    
   
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
    

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
    
    public void create()
    {
        Shift s=new Shift(0, employee.getPkID(), position.getPkID(), start, end);
        String t=s.toString();
    }
    
}
