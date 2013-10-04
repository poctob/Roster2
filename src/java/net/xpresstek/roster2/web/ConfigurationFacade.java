/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.xpresstek.roster2.web;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import net.xpresstek.roster2.ejb.Configuration;

/**
 *
 * @author apavlune
 */
@Stateless
public class ConfigurationFacade extends AbstractFacade<Configuration> {
    @PersistenceContext(unitName = "Roster2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConfigurationFacade() {
        super(Configuration.class);
    }
    
}
