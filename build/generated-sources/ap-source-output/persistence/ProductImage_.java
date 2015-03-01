package persistence;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import persistence.Product;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-02-28T08:17:30")
@StaticMetamodel(ProductImage.class)
public class ProductImage_ { 

    public static volatile SingularAttribute<ProductImage, String> image;
    public static volatile SingularAttribute<ProductImage, Product> fKProductID;
    public static volatile SingularAttribute<ProductImage, Integer> id;

}