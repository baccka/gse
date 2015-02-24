package persistence;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import persistence.Product;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-11-12T12:41:32")
@StaticMetamodel(ProductImage.class)
public class ProductImage_ { 

    public static volatile SingularAttribute<ProductImage, String> image;
    public static volatile SingularAttribute<ProductImage, Product> fKProductID;
    public static volatile SingularAttribute<ProductImage, Integer> id;

}