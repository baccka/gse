package persistence;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import persistence.Administrator;
import persistence.ProductCategory;
import persistence.ShoppingCartLine;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-02-28T08:17:30")
@StaticMetamodel(Shop.class)
public class Shop_ { 

    public static volatile CollectionAttribute<Shop, ShoppingCartLine> shoppingCartLineCollection;
    public static volatile CollectionAttribute<Shop, Administrator> administratorCollection;
    public static volatile SingularAttribute<Shop, String> name;
    public static volatile SingularAttribute<Shop, Integer> id;
    public static volatile CollectionAttribute<Shop, ProductCategory> productCategoryCollection;

}