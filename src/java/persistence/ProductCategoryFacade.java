/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 11365866
 */
@Stateless
public class ProductCategoryFacade extends AbstractFacade<ProductCategory> {
    @PersistenceContext(unitName = "gsePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductCategoryFacade() {
        super(ProductCategory.class);
    }
    
    public ProductCategory findByName(String name){
       return em.createNamedQuery("ProductCategory.findByName", ProductCategory.class).setParameter("name", name).getSingleResult();
    }
}
