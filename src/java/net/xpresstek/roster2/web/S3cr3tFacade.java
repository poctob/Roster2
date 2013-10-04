/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.xpresstek.roster2.web;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import net.xpresstek.roster2.ejb.S3cr3t;

/**
 *
 * @author apavlune
 */
@Stateless
public class S3cr3tFacade extends AbstractFacade<S3cr3t> {
    @PersistenceContext(unitName = "Roster2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public S3cr3tFacade() {
        super(S3cr3t.class);
    }
    
}
