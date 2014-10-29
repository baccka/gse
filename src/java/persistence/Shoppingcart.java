/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package persistence;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 11365866
 */
@Entity
@Table(name = "Shopping cart")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shoppingcart.findAll", query = "SELECT s FROM Shoppingcart s"),
    @NamedQuery(name = "Shoppingcart.findById", query = "SELECT s FROM Shoppingcart s WHERE s.id = :id"),
    @NamedQuery(name = "Shoppingcart.findByNumItems", query = "SELECT s FROM Shoppingcart s WHERE s.numItems = :numItems"),
    @NamedQuery(name = "Shoppingcart.findBySubTotal", query = "SELECT s FROM Shoppingcart s WHERE s.subTotal = :subTotal")})
public class Shoppingcart implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NumItems")
    private int numItems;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SubTotal")
    private float subTotal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fKShoppingcartID")
    private Collection<Order1> order1Collection;
    @JoinColumn(name = "FK_CustomerID", referencedColumnName = "ID")
    @ManyToOne
    private Customer fKCustomerID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fKShoppingcartID")
    private Collection<ShoppingCartLine> shoppingCartLineCollection;

    public Shoppingcart() {
    }

    public Shoppingcart(Integer id) {
        this.id = id;
    }

    public Shoppingcart(Integer id, int numItems, float subTotal) {
        this.id = id;
        this.numItems = numItems;
        this.subTotal = subTotal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNumItems() {
        return numItems;
    }

    public void setNumItems(int numItems) {
        this.numItems = numItems;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

    @XmlTransient
    public Collection<Order1> getOrder1Collection() {
        return order1Collection;
    }

    public void setOrder1Collection(Collection<Order1> order1Collection) {
        this.order1Collection = order1Collection;
    }

    public Customer getFKCustomerID() {
        return fKCustomerID;
    }

    public void setFKCustomerID(Customer fKCustomerID) {
        this.fKCustomerID = fKCustomerID;
    }

    @XmlTransient
    public Collection<ShoppingCartLine> getShoppingCartLineCollection() {
        return shoppingCartLineCollection;
    }

    public void setShoppingCartLineCollection(Collection<ShoppingCartLine> shoppingCartLineCollection) {
        this.shoppingCartLineCollection = shoppingCartLineCollection;
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
        if (!(object instanceof Shoppingcart)) {
            return false;
        }
        Shoppingcart other = (Shoppingcart) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistence.Shoppingcart[ id=" + id + " ]";
    }
    
}
