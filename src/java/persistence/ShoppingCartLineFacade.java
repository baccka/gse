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
public class ShoppingCartLineFacade extends AbstractFacade<ShoppingCartLine> {
    @PersistenceContext(unitName = "gsePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ShoppingCartLineFacade() {
        super(ShoppingCartLine.class);
    }
    
       
    public List<ShoppingCartLine> findByShoppingCart(Shoppingcart cart){
       return em.createNamedQuery("Product.findByShoppingCart", ShoppingCartLine.class).setParameter("cart", cart).getResultList();
    }
    
    // This method adds a new line to a shopping cart.
    public ShoppingCartLine createInCart(Shoppingcart cart, Product product, Shop shop, int quantity) {
        ShoppingCartLine line = new ShoppingCartLine();
        line.setFKShoppingcartID(cart);
        line.setFKOrderID(null);
        line.setFKProductID(product);
        line.setFKShopID(shop);
        line.setQuantity(quantity);
        create(line);
        em.flush();
        return line;
    }
    
}
