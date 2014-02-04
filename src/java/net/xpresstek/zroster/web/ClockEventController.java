package net.xpresstek.zroster.web;

import net.xpresstek.zroster.ejb.ClockEvent;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("clockEventController")
@SessionScoped
public class ClockEventController extends ControllerBase {

    private ClockEvent current;
    @EJB
    private net.xpresstek.zroster.web.ClockEventFacade ejbFacade;

    public ClockEventController() {
    }

    @Override
    AbstractFacade getFacade() {
        return ejbFacade;
    }

    @Override
    Object getCurrent() {
        return current;
    }

    @Override
    void setCurrent(Object obj) {
        current = (ClockEvent) obj;
    }

    @Override
    void createNewCurrent() {
        current = new ClockEvent();
    }
    
    /**
     * Retrieves clock out event
     * @return Clock out event.
     */
    public ClockEvent getClockOutId()
    {
        return ejbFacade.getClockOutEvent();
    }
    
     /**
     * Retrieves clock in event
     * @return Clock in event.
     */
    public ClockEvent getClockInId()
    {
        return ejbFacade.getClockInEvent();
    }


    public ClockEvent getClockEvent(Integer id) {
        return (ClockEvent) getObject(id);
    }

    @FacesConverter(forClass = ClockEvent.class)
    public static class ClockEventControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ClockEventController controller = (ClockEventController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "clockEventController");
            return controller.getClockEvent(getKey(value));
        }
        
        public static ClockEventController getController()
        {
            FacesContext fc = FacesContext.getCurrentInstance();
            return (ClockEventController) fc.getApplication().getELResolver().
                    getValue(fc.getELContext(), null, "clockEventController");
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
            if (object instanceof ClockEvent) {
                ClockEvent o = (ClockEvent) object;
                return getStringKey(o.getPkid());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + ClockEvent.class.getName());
            }
        }
    }
}
