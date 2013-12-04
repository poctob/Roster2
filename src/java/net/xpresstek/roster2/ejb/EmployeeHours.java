/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.xpresstek.roster2.ejb;

import com.gzlabs.utils.DateUtils;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 * Performs calculations for current employee hours.
 *
 * @author apavlune
 */
@Stateless
public class EmployeeHours {

    private double scheduledHours;
    private double workedHours;
    private static final String PERSISTENCE_UNIT_NAME = "Roster2PU";
    private EntityManagerFactory factory;
    private EntityManager entityManager;

    public EmployeeHours() {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        entityManager = factory.createEntityManager();
    }

    public double getScheduledHours() {
        return scheduledHours;
    }

    public void setScheduledHours(double scheduledHours) {
        this.scheduledHours = scheduledHours;
    }

    public double getWorkedHours() {
        return workedHours;
    }

    public double getRemainingHours() {
        return scheduledHours - workedHours;
    }

    public void setWorkedHours(double workedHours) {
        this.workedHours = workedHours;
    }

    /**
     * Calculates worked and scheduled hours for specified day.
     *
     * @param employee Employee to calculate hours for.
     */
    public void calculateDailyHours(Employee employee) {
        Calendar todaystart = new GregorianCalendar();
        Calendar todayend = new GregorianCalendar();
        todaystart.set(Calendar.HOUR_OF_DAY, 0);
        todaystart.set(Calendar.MINUTE, 0);
        todaystart.set(Calendar.SECOND, 0);

        todayend.set(Calendar.HOUR_OF_DAY, 23);
        todayend.set(Calendar.MINUTE, 59);
        todayend.set(Calendar.SECOND, 59);

        List<Shift> shifts = findShiftsByEmployeeAndInterval(employee.getPkID(),
                todaystart.getTime(),
                todayend.getTime());

        scheduledHours = 0;
        if (shifts != null) {
            for (Shift s : shifts) {
                scheduledHours += s.getShiftHours();
            }
        }
    }

    /**
     * Calculates worked and scheduled hours for this week.
     *
     * @param employee Employee to calculate hours for.
     */
    public void calculateWeeklyHours(Employee employee) {
         Calendar cdate = new GregorianCalendar();
        //Hack to get week start on monday
        if(cdate.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY)
        {
            cdate.add(Calendar.DAY_OF_MONTH, -1);
        }
        
        Calendar start = DateUtils.getWeekStart(false, cdate);
        Calendar end = new GregorianCalendar();
        end.setTime(start.getTime());
        end.add(Calendar.DAY_OF_MONTH, 6);
        end.set(Calendar.HOUR, 23);
        end.set(Calendar.MINUTE, 59);
        end.set(Calendar.SECOND, 59);     

        List<Shift> shifts = findShiftsByEmployeeAndInterval(employee.getPkID(),
                start.getTime(),
                end.getTime());

        scheduledHours = 0;
        if (shifts != null) {
            for (Shift s : shifts) {
                scheduledHours += s.getShiftHours();
            }
        }
        
        workedHours=calculateWorkedHours
                (employee, start.getTime(), end.getTime());
    }
    
    private double calculateWorkedHours(Employee employee, Date start, Date end)
    {
        double retval=0;
        List<ClockEventTrans> clockevents=
                findClockEventsByEmployeeAndInterval(employee, start, end);
        
        double interval=0;
        ClockEventTrans current=null;
        for(ClockEventTrans event : clockevents)
        {
         
        }
        return retval;
    }

    /**
     * Retrieves shifts using employee id and specified start and end interval.
     *
     * @param empl_id Employee id.
     * @param start Start interval.
     * @param end End interval.
     * @return List of the shifts that employee is schedules to work.
     */
    private List<Shift> findShiftsByEmployeeAndInterval(int empl_id,
            Date start,
            Date end) {

        if (entityManager != null) {
            TypedQuery<Shift> query = entityManager.
                    createNamedQuery("Shift.findShiftsByEmployeeAndInterval",
                    Shift.class);

            query.setParameter("employeeID", empl_id);
            query.setParameter("daystart", start);
            query.setParameter("dayend", end);

            return query.getResultList();
        }
        return null;

    }
    
    /**
     * Retrieves clock events using employee id and specified start and end interval.
     *
     * @param empl_id Employee id.
     * @param start Start interval.
     * @param end End interval.
     * @return List of the shifts that employee is schedules to work.
     */
    private List<ClockEventTrans> findClockEventsByEmployeeAndInterval(Employee employee,
            Date start,
            Date end) {

        if (entityManager != null) {
            TypedQuery<ClockEventTrans> query = entityManager.
                    createNamedQuery("ClockEventTrans.findByEmployeeAndInterval",
                    ClockEventTrans.class);

            query.setParameter("employee", employee);
            query.setParameter("start", start);
            query.setParameter("end", end);

            return query.getResultList();
        }
        return null;

    }
}
