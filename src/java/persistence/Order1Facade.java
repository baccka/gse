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
public class Order1Facade extends AbstractFacade<Order1> {
    @PersistenceContext(unitName = "gsePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Order1Facade() {
        super(Order1.class);
    }
    
}
