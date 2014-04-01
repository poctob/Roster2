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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.xpresstek.zroster.ejb.TimeOff;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import net.xpresstek.zroster.ejb.ConfigurationDataManager;
import net.xpresstek.zroster.ejb.Employee;
import net.xpresstek.zroster.ejb.TimeOffStatus;
import net.xpresstek.zroster.web.util.MailUtil;

@Named("timeOffController")
@SessionScoped
public class TimeOffController extends ControllerBase {

    private TimeOff current;
    private List<TimeOff> activeTimeOffs;
    private List<TimeOff> filteredTimeOffs;
    private String current_filter;
    private List<String> filterOptions;
    @EJB
    private net.xpresstek.zroster.web.TimeOffFacade ejbFacade;

    public TimeOffController() {
        createFilterOptions();
        
    }

    public String getCurrent_filter() {
        return current_filter;
    }

    public void setCurrent_filter(String current_filter) {
        this.current_filter = current_filter;
    }

    private void createFilterOptions() {
        filterOptions = new ArrayList();
        filterOptions.add("Current + Future");
        filterOptions.add("Previous");
        filterOptions.add("All");
        current_filter=filterOptions.get(0);
    }

    public List<String> getFilterOptions() {
        return filterOptions;
    }

    public void setFilterOptions(List<String> filterOptions) {
        this.filterOptions = filterOptions;
    }

    public String getDefaultFilter() {
        return "Current + Future";
    }

    @Override
    AbstractFacade getFacade() {
        return ejbFacade;
    }

    @Override
    Object getCurrent() {
        return current;
    }

    public List<TimeOff> getFilteredTimeOffs() {
        switch (current_filter) {
            case "Current + Future": 
                filteredTimeOffs=ejbFacade.findAfterAndNow();
                break;
            case "Previous": 
                filteredTimeOffs=ejbFacade.findBeforeNow();
                break;
            case "All": filteredTimeOffs=ejbFacade.findAll();
        }
        return filteredTimeOffs;
    }

    public void setFilteredTimeOffs(List<TimeOff> filteredTimeOffs) {
        this.filteredTimeOffs = filteredTimeOffs;
    }

    public void prepareCreate(Employee empl, TimeOffStatus to) {
        super.prepareCreate();
        if (current != null) {
            current.setEmployeeid(empl);
            current.setTimeOffStatusid(to);
           
        }
    }
    
    @Override
    public void create()
    {
        super.create();
        ConfigurationDataManager cdm = ConfigurationDataManager.getInstance();
         if(current.getTimeOffStatusid().equals(cdm.getDefaultStatus()))
            {
                MailUtil.sendNewTimeOffRequestEmail(
                        current.getEmployeeid().getName(),
                        current.getStart(), 
                        current.getEnd());
            }                
    }
 
    
    public void createOrUpdate()
    {
        if(current.getPkid()!=null)
        {
            super.update();
        }
        else
        {
            super.create();
        }
    }
    public void prepareEdit(int id)
    {
        setCurrent(getTimeOff(id));
        selectedItemIndex=id;
    }

    public TimeOff getTimeOff(Integer id) {
        return (TimeOff) getObject(id);
    }

    public List<TimeOff> findByEmployeeID(Employee empl) {
         List<TimeOff> all_items = ejbFacade.findByEmployeeID(empl);
         Collections.sort(all_items, Collections.reverseOrder());
         return all_items;
    }

    public List<TimeOff> getActiveTimeOffs() {
        List<TimeOff> all_items = ejbFacade.findAll();
        activeTimeOffs = new ArrayList();

        for (TimeOff to : all_items) {
            if (to.getEmployeeid().getIsActive()) {
                activeTimeOffs.add(to);
            }
        }
        Collections.sort(activeTimeOffs, Collections.reverseOrder());
        return activeTimeOffs;
    }
    
    /**
     * Checks if there are pending time off requests.  Displays a message if 
     * some are found.
     */
    public void checkForPendingRequests()
    {
        TimeOffStatus pending = 
               ConfigurationDataManager.getInstance().getDefaultStatus();
        
        if(pending != null)
        {
            if(ejbFacade.findByStatus(pending).size() > 0)
            {
        
                FacesContext.getCurrentInstance().
                        addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                                "Time Off Requests Pending", 
                                "You have pending time off requests!")); 
            }
        }
    }

    /**
     * Set current item using primary id key.
     *
     * @param id Primary id key of the time off item.
     */
    public void setCurrentById(Integer id) {
        setCurrent(getTimeOff(id));
    }

    @Override
    void setCurrent(Object obj) {
        current = (TimeOff) obj;
    }

    @Override
    void createNewCurrent() {
        current = new TimeOff();
    }

    @Override
    public List findAll() {
        return ejbFacade.findAll();
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
