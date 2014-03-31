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
import java.math.RoundingMode;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author apavlune
 */
@Entity
@Table(name = "WeeklyHours")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WeeklyHours.findAll", query = "SELECT w FROM WeeklyHours w"),
    @NamedQuery(name = "WeeklyHours.findByEmployee", query = "SELECT w FROM WeeklyHours w WHERE w.employee = :employee"),
    @NamedQuery(name = "WeeklyHours.findByTotalMinutes", query = "SELECT w FROM WeeklyHours w WHERE w.totalMinutes = :totalMinutes")})
public class WeeklyHours implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Size(max = 100)
    @Column(name = "Employee")
    private String employee;
    @Column(name = "TotalMinutes")
    private BigInteger totalMinutes;

    public WeeklyHours() {
    }
    
    public WeeklyHours(String employee, BigInteger totalMinutes) {
        this.employee=employee;
        this.totalMinutes=totalMinutes;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public BigInteger getTotalMinutes() {
        return totalMinutes;
    }
    
    public BigDecimal getTotalHours() {
        BigDecimal minutes=new BigDecimal(totalMinutes.longValue());
        BigDecimal div=new BigDecimal("60.00");
        BigDecimal result=minutes.divide(div, 2, RoundingMode.HALF_UP);
        return result;
    }
    public void setTotalMinutes(BigInteger totalMinutes) {
        this.totalMinutes = totalMinutes;
    }
    
}
