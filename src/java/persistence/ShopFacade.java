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
public class ShopFacade extends AbstractFacade<Shop> {
    @PersistenceContext(unitName = "gsePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ShopFacade() {
        super(Shop.class);
    }
    
    public Shop findByName(String name){
       return em.createNamedQuery("Shop.findByName", Shop.class).setParameter("name", name).getSingleResult();
    }
    
}
