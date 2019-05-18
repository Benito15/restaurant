package factorytest.catalogtest;

import ac.za.cput.domains.catalog.Catalog;
import ac.za.cput.factory.catalogfactory.CatalogFactory;
import org.junit.Assert;
import org.junit.Test;

public class TestCatalog {



    @Test
    public void testCatalog()
    {
        String itemID = "12";
        String supID = "101";
        String description = "This is description: ";
        Catalog catalog = CatalogFactory.getCatalog(description);
        Assert.assertNotNull(catalog);



    }

}
