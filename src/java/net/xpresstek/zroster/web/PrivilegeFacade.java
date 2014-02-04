/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.xpresstek.zroster.web;

import javax.ejb.Stateless;
import net.xpresstek.zroster.ejb.Privilege;

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
