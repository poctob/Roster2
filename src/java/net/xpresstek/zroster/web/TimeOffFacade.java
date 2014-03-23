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

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import net.xpresstek.zroster.ejb.Employee;
import net.xpresstek.zroster.ejb.TimeOff;
import net.xpresstek.zroster.ejb.TimeOffStatus;

/**
 *
 * @author apavlune
 */
@Stateless
public class TimeOffFacade extends AbstractFacade<TimeOff> {
    public TimeOffFacade() {
        super(TimeOff.class);
    }
    
     public List<TimeOff> findByEmployeeID(Employee empl) {
        TypedQuery<TimeOff> query = getEntityManager().
                createNamedQuery("TimeOff.findByEmployeeID", TimeOff.class);
        query.setParameter("employee_id", empl);
        return query.getResultList();
    }
     
     public List<TimeOff> findByStatus(TimeOffStatus status) {
        TypedQuery<TimeOff> query = getEntityManager().
                createNamedQuery("TimeOff.findByStatus", TimeOff.class);
        query.setParameter("timeOffStatusid", status);
        query.setParameter("start", new Date());
        return query.getResultList();
    }
     
      public List<TimeOff> findBeforeNow() {
        TypedQuery<TimeOff> query = getEntityManager().
                createNamedQuery("TimeOff.findBeforeNow", TimeOff.class);
        query.setParameter("start", new Date());
        return query.getResultList();
    }
      
       public List<TimeOff> findAfterAndNow() {
        TypedQuery<TimeOff> query = getEntityManager().
                createNamedQuery("TimeOff.findAfterAndNow", TimeOff.class);
        query.setParameter("start", new Date());
        return query.getResultList();
    }
    
}
