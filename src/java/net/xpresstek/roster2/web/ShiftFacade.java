/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.xpresstek.roster2.web;

import javax.ejb.Stateless;
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
    
}
