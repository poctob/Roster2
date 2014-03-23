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
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import net.xpresstek.zroster.ejb.WeeklyHours;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import net.xpresstek.zroster.web.util.TimeUtils;

@Named("weeklyHoursController")
@SessionScoped
public class WeeklyHoursController extends ControllerBase {

    private WeeklyHours current;
    @EJB
    private net.xpresstek.zroster.web.WeeklyHoursFacade ejbFacade;

    public WeeklyHoursController() {
    }

    @Override
    public DataModel getItems() {
        if (ejbFacade != null) {
            ejbFacade.refreshData();
        }
        recreateModel();
        return super.getItems();
    }

    @Override
    AbstractFacade getFacade() {
        return ejbFacade;
    }
    
    public WeeklyHoursFacade getWeeklyHoursFacade()
    {
        return ejbFacade;
    }

    @Override
    Object getCurrent() {
        return current;
    }

    @Override
    void setCurrent(Object obj) {
        current = (WeeklyHours) obj;
    }

    @Override
    void createNewCurrent() {
        current = new WeeklyHours();
    }

    public WeeklyHours getWeeklyHours(String id) {
        return (WeeklyHours) getObject(id);
    }

    public List<WeeklyHours> getWeeklyHoursByEmployee(String name) {
        return ejbFacade.findByEmployee(name);
    }

    public List<WeeklyHours> getWeeklyHoursByDate(Date date) {
        Calendar cdate = new GregorianCalendar();
        cdate.setTime(date);

        //Hack to get week start on monday
        if (cdate.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            cdate.add(Calendar.DAY_OF_MONTH, -1);
        }

        Calendar start = DateUtils.getWeekStart(false, cdate);
        Calendar end = new GregorianCalendar();
        end.setTime(start.getTime());
        end.add(Calendar.DAY_OF_MONTH, 6);

        if (ejbFacade != null) {
            ejbFacade.refreshData();
        }
        recreateModel();

        return ejbFacade.findTotalForPeriod(start.getTime(),
                TimeUtils.getDayEnd(end.getTime()));
    }
       

    /**
     * Returns total worked hours for a specified date.
     *
     * @param date Date to check.
     * @return List of the total worked hours for a specified date.
     */
    public List<WeeklyHours> getDailyHoursByDate(Date date) {

        if (ejbFacade != null) {
            ejbFacade.refreshData();
        }
        recreateModel();

        return ejbFacade.findTotalForPeriod(
                TimeUtils.getDayStart(date),
                TimeUtils.getDayEnd(date));

    }


    @FacesConverter(forClass = WeeklyHours.class)
    public static class WeeklyHoursControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            WeeklyHoursController controller = (WeeklyHoursController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "weeklyHoursController");
            return controller.getWeeklyHours(value);
        }                

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof WeeklyHours) {
                WeeklyHours o = (WeeklyHours) object;
                return o.getEmployee();
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + WeeklyHours.class.getName());
            }
        }
    }
}
