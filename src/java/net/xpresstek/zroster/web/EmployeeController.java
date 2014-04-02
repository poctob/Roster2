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
import net.xpresstek.zroster.ejb.Employee;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.SelectItem;
import net.xpresstek.zroster.ejb.ClockEventDataManager;
import net.xpresstek.zroster.ejb.ConfigurationDataManager;
import net.xpresstek.zroster.ejb.EmployeeHours;
import net.xpresstek.zroster.ejb.S3cr3t;
import net.xpresstek.zroster.ejb.S3cr3tPK;
import net.xpresstek.zroster.ejb.TimeOff;

@Named("employeeController")
@SessionScoped
public class EmployeeController extends ControllerBase {

    private Employee current;
    private String password;
    private List<Employee> filteredEmployees;
    private EmployeeHours employeeHours;
    private final ClockEventDataManager eventDM;

    /**
     * Filtering options
     */
    private SelectItem[] activeOptions;
    @EJB
    private net.xpresstek.zroster.web.EmployeeFacade ejbFacade;

    public EmployeeController() {
        createFilterOptions();
        eventDM = ClockEventDataManager.getInstance();
    }

    public List<Employee> getFilteredEmployees() {
        return filteredEmployees;
    }

    public void setFilteredEmployees(List<Employee> filteredEmployees) {
        this.filteredEmployees = filteredEmployees;
    }

    public SelectItem[] getActiveOptions() {
        return activeOptions;
    }

    public void setActiveOptions(SelectItem[] activeOptions) {
        this.activeOptions = activeOptions;
    }

    private void createFilterOptions() {
        activeOptions = new SelectItem[3];
        activeOptions[0] = new SelectItem("true", "Active");
        activeOptions[1] = new SelectItem("false", "Inactive");
        activeOptions[2] = new SelectItem("", "All");
    }

    public String getDefaultFilter() {
        return "true";
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void create() {
        super.create();
        updatePassword();
    }

    private void updatePassword() {
        if (password != null && password.length() > 0) {
            S3cr3tController sc = ControllerFactory.getS3cr3tController();
            sc.prepareCreate();
            S3cr3tPK pk = new S3cr3tPK(current.getPkID(), password, null);
            ((S3cr3t) sc.getCurrent()).setEmployee(current);
            ((S3cr3t) sc.getCurrent()).setS3cr3tPK(pk);
            sc.update();
        }
        password = "";
    }

    @Override
    public void update() {
        super.update();
        super.recreateModel();
        updatePassword();
    }

    @Override
    AbstractFacade getFacade() {
        return ejbFacade;
    }

    @Override
    Object getCurrent() {
        return current;
    }

    public Employee getCurrentEmployee() {
        return current;
    }

    public void refresh() {
        ejbFacade.refresh(current);
    }

    private Employee getEmployee(Integer id) {
        return (Employee) getObject(id);
    }

    public Employee getEmployeeByName(String name) {
        if (name == null) {
            return null;
        }       
        return ejbFacade.findByName(name);
    }

    public void prepareEdit(int id) {
        setCurrent(getEmployee(id));
        selectedItemIndex = id;
    }

    @Override
    public void setCurrent(Object obj) {
        current = (Employee) obj;
    }

    @Override
    void createNewCurrent() {
        current = new Employee();
    }

    public void updateTimeOff() {
        TimeOffController toc = ControllerFactory.getTimeOffController();
        List<TimeOff> tos = toc.findByEmployeeID(current);
        current.setTimeOffCollection(tos);
    }

    public List<Employee> getAllItems() {
        return ejbFacade.findAll();
    }

    public List<Employee> getActiveEmployees() {
        List<Employee> allitems = findAll();
        List<Employee> retval = new ArrayList();
        for(Employee e : allitems)
        {
            if(e.getIsActive())
            {
                retval.add(e);
            }
        }
        return retval;
    }
    
    public List<Employee> getActiveEmployeesDirect() {        
        return ejbFacade.findActive();
    }
    
    public List<Employee> getTimeApprovers()
    {
        return ejbFacade.findByPrivilege("TIME APPROVAL");
    }    

    public EmployeeHours getEmployeeHours() {
             
        return eventDM.getEmployeeHours(current);
    }

    public void setEmployeeHours(EmployeeHours employeeHours) {
        this.employeeHours = employeeHours;
    }

    @Override
    public List findAll() {
        return ConfigurationDataManager.getInstance().getEmployee();
    }
 

    @FacesConverter(forClass = Employee.class, value = "employeeControllerConverter")
    public static class EmployeeControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EmployeeController controller = (EmployeeController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "employeeController");
            return controller.getEmployee(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Employee) {
                Employee o = (Employee) object;
                return getStringKey(o.getPkID());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Employee.class.getName());
            }
        }
    }
}
