/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package persistence;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 11365866
 */
@Entity
@Table(name = "Delivery Person")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DeliveryPerson.findAll", query = "SELECT d FROM DeliveryPerson d"),
    @NamedQuery(name = "DeliveryPerson.findById", query = "SELECT d FROM DeliveryPerson d WHERE d.id = :id")})
public class DeliveryPerson implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ID")
    private String id;
    @JoinColumn(name = "FK_OrderID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Order1 fKOrderID;

    public DeliveryPerson() {
    }

    public DeliveryPerson(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Order1 getFKOrderID() {
        return fKOrderID;
    }

    public void setFKOrderID(Order1 fKOrderID) {
        this.fKOrderID = fKOrderID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DeliveryPerson)) {
            return false;
        }
        DeliveryPerson other = (DeliveryPerson) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistence.DeliveryPerson[ id=" + id + " ]";
    }
    
}
