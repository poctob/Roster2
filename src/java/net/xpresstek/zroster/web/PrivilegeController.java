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

import javax.ejb.EJB;
import net.xpresstek.zroster.ejb.Privilege;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@Named("privilegeController")
@SessionScoped
public class PrivilegeController extends ControllerBase {
    @EJB 
    protected PrivilegeFacade ejbFacade;
    protected Privilege current;
    
    public PrivilegeController() {
    }

    @Override
    AbstractFacade getFacade() {
        return ejbFacade;
    }

    @Override
    Object getCurrent() {
        return current;
    }
    
    public Privilege getPrivilege(Integer id) {
        return (Privilege)getObject(id);
    }
    

    @Override
    void setCurrent(Object obj) {
        current=(Privilege)obj;
    }

    @Override
    void createNewCurrent() {
        current=new Privilege();
    }

    @FacesConverter(forClass = Privilege.class, value = "privilegeControllerConverter")
    public static class PrivilegeControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            PrivilegeController controller = (PrivilegeController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "privilegeController");
            return controller.getPrivilege(getKey(value));
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
            if (object instanceof Privilege) {
                Privilege o = (Privilege) object;
                return getStringKey(o.getPkid());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Privilege.class.getName());
            }
        }
    }
}
