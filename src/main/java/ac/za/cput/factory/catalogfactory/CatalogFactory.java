package ac.za.cput.factory.catalogfactory;

import ac.za.cput.domains.catalog.Catalog;
import ac.za.cput.util.Misc;

public class CatalogFactory {


    public static Catalog getCatalog(String description)
    {
        return new Catalog.Builder()
                .itemID(Misc.generateId())
                .supID(Misc.generateId())
                .description(description)
                .build();


    }

}
