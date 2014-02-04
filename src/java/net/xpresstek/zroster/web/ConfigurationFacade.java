/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.xpresstek.zroster.web;

import javax.ejb.Stateless;
import net.xpresstek.zroster.ejb.Configuration;

/**
 *
 * @author apavlune
 */
@Stateless
public class ConfigurationFacade extends AbstractFacade<Configuration> {

    public ConfigurationFacade() {
        super(Configuration.class);
    }
    
}
