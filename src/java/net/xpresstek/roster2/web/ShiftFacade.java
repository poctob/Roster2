/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.xpresstek.roster2.web;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import net.xpresstek.roster2.ejb.Shift;

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
        Calendar cal=new GregorianCalendar();
        cal.setTime(start);
        cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH)+1);
        
        query.setParameter("positionID", id);
        query.setParameter("start1", start);
        query.setParameter("start2", cal.getTime());
        return query.getResultList();
    }
}
