/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.xpresstek.roster2.web;

import javax.ejb.Stateless;
import net.xpresstek.roster2.ejb.TimeOff;

/**
 *
 * @author apavlune
 */
@Stateless
public class TimeOffFacade extends AbstractFacade<TimeOff> {
    public TimeOffFacade() {
        super(TimeOff.class);
    }
    
}
