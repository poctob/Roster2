/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.xpresstek.roster2.web;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;
import org.richfaces.model.CalendarDataModel;
import org.richfaces.model.CalendarDataModelItem;

/**
 *
 * @author apavlune
 */
@Named("timeOffCalendarDataModel")
@ApplicationScoped
public class TimeOffCalendarDataModel implements CalendarDataModel {

    private static final String PAST_DAY_CLASS = "rf-ca-boundary-dates";
    private Date previousDate=null;
    
    TimeOffCalendarDataModel()
    {}

    TimeOffCalendarDataModel(Date previousDate)
    {
        this.previousDate=previousDate;
    }
    
    @Override
    public CalendarDataModelItem[] getData(Date[] dates) {
        CalendarDataModelItem[] modelItems = new CalendarModelItem[dates.length];
        Calendar current = GregorianCalendar.getInstance();
        Calendar today = GregorianCalendar.getInstance();
        today.setTime(new Date());
        for (int i = 0; i < dates.length; i++) {
            current.setTime(dates[i]);
            CalendarModelItem modelItem = new CalendarModelItem();
            if (current.before(today)) {
                modelItem.setEnabled(false);
                modelItem.setStyleClass(PAST_DAY_CLASS);
            } 
            else if(previousDate!=null && dates[i].before(previousDate))
            {
                modelItem.setEnabled(false);
                modelItem.setStyleClass(PAST_DAY_CLASS);
            } 
            else 
            {
                modelItem.setEnabled(true);
                modelItem.setStyleClass("");
            }
            modelItems[i] = modelItem;
        }

        return modelItems;
    }

    @Override
    public Object getToolTip(Date date) {
        return null;
    }

    private static class CalendarModelItem implements CalendarDataModelItem {

        private boolean enabled;
        private String styleClass;

        public CalendarModelItem() {
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        public void setStyleClass(String styleClass) {
            this.styleClass = styleClass;
        }

        @Override
        public boolean isEnabled() {
            return enabled;
        }

        @Override
        public String getStyleClass() {
            return styleClass;
        }

        @Override
        public Object getData() {
            return null;
        }

        @Override
        public boolean hasToolTip() {
            return false;
        }

        @Override
        public Object getToolTip() {
            return null;
        }

        @Override
        public int getDay() {
           return 0;
        }
    }
}
