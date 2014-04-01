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

import net.xpresstek.zroster.ejb.Configuration;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import net.xpresstek.zroster.ejb.ConfigurationDataManager;
import net.xpresstek.zroster.web.util.DataChangeEventListener;

@Named("configurationController")
@SessionScoped
public class ConfigurationController extends ControllerBase {

    private Configuration current;
    @EJB
    private ConfigurationFacade ejbFacade;

    public ConfigurationController() {    
        
    }

    /**
     * Fetches all configuration items.
     *
     * @return
     */
    public List<Configuration> getAllItems() {
        if (ejbFacade != null) {
            return ejbFacade.findAll();
        }
        return null;
    }
    
    public void addDataChangeListener(DataChangeEventListener l)
    {
        ejbFacade.addListener(l);
    }
    
    @Override
    public List findAll() {
        return ConfigurationDataManager.getInstance().getConfiguration();
    }
   

    private Configuration getConfiguration(java.lang.String id) {
        return (Configuration) getObject(id);
    }

    @Override
    Object getCurrent() {
        return current;
    }

    @Override
    void setCurrent(Object obj) {
        current = (Configuration) obj;
    }

    @Override
    void createNewCurrent() {
        current = new Configuration();
    }

    @Override
    AbstractFacade getFacade() {
        return ejbFacade;
    }
  

    @FacesConverter(forClass = Configuration.class)
    public static class ConfigurationControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ConfigurationController controller = (ConfigurationController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "configurationController");
            return controller.getConfiguration(getKey(value));
        }

        java.lang.String getKey(String value) {
            java.lang.String key;
            key = value;
            return key;
        }

        String getStringKey(java.lang.String value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Configuration) {
                Configuration o = (Configuration) object;
                return getStringKey(o.getConfigID());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Configuration.class.getName());
            }
        }
    }
}
