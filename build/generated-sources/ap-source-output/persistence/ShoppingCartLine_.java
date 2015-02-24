package persistence;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import persistence.Product;
import persistence.Shoppingcart;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-11-12T12:41:32")
@StaticMetamodel(ShoppingCartLine.class)
public class ShoppingCartLine_ { 

    public static volatile SingularAttribute<ShoppingCartLine, Integer> quantity;
    public static volatile SingularAttribute<ShoppingCartLine, Product> fKProductID;
    public static volatile SingularAttribute<ShoppingCartLine, Shoppingcart> fKShoppingcartID;
    public static volatile SingularAttribute<ShoppingCartLine, Integer> id;

}