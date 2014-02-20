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
 * Clock event entity class.  Mapped to the database table corresponding
 * to the clock events.
 * @author Alex Pavlunenko
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
    private static final Integer MAX_NAME_LENGTH = 45;
    private static final Integer MAX_DESCRIPTION_LENGTH = 200;
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

    /**
     * Default construct.  Does nothing
     */
    public ClockEvent() {
    }

    /**
     * Overloaded constructor allows setting of the primary key.
     * @param pkid Primary key
     */
    public ClockEvent(Integer pkid) {
        this.pkid = pkid;
    }

    /**
     * Overloaded constructor allows setting of all all properties.
     * @param pkid Primary key
     * @param name Event name
     */
    public ClockEvent(Integer pkid, String name) {
        this.pkid = pkid;
        this.name = name;
    }

    /**
     * Primary key getter.
     * @return Primary key
     */
    public Integer getPkid() {
        return pkid;
    }

    /**
     * Primary key setter
     * @param pkid Primary key
     */
    public void setPkid(Integer pkid) {
        if(pkid!=null && pkid > 0)
        {
            this.pkid = pkid;
        }
    }

    /**
     * name getter
     * @return Clock event name
     */
    public String getName() {
        return name;
    }

    /**
     * name setter
     * @param name Name to set
     */
    public void setName(String name) {
        if(name!=null && !name.isEmpty() && name.length()<=MAX_NAME_LENGTH)
        {
            this.name = name;
        }
    }

    /**
     * description getter
     * @return Description of the clock event
     */
    public String getDescription() {
        return description;
    }

    /**
     * description setter, this one is allowed to be null
     * @param description
     */
    public void setDescription(String description) {
        if(description != null && description.length()>MAX_DESCRIPTION_LENGTH)
        {
            return;
        }
        this.description = description;
    }

    /**
     * ClockEventTransCollection getter
     * @return ClockEventTransCollection
     */
    @XmlTransient
    public Collection<ClockEventTrans> getClockEventTransCollection() {
        return clockEventTransCollection;
    }

    /**
     * clockEventTransCollection setter
     * @param clockEventTransCollection
     */
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
