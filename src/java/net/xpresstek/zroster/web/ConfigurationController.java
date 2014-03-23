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

import com.gzlabs.utils.DateUtils;
import net.xpresstek.zroster.ejb.Configuration;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@Named("configurationController")
@SessionScoped
public class ConfigurationController extends ControllerBase {

    private static final String TIMESTART="ShiftStart";
    private static final String TIMEEND="ShiftEnd";
    private static final String INTERVAL="ShiftInterval";
    
    private Configuration current;
    @EJB
    private ConfigurationFacade ejbFacade;

    public ConfigurationController() {
    }
    
    public List getTimeSlots()
    {        
        Configuration conf=ejbFacade.find(TIMESTART);
        if(conf==null)
        {
            return null;
        }
        String start=conf.getConfigValue();
        conf=ejbFacade.find(TIMEEND);
        if(conf==null)
        {
            return null;
        }
        String end=conf.getConfigValue();
        conf=ejbFacade.find(INTERVAL);
        if(conf==null)
        {
            return null;
        }
        String interval=conf.getConfigValue();
        
        return DateUtils.getTimeSpan(start, end, interval);
    }
    
    public List getTimeSlotsDate (String date)
    {
        List time_strings=getTimeSlots();
        ArrayList<Date> retval=new ArrayList();
        for(Object str : time_strings)
        {
            if(str!=null)
            {
                String fulldate=date+" "+(String)str+":00.0";
                Date dt=DateUtils.StringToDate(fulldate);
                retval.add(dt);
            }
        }
        return retval;
    }

    public Configuration getConfiguration(java.lang.String id) {
        return (Configuration)getObject(id);
    }

    @Override
    Object getCurrent() {
       return current;
    }

    @Override
    void setCurrent(Object obj) {
         current=(Configuration)obj;
    }

    @Override
    void createNewCurrent() {
        current=new Configuration();
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
