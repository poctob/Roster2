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

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import net.xpresstek.zroster.ejb.ClockEvent;

/**
 *
 * @author apavlune
 */
@Stateless
public class ClockEventFacade extends AbstractFacade<ClockEvent> {

    public static final String CLOCK_OUT_NAME="ClockOut";
    public static final String CLOCK_IN_NAME="ClockIn";
    
    public ClockEventFacade() {
        super(ClockEvent.class);
    }
    
    /**
     * Retrieve clock out event.
     * @return Clock out event.
     */
    public ClockEvent getClockOutEvent()
    {
        return getEventByName(CLOCK_OUT_NAME);
    }
    
    /**
     * Retrieve clock in event.
     * @return Clock in event.
     */
    public ClockEvent getClockInEvent()
    {
        return getEventByName(CLOCK_IN_NAME);
    }
    /**
     * Returns a ClockEvent matching specified name.
     * @param name Name to look for.
     * @return ClockEvent matching the name.
     */
    private ClockEvent getEventByName(String name)
    {
        TypedQuery<ClockEvent> query = getEntityManager().
                createNamedQuery("ClockEvent.findByName", ClockEvent.class);
        
        query.setParameter("name", name);
        return query.getSingleResult();
    }
}
