package persistence;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import persistence.DeliveryPerson;
import persistence.ShoppingCartLine;
import persistence.Shoppingcart;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-02-28T08:17:30")
@StaticMetamodel(Order1.class)
public class Order1_ { 

    public static volatile SingularAttribute<Order1, String> orderDetails;
    public static volatile CollectionAttribute<Order1, ShoppingCartLine> shoppingCartLineCollection;
    public static volatile SingularAttribute<Order1, Float> price;
    public static volatile SingularAttribute<Order1, Shoppingcart> fKShoppingcartID;
    public static volatile CollectionAttribute<Order1, DeliveryPerson> deliveryPersonCollection;
    public static volatile SingularAttribute<Order1, String> orderStatus;
    public static volatile SingularAttribute<Order1, Integer> id;
    public static volatile SingularAttribute<Order1, String> orderDate;

}