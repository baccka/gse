package persistence;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import persistence.ProductCategory;
import persistence.ProductImage;
import persistence.ShoppingCartLine;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-11-12T12:41:32")
@StaticMetamodel(Product.class)
public class Product_ { 

    public static volatile SingularAttribute<Product, String> mainImage;
    public static volatile CollectionAttribute<Product, ShoppingCartLine> shoppingCartLineCollection;
    public static volatile SingularAttribute<Product, Float> price;
    public static volatile SingularAttribute<Product, String> name;
    public static volatile SingularAttribute<Product, String> description;
    public static volatile CollectionAttribute<Product, ProductImage> productImageCollection;
    public static volatile SingularAttribute<Product, Integer> id;
    public static volatile SingularAttribute<Product, ProductCategory> fKProductCategoryID;

}