package ac.za.cput.repositorytest.catalogtest;

import ac.za.cput.domains.catalog.Catalog;
import ac.za.cput.domains.purchase.item.Item;
import ac.za.cput.domains.supplier.Supplier;
import ac.za.cput.factory.catalogfactory.CatalogFactory;
import ac.za.cput.factory.purchasefactory.itemfactory.BurgerFactory;
import ac.za.cput.factory.supplierfactory.SupplierFactory;
import ac.za.cput.repositories.catalog.CatalogRepository;
import ac.za.cput.repositories.catalog.impl.CatalogRepositoryImpl;
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
public class CatalogRepositoryImplTest {

    @Autowired
    private CatalogRepository repository;
    Catalog catalog;
    Item burgerItem;
    Supplier supplier;

    @Before
    public void setUp() throws Exception {
        burgerItem = BurgerFactory.getBurger("Cheese Burger", 1, 50.00);
        supplier = SupplierFactory.getSupplier("Johnny", null);
        catalog  = CatalogFactory.getCatalog(burgerItem.getItemID(),supplier.getSupID(), burgerItem.getDesc());
        this.repository = CatalogRepositoryImpl.getRepository();
    }

    @Test
    public void getAll() {


        Assert.assertNotNull(this.repository.getAll());
    }

    @Test
    public void create() {
        Catalog createCatalog = this.repository.create(catalog);

        this.repository.create(createCatalog);
        int size = this.repository.getAll().size();
        System.out.println(size);

        Assert.assertNotNull(createCatalog);

    }

    @Test
    public void update() {
        Catalog createCatalog = this.repository.create(catalog);


        Catalog readCatalog = this.repository.read(createCatalog.getItemID(), createCatalog.getSupID());

        System.out.println(this.repository.getAll());
        Assert.assertNotNull(readCatalog);
    }

    @Test
    public void delete() {

        Catalog createCatalog = this.repository.create(catalog);


        Catalog readCatalog = this.repository.read(createCatalog.getItemID(), createCatalog.getSupID());
        this.repository.delete(createCatalog.getItemID(), createCatalog.getSupID());
        Catalog deletedCatalog = this.repository.read(createCatalog.getItemID(), createCatalog.getSupID());
        Assert.assertNull(deletedCatalog);
    }

    @Test
    public void read() {
        Catalog createCatalog = this.repository.create(catalog);


        repository.create(createCatalog);
        Catalog readCatalog = this.repository.read(createCatalog.getItemID(), createCatalog.getSupID());

        Assert.assertNotNull(readCatalog);

    }
}