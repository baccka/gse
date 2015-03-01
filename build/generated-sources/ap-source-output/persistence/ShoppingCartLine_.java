package persistence;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import persistence.Order1;
import persistence.Product;
import persistence.Shop;
import persistence.Shoppingcart;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-02-28T08:17:30")
@StaticMetamodel(ShoppingCartLine.class)
public class ShoppingCartLine_ { 

    public static volatile SingularAttribute<ShoppingCartLine, Integer> quantity;
    public static volatile SingularAttribute<ShoppingCartLine, Order1> fKOrderID;
    public static volatile SingularAttribute<ShoppingCartLine, Product> fKProductID;
    public static volatile SingularAttribute<ShoppingCartLine, Shoppingcart> fKShoppingcartID;
    public static volatile SingularAttribute<ShoppingCartLine, Integer> id;
    public static volatile SingularAttribute<ShoppingCartLine, Shop> fKShopID;

}