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
public class CustomerFacade extends AbstractFacade<Customer> {
    @PersistenceContext(unitName = "gsePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomerFacade() {
        super(Customer.class);
    }
    
    public Customer findByEmail(String email) {
        return em.createNamedQuery("Customer.findByEmail", Customer.class).setParameter("email", email).getSingleResult();
    }
    
    public List<Customer> findByPassword(String password) {
        return em.createNamedQuery("Customer.findByPassword", Customer.class).setParameter("password", password).getResultList();
    }
    
    

}

