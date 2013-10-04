/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.xpresstek.roster2.ejb;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "ClockOutReasons")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClockOutReasons.findAll", query = "SELECT c FROM ClockOutReasons c"),
    @NamedQuery(name = "ClockOutReasons.findByPkid", query = "SELECT c FROM ClockOutReasons c WHERE c.pkid = :pkid"),
    @NamedQuery(name = "ClockOutReasons.findByName", query = "SELECT c FROM ClockOutReasons c WHERE c.name = :name")})
public class ClockOutReasons implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pkid")
    private Integer pkid;
    @Size(max = 45)
    @Column(name = "Name")
    private String name;

    public ClockOutReasons() {
    }

    public ClockOutReasons(Integer pkid) {
        this.pkid = pkid;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkid != null ? pkid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClockOutReasons)) {
            return false;
        }
        ClockOutReasons other = (ClockOutReasons) object;
        if ((this.pkid == null && other.pkid != null) || (this.pkid != null && !this.pkid.equals(other.pkid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.xpresstek.roster2.ejb.ClockOutReasons[ pkid=" + pkid + " ]";
    }
    
}
