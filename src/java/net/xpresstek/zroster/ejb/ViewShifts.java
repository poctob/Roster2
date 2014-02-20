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
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author apavlune
 */
@Entity
@Table(name = "VIEW_SHIFTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ViewShifts.findAll", query = "SELECT v FROM ViewShifts v"),
    @NamedQuery(name = "ViewShifts.findByKey", query = "SELECT v FROM ViewShifts v WHERE v.key = :key"),
    @NamedQuery(name = "ViewShifts.findByEmployee", query = "SELECT v FROM ViewShifts v WHERE v.employee = :employee"),
    @NamedQuery(name = "ViewShifts.findByPosition", query = "SELECT v FROM ViewShifts v WHERE v.position = :position"),
    @NamedQuery(name = "ViewShifts.findByStart", query = "SELECT v FROM ViewShifts v WHERE v.start = :start"),
    @NamedQuery(name = "ViewShifts.findByEnd", query = "SELECT v FROM ViewShifts v WHERE v.end = :end"),
    @NamedQuery(name = "ViewShifts.findTotalForPeriod", query = "SELECT v.employee, SUM(v.minutes) FROM ViewShifts v WHERE v.start >= :start AND v.end <= :end GROUP BY v.employee"),
    @NamedQuery(name = "ViewShifts.findByMinutes", query = "SELECT v FROM ViewShifts v WHERE v.minutes = :minutes")})
public class ViewShifts implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "KEY")
    private Integer key;
    @Size(max = 100)
    @Column(name = "Employee")
    private String employee;
    @Size(max = 100)
    @Column(name = "Position")
    private String position;
    @Column(name = "Start")
    @Temporal(TemporalType.TIMESTAMP)
    private Date start;
    @Column(name = "End")
    @Temporal(TemporalType.TIMESTAMP)
    private Date end;
    @Column(name = "Minutes")
    private BigInteger minutes;

    public ViewShifts() {
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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

    public BigInteger getMinutes() {
        return minutes;
    }

    public void setMinutes(BigInteger minutes) {
        this.minutes = minutes;
    }
    
     public BigDecimal getTotalHours() {
        BigDecimal lminutes=new BigDecimal(minutes.longValue());
        BigDecimal div=new BigDecimal("60.00");
        BigDecimal result=lminutes.divide(div);
        return result;
    }
    
}
