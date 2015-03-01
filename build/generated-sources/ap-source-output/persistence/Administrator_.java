package persistence;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import persistence.Shop;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-02-28T08:17:30")
@StaticMetamodel(Administrator.class)
public class Administrator_ { 

    public static volatile SingularAttribute<Administrator, String> password;
    public static volatile SingularAttribute<Administrator, Integer> id;
    public static volatile SingularAttribute<Administrator, Shop> fKShopID;
    public static volatile SingularAttribute<Administrator, String> email;

}