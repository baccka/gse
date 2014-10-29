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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 11365866
 */
@Entity
@Table(name = "ProductImage")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductImage.findAll", query = "SELECT p FROM ProductImage p"),
    @NamedQuery(name = "ProductImage.findById", query = "SELECT p FROM ProductImage p WHERE p.id = :id"),
    @NamedQuery(name = "ProductImage.findByImage", query = "SELECT p FROM ProductImage p WHERE p.image = :image")})
public class ProductImage implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 255)
    @Column(name = "Image")
    private String image;
    @JoinColumn(name = "FK_ProductID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Product fKProductID;

    public ProductImage() {
    }

    public ProductImage(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
        if (!(object instanceof ProductImage)) {
            return false;
        }
        ProductImage other = (ProductImage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistence.ProductImage[ id=" + id + " ]";
    }
    
}
