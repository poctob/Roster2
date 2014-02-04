/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.xpresstek.zroster.web;

import javax.ejb.Stateless;
import net.xpresstek.zroster.ejb.ClockOutReasons;

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
