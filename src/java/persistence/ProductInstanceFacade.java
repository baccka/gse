/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package persistence;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 11365866
 */
@Stateless
public class ProductInstanceFacade extends AbstractFacade<ProductInstance> {
    @PersistenceContext(unitName = "gsePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductInstanceFacade() {
        super(ProductInstance.class);
    }
    
    public List<ProductInstance> findByProduct(Product product) {
        return em.createNamedQuery("ProductInstance.findByProductID", ProductInstance.class).setParameter("productID", product.getId()).getResultList();
    }
}
