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

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import net.xpresstek.zroster.ejb.ClockEvent;
import net.xpresstek.zroster.ejb.ClockEventTrans;
import net.xpresstek.zroster.ejb.Employee;
import net.xpresstek.zroster.web.ClockEventController.ClockEventControllerConverter;

/**
 *
 * @author apavlune
 */
@Stateless
public class ClockEventTransFacade extends AbstractFacade<ClockEventTrans> {

    public ClockEventTransFacade() {
        super(ClockEventTrans.class);
    }

    /**
     * Returns last clock event for specified employee
     *
     * @param employee_id Employee id.
     * @return last ClockEventTrans matching the id, null if none.
     */
    public ClockEventTrans getLastEvent(Employee employee_id) {
        TypedQuery<ClockEventTrans> query = getEntityManager().
                createNamedQuery("ClockEventTrans.findLastEvent", ClockEventTrans.class);

        query.setParameter("id", employee_id);
        query.setMaxResults(1);

        ClockEventTrans retval = null;
        try {
            retval = query.getSingleResult();
        } catch (Exception e) {
            Logger.getLogger(UploadController.class.getName()).
                    log(Level.INFO, null, e);
        }
        return retval;
    }

    /**
     * Finds list clockin event for the employee
     *
     * @param employee_id Employee to search for
     * @param clock_out Clock out event
     * @return Clock in event for the employee
     */
    public ClockEventTrans getLastClockIn(Employee employee_id, ClockEventTrans clock_out) {
        ClockEvent clockin
                = ControllerFactory.getClockEventController().getClockInId();
        TypedQuery<ClockEventTrans> query = getEntityManager().
                createNamedQuery("ClockEventTrans.findLastClockIn",
                        ClockEventTrans.class);

        query.setParameter("employee", employee_id);
        query.setParameter("outpkid", clock_out.getPkid());
        query.setParameter("eventid", clockin);

        query.setMaxResults(1);

        ClockEventTrans retval = null;
        try {
            retval = query.getSingleResult();
        } catch (Exception e) {
            Logger.getLogger(UploadController.class.getName()).
                    log(Level.INFO, null, e);
        }
        return retval;
    }

    /**
     * Retrieves clock events using employee id and specified start and end
     * interval.
     *
     * @param employee Employee
     * @param start Start interval.
     * @param end End interval.
     * @return List of the shifts that employee is schedules to work.
     */
    public List<ClockEventTrans> findClockEventsByEmployeeAndInterval(Employee employee,
            Date start,
            Date end) {

        TypedQuery<ClockEventTrans> query = getEntityManager().
                createNamedQuery("ClockEventTrans.findByEmployeeAndInterval",
                        ClockEventTrans.class);

        query.setParameter("employee", employee);
        query.setParameter("start", start);
        query.setParameter("end", end);

        return query.getResultList();

    }
    
     /**
     * Retrieves clock events specified start and end
     * interval.
     *
     * @param start Start interval.
     * @param end End interval.
     * @return List of the shifts for the specified interval.
     */
    public List<ClockEventTrans> findClockEventsByInterval(
            Date start,
            Date end) {

        TypedQuery<ClockEventTrans> query = getEntityManager().
                createNamedQuery("ClockEventTrans.findByInterval",
                        ClockEventTrans.class);

        query.setParameter("start", start);
        query.setParameter("end", end);

        return query.getResultList();

    }

}
