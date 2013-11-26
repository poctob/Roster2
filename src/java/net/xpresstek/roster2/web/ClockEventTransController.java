package net.xpresstek.roster2.web;

import java.util.Date;
import net.xpresstek.roster2.ejb.ClockEventTrans;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import net.xpresstek.roster2.ejb.ClockOutReasons;
import net.xpresstek.roster2.ejb.Employee;
import net.xpresstek.roster2.web.ClockEventController.ClockEventControllerConverter;

@SessionScoped
@Named("clockEventTransController")
public class ClockEventTransController extends ControllerBase {

    private ClockEventTrans current;
    private ClockOutReasons reason;
    @EJB
    private net.xpresstek.roster2.web.ClockEventTransFacade ejbFacade;

    public ClockEventTransController() {
    }

    /**
     * Performs clock in event for specified employee.
     *
     * @param employee Employee to clock in.
     */
    public void ClockIn(Employee employee) {
        current.setEmployeeid(employee);
        ClockEventController controller =
                ClockEventControllerConverter.getController();
        current.setClockEventid(controller.getClockInId());
        super.create();
    }

    /**
     * Performs clock out event for specified employee.
     *
     * @param employee Employee to clock out.
     * @param reason Clock out reason.
     */
    public void ClockOut(Employee employee) {
        current.setEmployeeid(employee);
        ClockEventController controller =
                ClockEventControllerConverter.getController();
        current.setClockEventid(controller.getClockOutId());
        current.setClockOutReasonid(reason.getPkid());
        super.create();
    }

    /**
     * Current clock out reason accessor.
     * @return Current clock out reasons
     */
    public ClockOutReasons getReason() {
        return reason;
    }

    /**
     * Clock out reason setter.
     * @param reason Reason to set.
     */
    public void setReason(ClockOutReasons reason) {
        this.reason = reason;
    }
    
    /**
     * Retrieves last event for the employee.
     * @param employee Employee to use in the search.
     * @return Name of the last clock event.
     */
    public String getLastEventName(Employee employee)
    {
        ClockEventTrans event=ejbFacade.getLastEvent(employee);
        if(event!=null)
        {
            return event.getClockEventid().getName();
        }
        return "";
    }
    
    /**
     * Retrieves last event time for the employee.
     * @param employee Employee to use in the search.
     * @return Time of the last event.
     */
    public Date getLastEventTime(Employee employee)
    {
        ClockEventTrans event=ejbFacade.getLastEvent(employee);
        if(event!=null)
        {
            return event.getTimestamp();
        }
        return null;
    }

    
    @Override
    AbstractFacade getFacade() {
        return ejbFacade;
    }

    public ClockEventTrans getClockEventTrans(java.lang.Integer id) {
        return ejbFacade.find(id);
    }

    @Override
    Object getCurrent() {
        return current;
    }

    @Override
    void setCurrent(Object obj) {
        current = (ClockEventTrans) obj;
    }

    @Override
    void createNewCurrent() {
        current = new ClockEventTrans();
        current.setTimestamp(new Date());
    }

    @FacesConverter(forClass = ClockEventTrans.class)
    public static class ClockEventTransControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ClockEventTransController controller = (ClockEventTransController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "clockEventTransController");
            return controller.getClockEventTrans(getKey(value));
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
            if (object instanceof ClockEventTrans) {
                ClockEventTrans o = (ClockEventTrans) object;
                return getStringKey(o.getPkid());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + ClockEventTrans.class.getName());
            }
        }
    }
}
