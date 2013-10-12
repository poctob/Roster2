/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.xpresstek.roster2.web;

import javax.ejb.Stateless;
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
    
}
