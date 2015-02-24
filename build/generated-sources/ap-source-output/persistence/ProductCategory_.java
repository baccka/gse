package persistence;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import persistence.Product;
import persistence.Shop;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-11-12T12:41:32")
@StaticMetamodel(ProductCategory.class)
public class ProductCategory_ { 

    public static volatile CollectionAttribute<ProductCategory, Product> productCollection;
    public static volatile SingularAttribute<ProductCategory, String> name;
    public static volatile SingularAttribute<ProductCategory, String> description;
    public static volatile SingularAttribute<ProductCategory, Integer> id;
    public static volatile SingularAttribute<ProductCategory, Shop> fKShopID;

}