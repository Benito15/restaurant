package ac.za.cput.factories.catalogfactory;

import ac.za.cput.domains.catalog.Catalog;
import ac.za.cput.util.Misc;

public class CatalogFactory {


    public static Catalog getCatalog(String itemID,String supID)
    {
        return new Catalog.Builder()
                .itemID(itemID)
                .supID(supID)
                .build();


    }

}
