package ac.za.cput.factorytest.catalogtest;

import ac.za.cput.domains.catalog.Catalog;
import ac.za.cput.domains.purchase.item.Item;
import ac.za.cput.domains.supplier.Supplier;
import ac.za.cput.factory.catalogfactory.CatalogFactory;
import ac.za.cput.factory.purchasefactory.itemfactory.BurgerFactory;
import ac.za.cput.factory.supplierfactory.SupplierFactory;
import ac.za.cput.repositories.catalog.impl.CatalogRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestCatalog {

    Catalog catalog;
    Item burgerItem;
    Supplier supplier;


    @Before
    public void setUp() throws Exception {
        burgerItem = BurgerFactory.getBurger("Cheese Burger", 1, 50.00);
        supplier = SupplierFactory.getSupplier("Johnny", null);
        catalog  = CatalogFactory.getCatalog(burgerItem.getItemID(),supplier.getSupID(), burgerItem.getDesc());


    }


    @Test
    public void testCatalog()
    {





        Assert.assertNotNull(catalog);



    }

}
