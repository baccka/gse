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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 11365866
 */
@Entity
@Table(name = "Order")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Order1.findAll", query = "SELECT o FROM Order1 o"),
    @NamedQuery(name = "Order1.findById", query = "SELECT o FROM Order1 o WHERE o.id = :id"),
    @NamedQuery(name = "Order1.findByPrice", query = "SELECT o FROM Order1 o WHERE o.price = :price"),
    @NamedQuery(name = "Order1.findByOrderDate", query = "SELECT o FROM Order1 o WHERE o.orderDate = :orderDate"),
    @NamedQuery(name = "Order1.findByOrderStatus", query = "SELECT o FROM Order1 o WHERE o.orderStatus = :orderStatus"),
    @NamedQuery(name = "Order1.findByOrderDetails", query = "SELECT o FROM Order1 o WHERE o.orderDetails = :orderDetails")})
public class Order1 implements Serializable {
    @OneToMany(mappedBy = "fKOrderID")
    private Collection<ShoppingCartLine> shoppingCartLineCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Price")
    private float price;
    @Size(max = 255)
    @Column(name = "OrderDate")
    private String orderDate;
    @Size(max = 255)
    @Column(name = "OrderStatus")
    private String orderStatus;
    @Size(max = 255)
    @Column(name = "OrderDetails")
    private String orderDetails;
    @JoinColumn(name = "FK_Shopping cartID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Shoppingcart fKShoppingcartID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fKOrderID")
    private Collection<DeliveryPerson> deliveryPersonCollection;

    public Order1() {
    }

    public Order1(Integer id) {
        this.id = id;
    }

    public Order1(Integer id, float price) {
        this.id = id;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(String orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Shoppingcart getFKShoppingcartID() {
        return fKShoppingcartID;
    }

    public void setFKShoppingcartID(Shoppingcart fKShoppingcartID) {
        this.fKShoppingcartID = fKShoppingcartID;
    }

    @XmlTransient
    public Collection<DeliveryPerson> getDeliveryPersonCollection() {
        return deliveryPersonCollection;
    }

    public void setDeliveryPersonCollection(Collection<DeliveryPerson> deliveryPersonCollection) {
        this.deliveryPersonCollection = deliveryPersonCollection;
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
        if (!(object instanceof Order1)) {
            return false;
        }
        Order1 other = (Order1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistence.Order1[ id=" + id + " ]";
    }

    @XmlTransient
    public Collection<ShoppingCartLine> getShoppingCartLineCollection() {
        return shoppingCartLineCollection;
    }

    public void setShoppingCartLineCollection(Collection<ShoppingCartLine> shoppingCartLineCollection) {
        this.shoppingCartLineCollection = shoppingCartLineCollection;
    }
    
}
