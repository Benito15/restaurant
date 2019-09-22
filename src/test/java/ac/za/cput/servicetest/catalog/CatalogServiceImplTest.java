package ac.za.cput.servicetest.catalog;

import ac.za.cput.domains.catalog.Catalog;
import ac.za.cput.domains.purchase.item.Item;
import ac.za.cput.domains.supplier.Supplier;
import ac.za.cput.factory.catalogfactory.CatalogFactory;
import ac.za.cput.factory.purchasefactory.itemfactory.BurgerFactory;
import ac.za.cput.factory.supplierfactory.SupplierFactory;
import ac.za.cput.service.catalog.CatalogService;
import ac.za.cput.service.catalog.impl.CatalogServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CatalogServiceImplTest {
    @Autowired
    private CatalogService service;
    Catalog catalog;
    Item burgerItem;
    Supplier supplier;

    @Before
    public void setUp() throws Exception {
        this.service = CatalogServiceImpl.getService();
        burgerItem = BurgerFactory.getBurger("Cheese Burger", 1, 50.00);
        supplier = SupplierFactory.getSupplier("Johnny", null);
        catalog  = CatalogFactory.getCatalog(burgerItem.getItemID(),supplier.getSupID(), burgerItem.getDesc());
    }

    @Test
    public void getAll() {
        Set<Catalog> catalogSet = this.service.getAll();
        Assert.assertNotNull(catalogSet);

    }

    @Test
    public void create() {
        Catalog createCatalog = this.service.create(catalog);

        Assert.assertNotNull(createCatalog);
    }

    @Test
    public void update() {
        Catalog createCatalog = this.service.create(catalog);
        Catalog readCatalog = this.service.read(createCatalog.getItemID(), createCatalog.getSupID());
        Catalog updateCatalog = CatalogFactory.getCatalog(readCatalog.getItemID(), readCatalog.getSupID(),"This is an updated Description");
        this.service.update(updateCatalog);
        Assert.assertNotNull(updateCatalog.getItemID());
    }

    @Test
    public void delete() {

        Catalog createCatalog = this.service.create(catalog);
        Assert.assertNotNull(createCatalog);
    }

    @Test
    public void read() {
        Catalog createCatalog = this.service.create(catalog);
        Catalog readCatalog = this.service.read(createCatalog.getItemID(), createCatalog.getSupID());
        Assert.assertNotNull(readCatalog);
    }
}