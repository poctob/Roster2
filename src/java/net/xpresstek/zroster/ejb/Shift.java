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
package net.xpresstek.zroster.ejb;

import com.gzlabs.utils.DateUtils;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import net.xpresstek.zroster.web.ControllerFactory;
import net.xpresstek.zroster.web.EmployeeController.EmployeeControllerConverter;
import net.xpresstek.zroster.web.PositionController.PositionControllerConverter;

/**
 *
 * @author apavlune
 */
@Entity
@Table(name = "Shift")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shift.findAll", query = "SELECT s FROM Shift s"),
    @NamedQuery(name = "Shift.findByPkid", query = "SELECT s FROM Shift s WHERE s.pkid = :pkid"),
    @NamedQuery(name = "Shift.findByEmployeeID", query = "SELECT s FROM Shift s WHERE s.employeeID = :employeeID"),
    @NamedQuery(name = "Shift.findByPositionID", query = "SELECT s FROM Shift s WHERE s.positionID = :positionID"),
    @NamedQuery(name = "Shift.findByStart", query = "SELECT s FROM Shift s WHERE s.start = :start"),
    @NamedQuery(name = "Shift.findFromStart", query = "SELECT s FROM Shift s WHERE s.start >= :start"),
    @NamedQuery(name = "Shift.findByPeriod", query = "SELECT s FROM Shift s WHERE s.start >= :start AND s.end <= :end"),
    @NamedQuery(name = "Shift.findByPositionIDAndStart", query = "SELECT s FROM Shift s WHERE s.positionID = :positionID AND s.start >= :start1 AND s.start < :start2"),
    @NamedQuery(name = "Shift.findByEmployeeIDAndStart", query =
            "SELECT s FROM Shift s WHERE s.employeeID = :employeeID AND "
            + "((s.start = :start1 AND s.end = :start2) OR "
            + "(s.start < :start1 AND s.end > :start1) OR "
            + "(s.start < :start2 AND s.end > :start2) OR"
            + "(s.start > :start1 AND s.start < :start2) OR"
            + "(s.end > :start1 AND s.end < :start2))"),
    @NamedQuery(name = "Shift.findByStartandEnd", query =
            "SELECT s FROM Shift s WHERE "
            + "((s.start = :start1 AND s.end = :start2) OR "
            + "(s.start < :start1 AND s.end > :start1) OR "
            + "(s.start < :start2 AND s.end > :start2) OR"
            + "(s.start > :start1 AND s.start < :start2) OR"
            + "(s.end > :start1 AND s.end < :start2))"),
    @NamedQuery(name = "Shift.findByPositionIDAndEmployeeIDAndStart", query = "SELECT s FROM Shift s WHERE s.positionID = :positionID AND s.start <= :start1 AND s.end >= :start1 AND s.employeeID = :employeeID"),
    @NamedQuery(name = "Shift.findByStartAndEmployee", query = "SELECT s FROM Shift s WHERE s.start >= :start AND s.employeeID = :employeeID"),
    @NamedQuery(name = "Shift.findShiftsByEmployeeAndInterval", query = "SELECT s FROM Shift s WHERE s.start >= :daystart AND s.start < :dayend AND s.employeeID = :employeeID"),
    @NamedQuery(name = "Shift.findByEnd", query = "SELECT s FROM Shift s WHERE s.end = :end")})
public class Shift implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pkid")
    private Integer pkid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Employee_ID")
    private int employeeID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Position_ID")
    private int positionID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Start")
    @Temporal(TemporalType.TIMESTAMP)
    private Date start;
    @Basic(optional = false)
    @NotNull
    @Column(name = "End")
    @Temporal(TemporalType.TIMESTAMP)
    private Date end;

    public Shift() {
    }

    public Shift(Integer pkid) {
        this.pkid = pkid;
    }

    public Shift(Integer pkid, int employeeID, int positionID, Date start, Date end) {
        this.pkid = pkid;
        this.employeeID = employeeID;
        this.positionID = positionID;
        this.start = start;
        this.end = end;
    }

    public Integer getPkid() {
        return pkid;
    }

    public void setPkid(Integer pkid) {
        this.pkid = pkid;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public int getPositionID() {
        return positionID;
    }

    public void setPositionID(int positionID) {
        this.positionID = positionID;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkid != null ? pkid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Shift)) {
            return false;
        }
        Shift other = (Shift) object;
        if ((this.pkid == null && other.pkid != null) || (this.pkid != null && !this.pkid.equals(other.pkid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.xpresstek.zroster.ejb.Shift[ pkid=" + pkid + " ]";
    }

    /**
     * Checks if a person is scheduled to work on specified date
     *
     * @param position Positions id
     * @param date Date
     * @return Person id if it's found, 0 if not
     */
    public int isEmployeeOn(int position, String date) {
        boolean start_b = DateUtils.isCalendarBetween(start, end, date, null, true);
        if (positionID > 0 && employeeID > 0 && positionID == position && start_b) {
            return employeeID;
        }
        return 0;
    }

    public Employee getEmployeeObject() {
        return ControllerFactory.getEmployeeController().
                getEmployee(employeeID);
    }

    public Position getPositionObject() {
        return ControllerFactory.getPositionController().
                getPosition(positionID);
    }

    /**
     * Calculates the total number of hours for this shift
     * @return Shift span in hours
     */
    public double getShiftHours() {
        double milliseconds = end.getTime() - start.getTime();
        return (milliseconds / 1000) / 3600;
    }
}
