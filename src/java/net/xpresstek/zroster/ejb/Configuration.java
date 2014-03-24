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
 * Configuration bean
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

    /**
     * Default constructor
     */
    public Configuration() {
    }

    /**
     * Overloaded constructor sets configuration id
     *
     * @param configID
     */
    public Configuration(String configID) {
        this.configID = configID;
    }

    /**
     * Configuration id getter
     *
     * @return configuration id
     */
    public String getConfigID() {
        return configID;
    }

    /**
     * Configuration id getter
     *
     * @param configID
     */
    public void setConfigID(String configID) {
        if (configID != null && configID.length() > 0) {
            this.configID = configID;
        }
    }

    /**
     * Configuration value getter with password mask.
     * @return configuration value
     */
    public String getConfigValue() {
        
        if(configID !=null)
        {
            String lower = configID.toLowerCase();
            if(lower.contains("password"))
            {
                return "";
            }
        }
        return configValue;
    }
    
   /**
     * Configuration value getter, raw value.
     * @return configuration value
     */
    public String getConfigValueRaw()
    {
        return configValue;
    }

    /**
     * Configuration value setter
     * @param configValue
     */
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
        return "net.xpresstek.zroster.ejb.Configuration[ configID=" + configID + " ]";
    }
}
