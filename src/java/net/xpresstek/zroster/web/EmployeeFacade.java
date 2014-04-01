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

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import net.xpresstek.zroster.ejb.Employee;

/**
 *
 * @author apavlune
 */
@Stateless
public class EmployeeFacade extends AbstractFacade<Employee> {

    public EmployeeFacade() {
        super(Employee.class);
    }

    public List<Employee> findActive() {
        TypedQuery<Employee> query = getEntityManager().
                createNamedQuery("Employee.findByIsActive", Employee.class);
        query.setParameter("isActive", true);
        return query.getResultList();
    }
    
     public Employee findByName(String name) {
        TypedQuery<Employee> query = getEntityManager().
                createNamedQuery("Employee.findByName", Employee.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }

    public List<Employee> findByPrivilege(String privilege) {
         List<Employee> active=findActive();
         List<Employee> retval = new ArrayList();
         for(Employee employee : active)
         {
             if(employee.hasPrivilege(privilege))
             {
                 retval.add(employee);
             }
         }
         
         return retval;
    }
}
