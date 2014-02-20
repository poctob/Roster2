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

import java.util.List;
import net.xpresstek.zroster.ejb.Position;

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
    private net.xpresstek.zroster.web.PositionFacade ejbFacade;

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
    
    public Position getPositionByName(String name)
    {
        if(name==null)
        {
            return null;
        }
        List<Position> pos=getAllItems();
        for(Position p : pos)
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
        
        public static PositionController getController()
        {
            FacesContext fc=FacesContext.getCurrentInstance();
            return (PositionController) fc.getApplication().getELResolver().
                    getValue(fc.getELContext(), null, "positionController");
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

   