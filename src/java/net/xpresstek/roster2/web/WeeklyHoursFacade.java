/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.xpresstek.roster2.web;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;
import net.xpresstek.roster2.ejb.WeeklyHours;

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
        String query = "SELECT NEW net.xpresstek.roster2.ejb.WeeklyHours (v.employee, SUM(v.minutes))"
                + " FROM ViewShifts v WHERE v.start >= :start AND v.end <= :end GROUP BY v.employee";
        Query qry=getEntityManager().createQuery(query);
        qry.setParameter("start", start);
        qry.setParameter("end", end);
        return qry.getResultList();
    }
    
}
