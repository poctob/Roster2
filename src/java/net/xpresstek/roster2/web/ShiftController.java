package net.xpresstek.roster2.web;

import net.xpresstek.roster2.ejb.Shift;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import net.xpresstek.roster2.ejb.Position;
import net.xpresstek.roster2.web.PositionController.PositionControllerConverter;

@Named("shiftController")
@SessionScoped
public class ShiftController extends ControllerBase {

    private Shift current;
    @EJB
    private net.xpresstek.roster2.web.ShiftFacade ejbFacade;


    public ShiftController() {
    }

     @Override
    AbstractFacade getFacade() {
        return ejbFacade;
    }

    @Override
    Object getCurrent() {
        return current;
    }
    
    public Shift getShift(Integer id) {
        return (Shift)getObject(id);
    }
    

    @Override
    void setCurrent(Object obj) {
        current=(Shift)obj;
    }

    @Override
    void createNewCurrent() {
        current=new Shift();
    }
    
    public List<String> getColHeading()
    {
        Set<String> headings=new HashSet();               
        for(Shift s : ejbFacade.findAll())
        {
            Position pos=PositionControllerConverter.getAsObject(s.getPositionID());
            if(pos!=null)
            {
                headings.add(pos.getName());
            }
        }
        headings.add("Time");
        return new ArrayList(headings);
    }

    @FacesConverter(forClass = Shift.class)
    public static class ShiftControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ShiftController controller = (ShiftController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "shiftController");
            return controller.getShift(getKey(value));
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
            if (object instanceof Shift) {
                Shift o = (Shift) object;
                return getStringKey(o.getPkid());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Shift.class.getName());
            }
        }
    }
}
