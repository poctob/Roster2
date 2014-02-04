/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.xpresstek.zroster.web;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import net.xpresstek.zroster.ejb.Shift;

/**
 *
 * @author apavlune
 */
@Stateless
public class ShiftFacade extends AbstractFacade<Shift> {

    public ShiftFacade() {
        super(Shift.class);
    }

    public List<Shift> findByPositionIdAndStart(int id, Date start) {
        TypedQuery<Shift> query = getEntityManager().
                createNamedQuery("Shift.findByPositionIDAndStart", Shift.class);
        Calendar cal = new GregorianCalendar();
        cal.setTime(start);
        cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) + 1);

        query.setParameter("positionID", id);
        query.setParameter("start1", start);
        query.setParameter("start2", cal.getTime());
        return query.getResultList();
    }

    public List<Shift> findByPositionIdAndEmployeeIDAndStart(int pos_id, int emp_id, Date start) {
        TypedQuery<Shift> query = getEntityManager().
                createNamedQuery("Shift.findByPositionIDAndEmployeeIDAndStart", Shift.class);

        query.setParameter("positionID", pos_id);
        query.setParameter("employeeID", emp_id);
        query.setParameter("start1", start);
        return query.getResultList();
    }

    public List<Shift> findByEmployeeIDAndStart(int emp_id, Date start, Date end) {
        TypedQuery<Shift> query = getEntityManager().
                createNamedQuery("Shift.findByEmployeeIDAndStart", Shift.class);

        query.setParameter("employeeID", emp_id);
        query.setParameter("start1", start);
        query.setParameter("start2", end);
        return query.getResultList();
    }

    public List<Shift> findByStartAndEmployee(Date start, int emp_id) {
        TypedQuery<Shift> query = getEntityManager().
                createNamedQuery("Shift.findByStartAndEmployee", Shift.class);

        query.setParameter("employeeID", emp_id);
        query.setParameter("start", start);
        return query.getResultList();
    }

    public List<Shift> findByStartandEnd(Date start, Date end) {
        TypedQuery<Shift> query = getEntityManager().
                createNamedQuery("Shift.findByStartandEnd", Shift.class);

        query.setParameter("start1", start);
        query.setParameter("start2", end);
        return query.getResultList();
    }

    public List<Shift> findByPeriod(Date start, Date end) {
        TypedQuery<Shift> query = getEntityManager().
                createNamedQuery("Shift.findByPeriod", Shift.class);
        query.setParameter("start1", start);
        query.setParameter("start2", end);
        return query.getResultList();
    }

    public List<Shift> findByStart(Date start) {
        TypedQuery<Shift> query = getEntityManager().
                createNamedQuery("Shift.findFromStart", Shift.class);
        query.setParameter("start", start);
        return query.getResultList();
    }

    public List<Shift> findShiftsByEmployeeAndInterval
            (int empl_id, 
            Date start, 
            Date end) {
        Calendar todaystart = new GregorianCalendar();
        Calendar todayend = new GregorianCalendar();
        todaystart.set(Calendar.HOUR_OF_DAY, 0);
        todaystart.set(Calendar.MINUTE, 0);
        todaystart.set(Calendar.SECOND, 0);

        todayend.set(Calendar.HOUR_OF_DAY, 23);
        todayend.set(Calendar.MINUTE, 59);
        todayend.set(Calendar.SECOND, 59);
        TypedQuery<Shift> query = getEntityManager().
                createNamedQuery("Shift.findShiftsByEmployeeAndInterval", Shift.class);
        query.setParameter("employeeID", empl_id);
        query.setParameter("daystart", start);
        query.setParameter("dayend", end);
        return query.getResultList();
    }
}
