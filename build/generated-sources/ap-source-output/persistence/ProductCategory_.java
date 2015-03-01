package persistence;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import persistence.Product;
import persistence.Shop;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-02-28T08:17:30")
@StaticMetamodel(ProductCategory.class)
public class ProductCategory_ { 

    public static volatile CollectionAttribute<ProductCategory, Product> productCollection;
    public static volatile SingularAttribute<ProductCategory, String> name;
    public static volatile SingularAttribute<ProductCategory, String> description;
    public static volatile SingularAttribute<ProductCategory, Integer> id;
    public static volatile SingularAttribute<ProductCategory, Shop> fKShopID;

}