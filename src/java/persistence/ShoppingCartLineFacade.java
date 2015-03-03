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
       return em.createNamedQuery("ShoppingCartLine.findByShoppingCart", ShoppingCartLine.class).setParameter("cart", cart).getResultList();
    }
    
    // Returns a line for a specific item in a cart, or null if this item
    // isn't in this cart.
    public ShoppingCartLine findByShoppingCartProductAndShop(Shoppingcart cart, Product product, Shop shop) {
        List<ShoppingCartLine> lines = em.createNamedQuery("ShoppingCartLine.findByShoppingCartProductAndShop", ShoppingCartLine.class).setParameter("cart", cart).setParameter("product", product).setParameter("shop", shop).getResultList();
        if (lines.isEmpty()) {
            return null;
        }
        assert(lines.size() == 1);
        return lines.get(0);
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
    
    // This method increases quantity of items of a specific a shopping cart line.
    public void increaseQuantity(ShoppingCartLine line, int quantity) {
        line.setQuantity(line.getQuantity() + quantity);
        edit(line);
        em.flush();
    }
    
}
