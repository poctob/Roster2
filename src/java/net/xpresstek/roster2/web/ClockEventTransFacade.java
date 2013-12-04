/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.xpresstek.roster2.web;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import net.xpresstek.roster2.ejb.ClockEventTrans;
import net.xpresstek.roster2.ejb.Employee;

/**
 *
 * @author apavlune
 */
@Stateless
public class ClockEventTransFacade extends AbstractFacade<ClockEventTrans> {

    public ClockEventTransFacade() {
        super(ClockEventTrans.class);
    }
    
     /**
     * Returns last clock event for specified employee
     * @param employee_id Employee id.
     * @return last ClockEventTrans matching the id, null if none.
     */
    public ClockEventTrans getLastEvent(Employee employee_id)
    {
        TypedQuery<ClockEventTrans> query = getEntityManager().
                createNamedQuery("ClockEventTrans.findLastEvent", ClockEventTrans.class);
        
        query.setParameter("id", employee_id);
        query.setMaxResults(1);
        
        ClockEventTrans retval=null;
        try
        {
            retval=query.getSingleResult();            
        }
        catch(Exception e)
        {
             Logger.getLogger(UploadController.class.getName()).
                    log(Level.INFO, null, e);   
        }
        return retval;
    }
    
}
