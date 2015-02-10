/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package persistence;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "ProductInstance")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductInstance.findAll", query = "SELECT p FROM ProductInstance p"),
    @NamedQuery(name = "ProductInstance.findByProductID", query = "SELECT p FROM ProductInstance p WHERE p.productInstancePK.productID = :productID"),
    @NamedQuery(name = "ProductInstance.findByShopID", query = "SELECT p FROM ProductInstance p WHERE p.productInstancePK.shopID = :shopID"),
    @NamedQuery(name = "ProductInstance.findByPrice", query = "SELECT p FROM ProductInstance p WHERE p.price = :price")})
public class ProductInstance implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductInstancePK productInstancePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Price")
    private float price;

    public ProductInstance() {
    }

    public ProductInstance(ProductInstancePK productInstancePK) {
        this.productInstancePK = productInstancePK;
    }

    public ProductInstance(ProductInstancePK productInstancePK, float price) {
        this.productInstancePK = productInstancePK;
        this.price = price;
    }

    public ProductInstance(int productID, int shopID) {
        this.productInstancePK = new ProductInstancePK(productID, shopID);
    }

    public ProductInstancePK getProductInstancePK() {
        return productInstancePK;
    }

    public void setProductInstancePK(ProductInstancePK productInstancePK) {
        this.productInstancePK = productInstancePK;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productInstancePK != null ? productInstancePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductInstance)) {
            return false;
        }
        ProductInstance other = (ProductInstance) object;
        if ((this.productInstancePK == null && other.productInstancePK != null) || (this.productInstancePK != null && !this.productInstancePK.equals(other.productInstancePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistence.ProductInstance[ productInstancePK=" + productInstancePK + " ]";
    }
    
}
