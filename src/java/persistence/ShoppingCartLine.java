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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 11365866
 */
@Entity
@Table(name = "ShoppingCartLine")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ShoppingCartLine.findAll", query = "SELECT s FROM ShoppingCartLine s"),
    @NamedQuery(name = "ShoppingCartLine.findById", query = "SELECT s FROM ShoppingCartLine s WHERE s.id = :id"),
    @NamedQuery(name = "ShoppingCartLine.findByQuantity", query = "SELECT s FROM ShoppingCartLine s WHERE s.quantity = :quantity")})
public class ShoppingCartLine implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "FK_ShopID")
    private int fKShopID;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Quantity")
    private int quantity;
    @JoinColumn(name = "FK_Shopping cartID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Shoppingcart fKShoppingcartID;
    @JoinColumn(name = "FK_ProductID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Product fKProductID;

    public ShoppingCartLine() {
    }

    public ShoppingCartLine(Integer id) {
        this.id = id;
    }

    public ShoppingCartLine(Integer id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Shoppingcart getFKShoppingcartID() {
        return fKShoppingcartID;
    }

    public void setFKShoppingcartID(Shoppingcart fKShoppingcartID) {
        this.fKShoppingcartID = fKShoppingcartID;
    }

    public Product getFKProductID() {
        return fKProductID;
    }

    public void setFKProductID(Product fKProductID) {
        this.fKProductID = fKProductID;
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
        if (!(object instanceof ShoppingCartLine)) {
            return false;
        }
        ShoppingCartLine other = (ShoppingCartLine) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistence.ShoppingCartLine[ id=" + id + " ]";
    }

    public int getFKShopID() {
        return fKShopID;
    }

    public void setFKShopID(int fKShopID) {
        this.fKShopID = fKShopID;
    }
    
}
