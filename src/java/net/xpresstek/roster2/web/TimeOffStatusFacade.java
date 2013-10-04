/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.xpresstek.roster2.web;

import javax.ejb.Stateless;
import net.xpresstek.roster2.ejb.TimeOffStatus;

/**
 *
 * @author apavlune
 */
@Stateless
public class TimeOffStatusFacade extends AbstractFacade<TimeOffStatus> {

    public TimeOffStatusFacade() {
        super(TimeOffStatus.class);
    }
    
}
