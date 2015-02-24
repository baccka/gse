package persistence;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import persistence.Customer;
import persistence.Order1;
import persistence.ShoppingCartLine;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-11-12T12:41:32")
@StaticMetamodel(Shoppingcart.class)
public class Shoppingcart_ { 

    public static volatile CollectionAttribute<Shoppingcart, Order1> order1Collection;
    public static volatile CollectionAttribute<Shoppingcart, ShoppingCartLine> shoppingCartLineCollection;
    public static volatile SingularAttribute<Shoppingcart, Customer> fKCustomerID;
    public static volatile SingularAttribute<Shoppingcart, Integer> id;
    public static volatile SingularAttribute<Shoppingcart, Float> subTotal;
    public static volatile SingularAttribute<Shoppingcart, Integer> numItems;

}