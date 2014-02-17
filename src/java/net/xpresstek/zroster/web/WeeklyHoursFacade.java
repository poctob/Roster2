/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.xpresstek.zroster.web;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import net.xpresstek.zroster.ejb.WeeklyHours;

/**
 *
 * @author apavlune
 */
@Stateless
public class WeeklyHoursFacade extends AbstractFacade<WeeklyHours> {

    public WeeklyHoursFacade() {
        super(WeeklyHours.class);
    }
    
    public void refreshData()
    {
        if(getEntityManager()!=null)
        {
            getEntityManager().getEntityManagerFactory().getCache().
                    evict(WeeklyHours.class);
        } 
    }
    
    public List<WeeklyHours> findTotalForPeriod(Date start, Date end) {
        String query = "SELECT NEW net.xpresstek.zroster.ejb.WeeklyHours (v.employee, SUM(v.minutes))"
                + " FROM ViewShifts v WHERE v.start >= :start AND v.end <= :end GROUP BY v.employee";
        Query qry=getEntityManager().createQuery(query);
        qry.setParameter("start", start);
        qry.setParameter("end", end);
        return qry.getResultList();
    }
    
    public List<WeeklyHours> findTotalForPeriodByEmployee(Date start, Date end, String empl) {
        String query = "SELECT NEW net.xpresstek.zroster.ejb.WeeklyHours (v.employee, SUM(v.minutes))"
                + " FROM ViewShifts v WHERE v.start >= :start AND v.end <= :end AND v.employee = :empl";
        Query qry=getEntityManager().createQuery(query);
        qry.setParameter("start", start);
        qry.setParameter("end", end);
        qry.setParameter("empl", empl);
        return qry.getResultList();
    }
    
    public List<WeeklyHours> findByEmployee(String name) {
         TypedQuery<WeeklyHours> query = getEntityManager().
                createNamedQuery("WeeklyHours.findByEmployee", WeeklyHours.class);
        query.setParameter("employee", name);        
        return query.getResultList();
    }
    
}
