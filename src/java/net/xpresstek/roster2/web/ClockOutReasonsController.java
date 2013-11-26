package net.xpresstek.roster2.web;

import net.xpresstek.roster2.ejb.ClockOutReasons;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("clockOutReasonsController")
@SessionScoped
public class ClockOutReasonsController extends ControllerBase {

    private ClockOutReasons current;
    @EJB
    private net.xpresstek.roster2.web.ClockOutReasonsFacade ejbFacade;


    public ClockOutReasonsController() {
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
        current = (ClockOutReasons) obj;
    }

    @Override
    void createNewCurrent() {
        current = new ClockOutReasons();
    }
    
       public ClockOutReasons getClockOutReasons(Integer id) {
        return (ClockOutReasons) getObject(id);
    }

    @FacesConverter(forClass = ClockOutReasons.class)
    public static class ClockOutReasonsControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ClockOutReasonsController controller = (ClockOutReasonsController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "clockOutReasonsController");
            return controller.getClockOutReasons(getKey(value));
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
            if (object instanceof ClockOutReasons) {
                ClockOutReasons o = (ClockOutReasons) object;
                return getStringKey(o.getPkid());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + ClockOutReasons.class.getName());
            }
        }
    }
}
