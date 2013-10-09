package net.xpresstek.roster2.web;

import com.gzlabs.utils.DateUtils;
import net.xpresstek.roster2.ejb.Shift;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.event.ValueChangeEvent;
import net.xpresstek.roster2.ejb.Employee;
import net.xpresstek.roster2.ejb.Position;
import net.xpresstek.roster2.ejb.ShiftColumn;
import net.xpresstek.roster2.web.ConfigurationController.ConfigurationControllerConverter;
import net.xpresstek.roster2.web.EmployeeController.EmployeeControllerConverter;
import net.xpresstek.roster2.web.PositionController.PositionControllerConverter;

@Named("shiftController")
@SessionScoped
public class ShiftController extends ControllerBase {

    private Shift current;
    private Date current_date;
    private String start_time;
    private String start_date;
    private String end_date;
    private String end_time;
    private Position position;
    private Employee employee;
    private String positionName;
    private String employeeName;
    private int current_pkid;
    private String selected_time;
    private String selected_position;
    private String selected_employee;
    
    @EJB
    private net.xpresstek.roster2.web.ShiftFacade ejbFacade;

    public ShiftController() {
        current_date = new Date();
        current_pkid = 0;
    }

    @Override
    AbstractFacade getFacade() {
        return ejbFacade;
    }

    public String getSelected_employee() {
        return selected_employee;
    }

    public void setSelected_employee(String selected_employee) {
        this.selected_employee = selected_employee;
    }

    public String getSelected_position() {
        return selected_position;
    }

    public void setSelected_position(String selected_position) {
        this.selected_position = selected_position;
    }
    
    public String getSelected_time() {
        return selected_time;
    }

    public void setSelected_time(String selected_time) {
        this.selected_time = selected_time;
    }
    
     public int getCurrent_pkid() {
        return current_pkid;
    }

    public void setCurrent_pkid(int current_pkid) {
        this.current_pkid = current_pkid;
        this.current=ejbFacade.find(current_pkid);
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
        position = PositionControllerConverter.getController().
                getPositionByName(positionName);
        this.employee = null;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
        employee = EmployeeControllerConverter.getController().
                getEmployeeByName(employeeName);
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
        start_date = DateUtils.DateToString(current_date);
        start_date = start_date.substring(0, 11);
        start_date += start_time + ":00.0";

        this.end_time = null;
        this.position = null;
        this.employee = null;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
        end_date = DateUtils.DateToString(current_date);
        end_date = end_date.substring(0, 11);
        end_date += end_time + ":00.0";
        this.position = null;
        this.employee = null;
    }

    public void positionValueChanged(ValueChangeEvent event) {
        setPositionName((String) event.getNewValue());
    }

    public void employeeValueChanged(ValueChangeEvent event) {
        setEmployeeName((String) event.getNewValue());
    }

    public void addShift() {
        if (position != null
                && employee != null
                && start_date.length() > 0
                && end_date.length() > 0) {
            prepareCreate();
            current.setEmployeeID(employee.getPkID());
            current.setPositionID(position.getPkID());
            current.setStart(DateUtils.StringToDate(start_date));
            current.setEnd(DateUtils.StringToDate(end_date));
            create();
        }
    }

    @Override
    public Object getCurrent() {
        return current;
    }

    public Shift getShift(Integer id) {
        return (Shift) getObject(id);
    }

    @Override
    public void setCurrent(Object obj) {
        current = (Shift) obj;
    }

    @Override
    void createNewCurrent() {
        current = new Shift();
    }

    public Date getCurrent_date() {
        return current_date;
    }

    public void setCurrent_date(Date current_date) {
        this.current_date = current_date;
    }

    public List<String> getColHeading() {
        Set<String> headings = new LinkedHashSet();
        for (Shift s : ejbFacade.findAll()) {
            Position pos = PositionControllerConverter.getController().
                    getPosition(s.getPositionID());

            if (pos != null) {
                headings.add(pos.getName());
            }
        }
        return new ArrayList(headings);
    }
    
    public List<ShiftColumn> getShiftColumns()
    {
        List<Position> pos=
                PositionControllerConverter.getController().getAllItems();
        
        ArrayList<ShiftColumn> columns=new ArrayList();
        
       for(Position p:pos)
       {
           List<Shift> shifts=ejbFacade.
                   findByPositionIdAndStart(p.getPkID(), current_date);
           if(shifts!=null && shifts.size()>0)
           {
               columns.add(new ShiftColumn(shifts,p));
           }
       }
       return columns;
        
    }

    public Shift getShiftName(String position, String time) {
        Position pos = PositionControllerConverter.getController().
                getPositionByName(position);
        if (pos == null) {
            return null;
        }

        ConfigurationController cc = ConfigurationControllerConverter.getController();
        List times = cc.getTimeSlots();

        int pos_idx = 0;
        pos_idx = pos.getPkID();

        String strdate = DateUtils.DateToString(current_date);
        strdate = strdate.substring(0, 11);
        List<Shift> shifts = getAllItems();

        String time_slot = time + ":00.0";
        strdate += time_slot;

        for (Shift s : shifts) {
            int employeeid = s.isEmployeeOn(pos_idx, strdate);
            if (employeeid > 0) {
                return s;
            }

        }
        return null;
    }

    public List<Shift> getAllItems() {
        return ejbFacade.findAll();
    }

    public List getStartTimes() {
        return ConfigurationControllerConverter.getController().getTimeSlots();
    }

    public List getEndTimes() {
        List startTimes =
                ConfigurationControllerConverter.getController().getTimeSlots();
        int index = startTimes.indexOf(start_time);
        index = index < 0 ? 0 : index;
        if (index >= startTimes.size()) {
            return null;
        }
        return startTimes.subList(index + 1, startTimes.size());
    }

    public List getAvailableEmployees() {
        return EmployeeControllerConverter.getController().
                getAllowedItems(position, start_date, end_date);
    }
    
    public void processShiftClick(String position, String time) {
        int i;
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
