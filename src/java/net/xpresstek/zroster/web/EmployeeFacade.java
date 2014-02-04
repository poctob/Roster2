/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.xpresstek.zroster.web;

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
}
