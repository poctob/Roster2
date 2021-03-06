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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author apavlune
 */
@Entity
@Table(name = "s3cr3t")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "S3cr3t.findAll", query = "SELECT s FROM S3cr3t s"),
    @NamedQuery(name = "S3cr3t.findByUserId", query = "SELECT s FROM S3cr3t s WHERE s.s3cr3tPK.userId = :userId"),
    @NamedQuery(name = "S3cr3t.findByPass", query = "SELECT s FROM S3cr3t s WHERE s.s3cr3tPK.pass = :pass"),
    @NamedQuery(name = "S3cr3t.deleteByUserId", query = "DELETE FROM S3cr3t s WHERE s.s3cr3tPK.userId = :userId"),
    @NamedQuery(name = "S3cr3t.findBySalt", query = "SELECT s FROM S3cr3t s WHERE s.s3cr3tPK.salt = :salt")})

public class S3cr3t implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected S3cr3tPK s3cr3tPK;
    @JoinColumn(name = "user_id", referencedColumnName = "pkID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Employee employee;

    public S3cr3t() {
    }

    public S3cr3t(S3cr3tPK s3cr3tPK) {
        this.s3cr3tPK = s3cr3tPK;
    }

    public S3cr3t(int userId, String pass, String salt) {
        this.s3cr3tPK = new S3cr3tPK(userId, pass, salt);
    }

    public S3cr3tPK getS3cr3tPK() {
        return s3cr3tPK;
    }

    public void setS3cr3tPK(S3cr3tPK s3cr3tPK) {
        this.s3cr3tPK = s3cr3tPK;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (s3cr3tPK != null ? s3cr3tPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof S3cr3t)) {
            return false;
        }
        S3cr3t other = (S3cr3t) object;
        if ((this.s3cr3tPK == null && other.s3cr3tPK != null) || (this.s3cr3tPK != null && !this.s3cr3tPK.equals(other.s3cr3tPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.xpresstek.zroster.ejb.S3cr3t[ s3cr3tPK=" + s3cr3tPK + " ]";
    }
    
}
