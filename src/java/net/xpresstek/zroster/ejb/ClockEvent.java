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
@Table(name = "ClockEvent")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClockEvent.findAll", query = "SELECT c FROM ClockEvent c"),
    @NamedQuery(name = "ClockEvent.findByPkid", query = "SELECT c FROM ClockEvent c WHERE c.pkid = :pkid"),
    @NamedQuery(name = "ClockEvent.findByName", query = "SELECT c FROM ClockEvent c WHERE c.name = :name"),
    @NamedQuery(name = "ClockEvent.findByDescription", query = "SELECT c FROM ClockEvent c WHERE c.description = :description")})
public class ClockEvent implements Serializable {
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
    @Size(max = 200)
    @Column(name = "Description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clockEventid")
    private Collection<ClockEventTrans> clockEventTransCollection;

    public ClockEvent() {
    }

    public ClockEvent(Integer pkid) {
        this.pkid = pkid;
    }

    public ClockEvent(Integer pkid, String name) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<ClockEventTrans> getClockEventTransCollection() {
        return clockEventTransCollection;
    }

    public void setClockEventTransCollection(Collection<ClockEventTrans> clockEventTransCollection) {
        this.clockEventTransCollection = clockEventTransCollection;
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
        if (!(object instanceof ClockEvent)) {
            return false;
        }
        ClockEvent other = (ClockEvent) object;
        if ((this.pkid == null && other.pkid != null) || (this.pkid != null && !this.pkid.equals(other.pkid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.xpresstek.zroster.ejb.ClockEvent[ pkid=" + pkid + " ]";
    }
    
}
