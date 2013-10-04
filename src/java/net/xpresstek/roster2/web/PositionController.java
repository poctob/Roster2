package net.xpresstek.roster2.web;

import java.util.List;
import net.xpresstek.roster2.ejb.Position;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("positionController")
@SessionScoped
public class PositionController extends ControllerBase {

    private Position current;
    @EJB
    private net.xpresstek.roster2.web.PositionFacade ejbFacade;

    public PositionController() {
    }

    @Override
    AbstractFacade getFacade() {
        return ejbFacade;
    }

    @Override
    Object getCurrent() {
        return current;
    }

    public Position getPosition(Integer id) {
        return (Position) getObject(id);
    }

    @Override
    void setCurrent(Object obj) {
        current = (Position) obj;
    }

    @Override
    void createNewCurrent() {
        current = new Position();
    }
    
    public List<Position> getAllItems()
    {
        return ejbFacade.findAll();
    }

    @FacesConverter(forClass = Position.class, value = "positionControllerConverter")
    public static class PositionControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            PositionController controller = (PositionController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "positionController");
            return controller.getPosition(getKey(value));
        }

        public static Position getAsObject(int key) {    
            FacesContext fc=FacesContext.getCurrentInstance();
            PositionController controller = (PositionController) fc.getApplication().getELResolver().
                    getValue(fc.getELContext(), null, "positionController");
            return controller.getPosition(key);
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
            if (object instanceof Position) {
                Position o = (Position) object;
                return getStringKey(o.getPkID());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Position.class.getName());
            }
        }
    }
}

   