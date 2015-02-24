package persistence;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import persistence.Administrator;
import persistence.ProductCategory;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-11-12T12:41:32")
@StaticMetamodel(Shop.class)
public class Shop_ { 

    public static volatile CollectionAttribute<Shop, Administrator> administratorCollection;
    public static volatile SingularAttribute<Shop, String> name;
    public static volatile SingularAttribute<Shop, Integer> id;
    public static volatile CollectionAttribute<Shop, ProductCategory> productCategoryCollection;

}