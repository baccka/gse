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
public class ShoppingcartFacade extends AbstractFacade<Shoppingcart> {
    @PersistenceContext(unitName = "gsePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ShoppingcartFacade() {
        super(Shoppingcart.class);
    }
    
    public Shoppingcart findByCustomer(Customer customer){
       List<Shoppingcart> carts = em.createNamedQuery("Shoppingcart.findByCustomer", Shoppingcart.class).setParameter("customer", customer).getResultList();
       if (carts.isEmpty()) {
           return null;
       }
       return carts.get(0);
    }
    
    // This method returns a shopping cart for the given customer
    // If the customer doesn't have a cart, a new one is created.
    public Shoppingcart getOrCreate(Customer customer) {
        Shoppingcart cart = findByCustomer(customer);
        if (cart != null) {
            return cart;
        }
        System.out.println("Creating a new shopping cart for customer " + customer.getId());
        cart = new Shoppingcart();
        cart.setId(customer.getId());
        cart.setFKCustomerID(customer);
        cart.setNumItems(0);
        cart.setSubTotal(0);
        create(cart);
        em.flush();
        return cart;
    }
    
    // This method updates the shopping cart after a new shopping line
    // has been added to the cart.
    public void addCartLine(Shoppingcart cart, ShoppingCartLine line) {
        cart.setNumItems(cart.getNumItems() + 1);
        edit(cart);
        em.flush();
    }
}
