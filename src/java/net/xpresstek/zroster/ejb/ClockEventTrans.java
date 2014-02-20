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

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author apavlune
 */
@Entity
        @Table(name = "ClockEventTrans")
        @XmlRootElement
        @NamedQueries({
    @NamedQuery(name = "ClockEventTrans.findAll", query = "SELECT c FROM ClockEventTrans c ORDER BY c.timestamp DESC"),
    @NamedQuery(name = "ClockEventTrans.findByPkid", query = "SELECT c FROM ClockEventTrans c WHERE c.pkid = :pkid"),
    @NamedQuery(name = "ClockEventTrans.findLastEvent", query = "SELECT c FROM ClockEventTrans c WHERE c.employeeid = :id ORDER BY c.timestamp DESC"),
    @NamedQuery(name = "ClockEventTrans.findByTimestamp", query = "SELECT c FROM ClockEventTrans c WHERE c.timestamp = :timestamp"),
     @NamedQuery(name = "ClockEventTrans.findByInterval",
            query = "SELECT c FROM ClockEventTrans c "
            + "WHERE c.timestamp >= :start "
            + "AND c.timestamp <= :end "
            + "ORDER BY c.timestamp ASC"),
    @NamedQuery(name = "ClockEventTrans.findByEmployeeAndInterval",
            query = "SELECT c FROM ClockEventTrans c "
            + "WHERE c.timestamp >= :start "
            + "AND c.timestamp <= :end A"
            + "ND c.employeeid = :employee "
            + "ORDER BY c.timestamp ASC"),
    @NamedQuery(name = "ClockEventTrans.findByClockOutReasonid", query = "SELECT c FROM ClockEventTrans c WHERE c.clockOutReasonid = :clockOutReasonid"),
    @NamedQuery(name = "ClockEventTrans.findLastClockIn", query = "SELECT c FROM ClockEventTrans c "
        + "WHERE c.employeeid = :employee "
        + "AND c.pkid < :outpkid "
        + "AND c.clockEventid = :eventid "
        + "ORDER BY c.timestamp DESC")})


public class ClockEventTrans implements Serializable, Comparable<ClockEventTrans> {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pkid")
    private Integer pkid;
    @Column(name = "timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;
    @JoinColumn(name = "ClockOutReason_id", referencedColumnName = "pkid")
    @ManyToOne(optional = true)
    private ClockOutReasons clockOutReasonid;
    @JoinColumn(name = "ClockEvent_id", referencedColumnName = "pkid")
    @ManyToOne(optional = false)
    private ClockEvent clockEventid;
    @JoinColumn(name = "Employee_id", referencedColumnName = "pkID")
    @ManyToOne(optional = false)
    private Employee employeeid;

    public ClockEventTrans() {
    }

    public ClockEventTrans(Integer pkid) {
        this.pkid = pkid;
    }

    public ClockEventTrans(Integer pkid, Date timestamp) {
        this.pkid = pkid;
        this.timestamp = timestamp;
    }

    public Integer getPkid() {
        return pkid;
    }

    public void setPkid(Integer pkid) {
        this.pkid = pkid;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public ClockOutReasons getClockOutReasonid() {
        return clockOutReasonid;
    }

    public void setClockOutReasonid(ClockOutReasons clockOutReasonid) {
        this.clockOutReasonid = clockOutReasonid;
    }

    public ClockEvent getClockEventid() {
        return clockEventid;
    }

    public void setClockEventid(ClockEvent clockEventid) {
        this.clockEventid = clockEventid;
    }

    public Employee getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(Employee employeeid) {
        this.employeeid = employeeid;
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
        if (!(object instanceof ClockEventTrans)) {
            return false;
        }
        ClockEventTrans other = (ClockEventTrans) object;
        if ((this.pkid == null && other.pkid != null) || (this.pkid != null && !this.pkid.equals(other.pkid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.xpresstek.zroster.ejb.ClockEventTrans[ pkid=" + pkid + " ]";
    }

    @Override
    public int compareTo(ClockEventTrans o) {
        return this.timestamp.compareTo(o.timestamp);
    }
}
