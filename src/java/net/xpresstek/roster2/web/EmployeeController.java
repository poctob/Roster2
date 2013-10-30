package net.xpresstek.roster2.web;

import java.util.ArrayList;
import java.util.List;
import net.xpresstek.roster2.ejb.Employee;



import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("employeeController")
@SessionScoped
public class EmployeeController extends ControllerBase {

    private Employee current;
    @EJB
    private net.xpresstek.roster2.web.EmployeeFacade ejbFacade;

    public EmployeeController() {
    }

    @Override
    AbstractFacade getFacade() {
        return ejbFacade;
    }

    @Override
    Object getCurrent() {
        return current;
    }

    public Employee getEmployee(Integer id) {
        return (Employee) getObject(id);
    }
    
    public Employee getEmployeeByName(String name)
    {
        if(name==null)
        {
            return null;
        }
        List<Employee> pos=getAllItems();
        for(Employee p : pos)
        {
            if(p.getName().equals(name))
            {
                return p;
            }
        }
        return null;
    }

    @Override
    void setCurrent(Object obj) {
        current = (Employee) obj;
    }

    @Override
    void createNewCurrent() {
        current = new Employee();
    }

    public List<Employee> getAllItems() {
        return ejbFacade.findAll();
    }
    
    public List<Employee> getActiveEmployees()
    {
        return ejbFacade.findActive();
    }
    
    public List<Employee> getAllowedItems
            (int position, String start, String end)
    {
        if(position<=0 || start==null || end==null)
        {
            return null;
        } 
        
        List<Employee> employees=new ArrayList();
        for(Employee e : ejbFacade.findAll())
        {
            if(e!=null && 
                    e.getIsActive() &&
                    e.isPositionAllowed(position) &&
                    e.isTimeAllowed(start, end))
            {
                employees.add(e);
            }
        }
        return employees;
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
        
         public static EmployeeController getController()
        {
            FacesContext fc=FacesContext.getCurrentInstance();
            return (EmployeeController) fc.getApplication().getELResolver().
                    getValue(fc.getELContext(), null, "employeeController");
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
