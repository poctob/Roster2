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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "Employee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e"),
    @NamedQuery(name = "Employee.findByPkID", query = "SELECT e FROM Employee e WHERE e.pkID = :pkID"),
    @NamedQuery(name = "Employee.findByName", query = "SELECT e FROM Employee e WHERE e.name = :name"),
    @NamedQuery(name = "Employee.findByAddress", query = "SELECT e FROM Employee e WHERE e.address = :address"),
    @NamedQuery(name = "Employee.findByPhone", query = "SELECT e FROM Employee e WHERE e.phone = :phone"),
    @NamedQuery(name = "Employee.findByIsActive", query = "SELECT e FROM Employee e WHERE e.isActive = :isActive"),
    @NamedQuery(name = "Employee.findByEmail", query = "SELECT e FROM Employee e WHERE e.email = :email"),
    @NamedQuery(name = "Employee.findByComment", query = "SELECT e FROM Employee e WHERE e.comment = :comment")})
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pkID")
    private Integer pkID;
    @Size(max = 100)
    @Column(name = "Name")
    private String name;
    @Size(max = 200)
    @Column(name = "Address")
    private String address;
    //@Pattern(regexp = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message = "Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 15)
    @Column(name = "Phone")
    private String phone;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IsActive")
    private boolean isActive;
    // @Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message = "Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 320)
    @Column(name = "Email")
    private String email;
    @Size(max = 500)
    @Column(name = "Comment")
    private String comment;
    @JoinTable(name = "EmployeeToPrivilege", joinColumns = {
        @JoinColumn(name = "EmployeeID", referencedColumnName = "pkID")}, inverseJoinColumns = {
        @JoinColumn(name = "PrivilegeID", referencedColumnName = "pkid")})
    @ManyToMany
    private Collection<Privilege> privilegeCollection;
    @JoinTable(name = "EmployeeToPosition", joinColumns = {
        @JoinColumn(name = "EmployeeID", referencedColumnName = "pkID")}, inverseJoinColumns = {
        @JoinColumn(name = "PositionID", referencedColumnName = "pkID")})
    @ManyToMany
    private Collection<Position> positionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeid")
    private Collection<TimeOff> timeOffCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeid")
    private Collection<ClockEventTrans> clockEventTransCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    private Collection<S3cr3t> s3cr3tCollection;

    

    public Employee() {
    }

    public Employee(Integer pkID) {
        this.pkID = pkID;
    }

    public Employee(Integer pkID, boolean isActive) {
        this.pkID = pkID;
        this.isActive = isActive;
    }

    public Integer getPkID() {
        return pkID;
    }

    public void setPkID(Integer pkID) {
        this.pkID = pkID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @XmlTransient
    public Collection<Privilege> getPrivilegeCollection() {
        return privilegeCollection;
    }

    public void setPrivilegeCollection(Collection<Privilege> privilegeCollection) {
        this.privilegeCollection = privilegeCollection;
    }

    @XmlTransient
    public Collection<Position> getPositionCollection() {
        return positionCollection;
    }

    public void setPositionCollection(Collection<Position> positionCollection) {
        this.positionCollection = positionCollection;
    }

    @XmlTransient
    public Collection<TimeOff> getTimeOffCollection() {
        return timeOffCollection;
    }

    public void setTimeOffCollection(Collection<TimeOff> timeOffCollection) {
        this.timeOffCollection = timeOffCollection;
    }

    @XmlTransient
    public Collection<ClockEventTrans> getClockEventTransCollection() {
        return clockEventTransCollection;
    }

    public void setClockEventTransCollection(Collection<ClockEventTrans> clockEventTransCollection) {
        this.clockEventTransCollection = clockEventTransCollection;
    }

    @XmlTransient
    public Collection<S3cr3t> getS3cr3tCollection() {
        return s3cr3tCollection;
    }

    public void setS3cr3tCollection(Collection<S3cr3t> s3cr3tCollection) {
        this.s3cr3tCollection = s3cr3tCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkID != null ? pkID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.pkID == null && other.pkID != null) || (this.pkID != null && !this.pkID.equals(other.pkID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name;
    }

    /**
     * Checks if this person is allowed to work on the position
     *
     * @param pos_id Position to compare
     * @return True is this person is allowed to work this position
     */
    public boolean isPositionAllowed(int position) {
        if (positionCollection != null && positionCollection.size() > 0) {
            for (Position pos : positionCollection) {
                if (pos != null && pos.getPkID() == position) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks if this employee is allowed to work at the specified time period
     *
     * @param start_time Starting time of a shift
     * @param end_time Ending time of a shift
     * @return True if this person is allowed to work this shift
     */
    public boolean isTimeAllowed(String start_time, String end_time) {

        if (start_time != null
                && end_time != null
                && timeOffCollection != null
                && timeOffCollection.size() > 0) {
            for (TimeOff to : timeOffCollection) {
                if (to != null) {
                    if (to.isConflicting(start_time, end_time)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }   
    
    public boolean hasPrivilege(String pName)
    {
        for(Privilege p : privilegeCollection)
        {
            if(p.getName().equals(pName))
            {
                return true;
            }
        }
        return false;
    }

}
