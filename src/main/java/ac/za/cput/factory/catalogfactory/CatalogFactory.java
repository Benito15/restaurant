package ac.za.cput.factory.catalogfactory;

import ac.za.cput.domains.catalog.Catalog;
import ac.za.cput.util.Misc;

public class CatalogFactory {


    public static Catalog getCatalog(String itemID, String supID, String description)
    {

        return new Catalog(itemID, supID, description);
    }

}
