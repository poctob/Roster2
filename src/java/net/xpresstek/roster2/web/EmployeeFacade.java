/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.xpresstek.roster2.web;

import javax.ejb.Stateless;
import net.xpresstek.roster2.ejb.Employee;

/**
 *
 * @author apavlune
 */
@Stateless
public class EmployeeFacade extends AbstractFacade<Employee> {
   
    public EmployeeFacade() {
        super(Employee.class);
    }
    
}
