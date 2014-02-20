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
