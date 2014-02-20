/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
