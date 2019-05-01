package ac.za.cput.factory.catalogfactory;

import ac.za.cput.domains.catalog.Catalog;

public class CatalogFactory {


    public static Catalog getCatalog(String itemID,String supID)
    {
        return new Catalog.Builder()
                .itemID(itemID)
                .supID(supID)
                .build();


    }

}
