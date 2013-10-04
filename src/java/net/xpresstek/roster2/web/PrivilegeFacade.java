/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.xpresstek.roster2.web;

import javax.ejb.Stateless;
import net.xpresstek.roster2.ejb.Privilege;

/**
 *
 * @author apavlune
 */
@Stateless
public class PrivilegeFacade extends AbstractFacade<Privilege> {
    

    public PrivilegeFacade() {
        super(Privilege.class);
    }
    
}
