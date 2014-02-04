/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.xpresstek.zroster.ejb;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
        BigDecimal result=minutes.divide(div);
        return result;
    }
    public void setTotalMinutes(BigInteger totalMinutes) {
        this.totalMinutes = totalMinutes;
    }
    
}
