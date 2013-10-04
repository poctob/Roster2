package net.xpresstek.roster2.web;

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
