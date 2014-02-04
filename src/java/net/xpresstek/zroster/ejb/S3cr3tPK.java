/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.xpresstek.zroster.ejb;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author apavlune
 */
@Embeddable
public class S3cr3tPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_id")
    private int userId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "pass")
    private String pass;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "salt")
    private String salt;

    public S3cr3tPK() {
    }

    public S3cr3tPK(int userId, String pass, String salt) {
        this.userId = userId;
        this.pass = pass;
        this.salt = salt;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) userId;
        hash += (pass != null ? pass.hashCode() : 0);
        hash += (salt != null ? salt.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof S3cr3tPK)) {
            return false;
        }
        S3cr3tPK other = (S3cr3tPK) object;
        if (this.userId != other.userId) {
            return false;
        }
        if ((this.pass == null && other.pass != null) || (this.pass != null && !this.pass.equals(other.pass))) {
            return false;
        }
        if ((this.salt == null && other.salt != null) || (this.salt != null && !this.salt.equals(other.salt))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.xpresstek.zroster.ejb.S3cr3tPK[ userId=" + userId + ", pass=" + pass + ", salt=" + salt + " ]";
    }
    
}
