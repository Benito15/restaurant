package ac.za.cput.servicetest.catalog;

import ac.za.cput.domains.catalog.Catalog;
import ac.za.cput.factory.catalogfactory.CatalogFactory;
import ac.za.cput.service.catalog.impl.CatalogServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CatalogServiceImplTest {
    @Autowired
    private CatalogServiceImpl service;


    @Test
    public void getAll() {
        Catalog catalog = CatalogFactory.getCatalog("Some Catalog");
        service.create(catalog);
        System.out.println(service.getAll());
        Assert.assertNotNull(service);

    }

    @Test
    public void create() {
        Catalog catalog = CatalogFactory.getCatalog("Some Catalog");
        service.create(catalog);
        System.out.println(service.getAll());
        Assert.assertTrue(this.service.getAll().size()>0);

    }

    @Test
    public void update() {
        String updateDescription = "Updated Version";
        Catalog catalog = CatalogFactory.getCatalog("Some Catalog");
        service.create(catalog);
        Catalog updatedCatalog = CatalogFactory.getCatalog(updateDescription);
        this.service.update(updatedCatalog);
        Assert.assertTrue(updatedCatalog.getDescription().contains(updateDescription));

    }

    @Test
    public void delete() {
        Catalog catalog = CatalogFactory.getCatalog("Some Catalog");
        Catalog catalog2 = CatalogFactory.getCatalog("Some Catalog III");
        service.create(catalog);
        service.create(catalog2);
        this.service.delete(catalog.getItemID());
        Assert.assertTrue(this.service.getAll().size()>=1);


    }

    @Test
    public void read() {
        Catalog catalog = CatalogFactory.getCatalog("Some Catalog");
        Catalog catalog2 = CatalogFactory.getCatalog("Some Catalog III");
        service.create(catalog);
        service.create(catalog2);
        Catalog readBill = this.service.read(catalog.getItemID());
        Assert.assertNotEquals(readBill.getItemID(), catalog2.getItemID());
    }
}