/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package persistence;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author 11365866
 */
@Embeddable
public class ProductInstancePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "ProductID")
    private int productID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ShopID")
    private int shopID;

    public ProductInstancePK() {
    }

    public ProductInstancePK(int productID, int shopID) {
        this.productID = productID;
        this.shopID = shopID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getShopID() {
        return shopID;
    }

    public void setShopID(int shopID) {
        this.shopID = shopID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) productID;
        hash += (int) shopID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductInstancePK)) {
            return false;
        }
        ProductInstancePK other = (ProductInstancePK) object;
        if (this.productID != other.productID) {
            return false;
        }
        if (this.shopID != other.shopID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistence.ProductInstancePK[ productID=" + productID + ", shopID=" + shopID + " ]";
    }
    
}
