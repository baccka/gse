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
@Table(name = "Shop")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shop.findAll", query = "SELECT s FROM Shop s"),
    @NamedQuery(name = "Shop.findById", query = "SELECT s FROM Shop s WHERE s.id = :id"),
    @NamedQuery(name = "Shop.findByName", query = "SELECT s FROM Shop s WHERE s.name = :name")})
public class Shop implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fKShopID")
    private Collection<ShoppingCartLine> shoppingCartLineCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 255)
    @Column(name = "Name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fKShopID")
    private Collection<Administrator> administratorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fKShopID")
    private Collection<ProductCategory> productCategoryCollection;

    public Shop() {
    }

    public Shop(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<Administrator> getAdministratorCollection() {
        return administratorCollection;
    }

    public void setAdministratorCollection(Collection<Administrator> administratorCollection) {
        this.administratorCollection = administratorCollection;
    }

    @XmlTransient
    public Collection<ProductCategory> getProductCategoryCollection() {
        return productCategoryCollection;
    }

    public void setProductCategoryCollection(Collection<ProductCategory> productCategoryCollection) {
        this.productCategoryCollection = productCategoryCollection;
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
        if (!(object instanceof Shop)) {
            return false;
        }
        Shop other = (Shop) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistence.Shop[ id=" + id + " ]";
    }

    @XmlTransient
    public Collection<ShoppingCartLine> getShoppingCartLineCollection() {
        return shoppingCartLineCollection;
    }

    public void setShoppingCartLineCollection(Collection<ShoppingCartLine> shoppingCartLineCollection) {
        this.shoppingCartLineCollection = shoppingCartLineCollection;
    }
    
}
