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
public class ProductFacade extends AbstractFacade<Product> {
    @PersistenceContext(unitName = "gsePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductFacade() {
        super(Product.class);
    }
    
    public List<Product> findByQuery(String query){
       return em.createNamedQuery("Product.findByQuery", Product.class).setParameter("query", "%" + query + "%").getResultList();
    }
    
    public List<Product> findByQueryAndCategory(String query, ProductCategory category){
       return em.createNamedQuery("Product.findByQueryAndCategory", Product.class).setParameter("query", "%" + query + "%").setParameter("categoryId", category).getResultList();
    }
    
    public List<Product> findByQueryAndShop(String query, Shop shop){
       return em.createNamedQuery("Product.findByQueryAndShop", Product.class).setParameter("query", "%" + query + "%").setParameter("shopId", shop.getId()).getResultList();
    }
    
    public List<Product> findByQueryAndShopAndCategory(String query, Shop shop, ProductCategory category){
       return em.createNamedQuery("Product.findByQueryAndShopAndCategory", Product.class).setParameter("query", "%" + query + "%").setParameter("shopId", shop.getId()).setParameter("categoryId", category).getResultList();
    }
    
}
