/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.xpresstek.zroster.ejb;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author apavlune
 */
@Entity
@Table(name = "TimeOffStatus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TimeOffStatus.findAll", query = "SELECT t FROM TimeOffStatus t"),
    @NamedQuery(name = "TimeOffStatus.findByPkid", query = "SELECT t FROM TimeOffStatus t WHERE t.pkid = :pkid"),
    @NamedQuery(name = "TimeOffStatus.findByName", query = "SELECT t FROM TimeOffStatus t WHERE t.name = :name")})
public class TimeOffStatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pkid")
    private Integer pkid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "timeOffStatusid")
    private Collection<TimeOff> timeOffCollection;

    public TimeOffStatus() {
    }

    public TimeOffStatus(Integer pkid) {
        this.pkid = pkid;
    }

    public TimeOffStatus(Integer pkid, String name) {
        this.pkid = pkid;
        this.name = name;
    }

    public Integer getPkid() {
        return pkid;
    }

    public void setPkid(Integer pkid) {
        this.pkid = pkid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<TimeOff> getTimeOffCollection() {
        return timeOffCollection;
    }

    public void setTimeOffCollection(Collection<TimeOff> timeOffCollection) {
        this.timeOffCollection = timeOffCollection;
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
        if (!(object instanceof TimeOffStatus)) {
            return false;
        }
        TimeOffStatus other = (TimeOffStatus) object;
        if ((this.pkid == null && other.pkid != null) || (this.pkid != null && !this.pkid.equals(other.pkid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name;
    }
    
}
