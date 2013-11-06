/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.xpresstek.roster2.web;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import net.xpresstek.roster2.ejb.S3cr3t;

/**
 *
 * @author apavlune
 */
@Stateless
public class S3cr3tFacade extends AbstractFacade<S3cr3t> {

    public S3cr3tFacade() {
        super(S3cr3t.class);
    }

    public List<S3cr3t> findByEmployeeID(int employeeID) {
        TypedQuery<S3cr3t> query = getEntityManager().
                createNamedQuery("S3cr3t.findByUserId", S3cr3t.class);
        query.setParameter("userId", employeeID);
        return query.getResultList();
    }
    
     public void deleteByEmployeeID(int employeeID) {
        TypedQuery<S3cr3t> query = getEntityManager().
                createNamedQuery("S3cr3t.deleteByUserId", S3cr3t.class);
        query.setParameter("userId", employeeID);
        query.executeUpdate();
    }
}
