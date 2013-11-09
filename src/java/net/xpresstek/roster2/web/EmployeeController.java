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
import javax.faces.model.SelectItem;
import net.xpresstek.roster2.ejb.S3cr3t;
import net.xpresstek.roster2.ejb.S3cr3tPK;
import net.xpresstek.roster2.ejb.TimeOff;
import net.xpresstek.roster2.web.S3cr3tController.S3cr3tControllerConverter;
import net.xpresstek.roster2.web.TimeOffController.TimeOffControllerConverter;

@Named("employeeController")
@SessionScoped
public class EmployeeController extends ControllerBase {

    private Employee current;
    private String password;
    private List<Employee> filteredEmployees;
    
    /**
     * Filtering options
     */
    private SelectItem[] activeOptions;
    @EJB
    private net.xpresstek.roster2.web.EmployeeFacade ejbFacade;

    public EmployeeController() {
        createFilterOptions();
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

    private void createFilterOptions()
    {
        activeOptions=new SelectItem[3];
        activeOptions[0]=new SelectItem("true", "Active");
        activeOptions[1]=new SelectItem("false", "Inactive");
        activeOptions[2]=new SelectItem("", "All");
    }
    
    public String getDefaultFilter()
    {
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
            S3cr3tController sc = S3cr3tControllerConverter.getController();
            sc.prepareCreate();
            S3cr3tPK pk = new S3cr3tPK(current.getPkID(), password, null);
            ((S3cr3t) sc.getCurrent()).setEmployee(current);
            ((S3cr3t) sc.getCurrent()).setS3cr3tPK(pk);
            sc.update();
        }
        password="";
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
    
    public void refresh()
    {
        ejbFacade.refresh(current);
    }

    public Employee getEmployee(Integer id) {
        return (Employee) getObject(id);
    }

    public Employee getEmployeeByName(String name) {
        if (name == null) {
            return null;
        }
        List<Employee> pos = getAllItems();
        for (Employee p : pos) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        return null;
    }
    
    public void prepareEdit(int id)
    {
        setCurrent(getEmployee(id));
        selectedItemIndex=id;
    }

    @Override
    public void setCurrent(Object obj) {
        current = (Employee) obj;
    }

    @Override
    void createNewCurrent() {
        current = new Employee();
    }
    
    public void updateTimeOff()
    {
        TimeOffController toc=TimeOffControllerConverter.getController();
        List<TimeOff> tos=toc.findByEmployeeID(current);
        current.setTimeOffCollection(tos);
    }
    public List<Employee> getAllItems() {
        return ejbFacade.findAll();
    }

    public List<Employee> getActiveEmployees() {
        return ejbFacade.findActive();
    }

    public List<Employee> getAllowedItems(int position, String start, String end) {
        if (position <= 0 || start == null || end == null) {
            return null;
        }

        List<Employee> employees = new ArrayList();
        for (Employee e : ejbFacade.findAll()) {
            if (isEmployeeAllowed(e, position, start, end)) {
                employees.add(e);
            }
        }
        return employees;
    }

    public static boolean isEmployeeAllowed(Employee e,
            int position,
            String start,
            String end) {
        if (e != null
                && e.getIsActive()
                && e.isPositionAllowed(position)
                && e.isTimeAllowed(start, end)) {
            return true;
        }
        return false;
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

        public static EmployeeController getController() {
            FacesContext fc = FacesContext.getCurrentInstance();
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
