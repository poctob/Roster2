package net.xpresstek.zroster.web;

import java.util.List;
import java.util.ResourceBundle;
import net.xpresstek.zroster.ejb.TimeOffStatus;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.primefaces.event.RowEditEvent;

@Named("timeOffStatusController")
@SessionScoped
public class TimeOffStatusController extends ControllerBase {

    private TimeOffStatus current;
    @EJB
    private net.xpresstek.zroster.web.TimeOffStatusFacade ejbFacade;

    public TimeOffStatusController() {
    }

    @Override
    AbstractFacade getFacade() {
        return ejbFacade;
    }

    @Override
    Object getCurrent() {
        return current;
    }

    public TimeOffStatus getTimeOffStatus(Integer id) {
        return (TimeOffStatus) getObject(id);
    }

    public TimeOffStatus getDefaultStatus() {
        ResourceBundle bundle = ResourceBundle.getBundle("Bundle");
        List<TimeOffStatus> tos = ejbFacade.findByName(bundle.getString("TimeOffStatusDefaultStatus"));

        if (tos.size() > 0) {
            return tos.get(0);
        } else {
            return null;
        }

    }

    public void prepareEdit(int id) {
        setCurrent(getTimeOffStatus(id));
        selectedItemIndex = id;
    }

    @Override
    void setCurrent(Object obj) {
        current = (TimeOffStatus) obj;
    }

    @Override
    void createNewCurrent() {
        current = new TimeOffStatus();
    }

    @FacesConverter(forClass = TimeOffStatus.class)
    public static class TimeOffStatusControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TimeOffStatusController controller = (TimeOffStatusController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "timeOffStatusController");
            return controller.getTimeOffStatus(getKey(value));
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
            if (object instanceof TimeOffStatus) {
                TimeOffStatus o = (TimeOffStatus) object;
                return getStringKey(o.getPkid());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + TimeOffStatus.class.getName());
            }
        }
    }
}
