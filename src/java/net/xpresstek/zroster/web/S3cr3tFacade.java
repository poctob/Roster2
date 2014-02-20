/* 
 * Copyright (C) 2014 Alex Pavlunenko <alexp at xpresstek.net>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.xpresstek.zroster.web;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import net.xpresstek.zroster.ejb.S3cr3t;

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
