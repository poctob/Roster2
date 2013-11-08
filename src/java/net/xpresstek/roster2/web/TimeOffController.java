package net.xpresstek.roster2.web;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.xpresstek.roster2.ejb.TimeOff;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import net.xpresstek.roster2.ejb.Employee;
import net.xpresstek.roster2.ejb.TimeOffStatus;


@Named("timeOffController")
@SessionScoped
public class TimeOffController extends ControllerBase {

    private TimeOff current;
    private List<TimeOff> activeTimeOffs;
    @EJB
    private net.xpresstek.roster2.web.TimeOffFacade ejbFacade;

    public TimeOffController() {
    }

     @Override
    AbstractFacade getFacade() {
        return ejbFacade;
    }

    @Override
    Object getCurrent() {
        return current;
    }
    
    public void prepareCreate(Employee empl, TimeOffStatus to)
    {
        prepareCreate();
        if(current!=null)
        {
            current.setEmployeeid(empl);
            current.setTimeOffStatusid(to);
        }
    }
    
    public TimeOff getTimeOff(Integer id) {
        return (TimeOff)getObject(id);
    }
    
    public List<TimeOff> findByEmployeeID(Employee empl)
    {
        return ejbFacade.findByEmployeeID(empl);
    }
    
    public List<TimeOff> getActiveTimeOffs()
    {
        List<TimeOff> all_items=ejbFacade.findAll();
        activeTimeOffs=new ArrayList();
        
        for(TimeOff to : all_items)
        {
            if(to.getEmployeeid().getIsActive())
            {
                activeTimeOffs.add(to);
            }
        }
        Collections.sort(activeTimeOffs, Collections.reverseOrder());
        return activeTimeOffs;
    }
    
    /**
     * Set current item using primary id key.
     * @param id Primary id key of the time off item.
     */
    public void setCurrentById(Integer id)
    {
        setCurrent(getTimeOff(id));
    }

    @Override
    void setCurrent(Object obj) {
        current=(TimeOff)obj;
    }

    @Override
    void createNewCurrent() {
        current=new TimeOff();
    }

    @FacesConverter(forClass = TimeOff.class)
    public static class TimeOffControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TimeOffController controller = (TimeOffController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "timeOffController");
            return controller.getTimeOff(getKey(value));
        }
        
        public static TimeOffController getController() {
            FacesContext fc = FacesContext.getCurrentInstance();
            return (TimeOffController) fc.getApplication().getELResolver().
                    getValue(fc.getELContext(), null, "timeOffController");
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
            if (object instanceof TimeOff) {
                TimeOff o = (TimeOff) object;
                return getStringKey(o.getPkid());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + TimeOff.class.getName());
            }
        }
    }
}
