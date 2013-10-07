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
import net.xpresstek.roster2.web.ConfigurationController.ConfigurationControllerConverter;
import net.xpresstek.roster2.web.EmployeeController.EmployeeControllerConverter;
import net.xpresstek.roster2.web.PositionController.PositionControllerConverter;

@Named("shiftController")
@SessionScoped
public class ShiftController extends ControllerBase {

    private Shift current;
    private Date current_date;
    private String start_time;
    private String end_time;
    private Position position;
    private Employee employee;
    private String positionName;
    private String employeeName;
    
    @EJB
    private net.xpresstek.roster2.web.ShiftFacade ejbFacade;

    public ShiftController() {
        current_date=new Date();
    }

     @Override
    AbstractFacade getFacade() {
        return ejbFacade;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
        position=PositionControllerConverter.getController().
                getPositionByName(positionName);
        this.employee = null;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
        employee=EmployeeControllerConverter.getController().
                getEmployeeByName(employeeName);
    }
     
    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
        this.end_time = null;
        this.position = null;
        this.employee = null;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
        this.position = null;
        this.employee = null;
    }

    public void positionValueChanged(ValueChangeEvent event)
    {
       setPositionName((String)event.getNewValue());
    }
    
    public void employeeValueChanged(ValueChangeEvent event)
    {
       setEmployeeName((String)event.getNewValue());
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
    
     public Date getCurrent_date() {
        return current_date;
    }

    public void setCurrent_date(Date current_date) {
        this.current_date = current_date;
    }
    
    public List<String> getColHeading()
    {
        Set<String> headings=new LinkedHashSet(); 
        for(Shift s : ejbFacade.findAll())
        {
            Position pos=PositionControllerConverter.getController().
                    getPosition(s.getPositionID());
                    
            if(pos!=null)
            {
                headings.add(pos.getName());
            }
        }        
        return new ArrayList(headings);
    }
    
    public String getShiftName(String position, int time_index)
    {
        String retval=null;
        ConfigurationController cc=ConfigurationControllerConverter.getController();
        List times=cc.getTimeSlots();
        String time_slot=(String)times.get(time_index);
        time_slot+=":00.0";
        Position pos=PositionControllerConverter.getController().
                getPositionByName(position);
        int pos_idx=0;
        if(pos!=null)
        {
            pos_idx=pos.getPkID();
        }
        String strdate=DateUtils.DateToString(current_date);
        strdate=strdate.substring(0, 11);
        strdate+=time_slot;
        
        List<Shift> shifts=getAllItems();
        
        for(Shift s: shifts)
        {
           int employeeid=s.isEmployeeOn(pos_idx, strdate);
           if(employeeid>0)
           {
               Employee empl=EmployeeControllerConverter.getController().
                       getEmployee(employeeid);
               if(empl!=null)
               {
                   retval+=empl.getName()+",";
               }
           }
        }
        if(retval!=null)
        {
            retval = retval.substring(0, retval.length() - 1);
        }
        return retval;
    }
    
    public List<Shift> getAllItems()
    {
        return ejbFacade.findAll();
    }
    
    public List getStartTimes()
    {
        return ConfigurationControllerConverter.getController().getTimeSlots();
    }
    
    public List getEndTimes()
    {
        List startTimes=
                ConfigurationControllerConverter.getController().getTimeSlots();
        int index=startTimes.indexOf(start_time);
        index=index<0?0:index;
        if(index>=startTimes.size())
        {
            return null;
        }
        return startTimes.subList(index+1, startTimes.size());
    }
    
    public List getAvailableEmployees()
    {
        String startdate=DateUtils.DateToString(current_date);
        startdate=startdate.substring(0, 11);
        startdate+=start_time+":00.0";
        
        String enddate=DateUtils.DateToString(current_date);
        enddate=enddate.substring(0, 11);
        enddate+=end_time+":00.0";
        
        return EmployeeControllerConverter.getController().
                getAllowedItems(position, startdate, enddate);
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
