/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.xpresstek.roster2.ejb;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author apavlune
 */
@Entity
@Table(name = "Configuration")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Configuration.findAll", query = "SELECT c FROM Configuration c"),
    @NamedQuery(name = "Configuration.findByConfigID", query = "SELECT c FROM Configuration c WHERE c.configID = :configID"),
    @NamedQuery(name = "Configuration.findByConfigValue", query = "SELECT c FROM Configuration c WHERE c.configValue = :configValue")})
public class Configuration implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "ConfigID")
    private String configID;
    @Size(max = 500)
    @Column(name = "ConfigValue")
    private String configValue;

    public Configuration() {
    }

    public Configuration(String configID) {
        this.configID = configID;
    }

    public String getConfigID() {
        return configID;
    }

    public void setConfigID(String configID) {
        this.configID = configID;
    }

    public String getConfigValue() {
        return configValue;
    }

    public void setConfigValue(String configValue) {
        this.configValue = configValue;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (configID != null ? configID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Configuration)) {
            return false;
        }
        Configuration other = (Configuration) object;
        if ((this.configID == null && other.configID != null) || (this.configID != null && !this.configID.equals(other.configID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.xpresstek.roster2.ejb.Configuration[ configID=" + configID + " ]";
    }
    
}
