/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.xpresstek.roster2.web;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
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

    public List<TimeOffStatus> findByName(String name) {
        TypedQuery<TimeOffStatus> query = getEntityManager().
                createNamedQuery("TimeOffStatus.findByName", TimeOffStatus.class);
        query.setParameter("name", name);
        return query.getResultList();
    }
}
