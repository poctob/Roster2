/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.xpresstek.roster2.web;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import net.xpresstek.roster2.ejb.ClockOutReasons;

/**
 *
 * @author apavlune
 */
@Stateless
public class ClockOutReasonsFacade extends AbstractFacade<ClockOutReasons> {

    public ClockOutReasonsFacade() {
        super(ClockOutReasons.class);
    }
    
}
