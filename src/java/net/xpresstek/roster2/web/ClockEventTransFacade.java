/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.xpresstek.roster2.web;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import net.xpresstek.roster2.ejb.ClockEventTrans;

/**
 *
 * @author apavlune
 */
@Stateless
public class ClockEventTransFacade extends AbstractFacade<ClockEventTrans> {
    @PersistenceContext(unitName = "Roster2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClockEventTransFacade() {
        super(ClockEventTrans.class);
    }
    
}
