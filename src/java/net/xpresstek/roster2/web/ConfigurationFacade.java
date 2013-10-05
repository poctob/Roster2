/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.xpresstek.roster2.web;

import javax.ejb.Stateless;
import net.xpresstek.roster2.ejb.Configuration;

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
