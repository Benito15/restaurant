package repositorytest.catalogtest;

import ac.za.cput.domains.catalog.Catalog;
import ac.za.cput.factory.catalogfactory.CatalogFactory;
import ac.za.cput.repositories.catalog.CatalogRepository;
import ac.za.cput.repositories.catalog.impl.CatalogRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.xml.bind.SchemaOutputResolver;
import java.util.Set;

import static org.junit.Assert.*;

public class CatalogRepositoryImplTest {

    private CatalogRepository repository;

    @Before
    public void setUp() throws Exception {
        this.repository = CatalogRepositoryImpl.getRepository();
    }

    @Test
    public void getAll() {
        Set<Catalog> getAllCatalogs = this.repository.getAll();
        System.out.println("Get All Catalogs: " + this.repository.getAll().size());
        Assert.assertNotNull("CatalogRepository: ", this.repository.getAll());
    }

    @Test
    public void create() {
        Catalog catalog = CatalogFactory.getCatalog("CATALOG 1");
        this.repository.create(catalog);
        int size = this.repository.getAll().size();
        System.out.println(size);
        Assert.assertTrue("This repository is not 0", this.repository.getAll().size() >0);

    }

    @Test
    public void update() {
        String updatedDesc = "Catalog2";
        Catalog catalog= CatalogFactory.getCatalog("Catalog1");

        repository.create(catalog);
        System.out.println("Catalog1: \n" + this.repository.getAll());
        System.out.println("----------------------------------------");
        catalog.setDescription(updatedDesc);

        this.repository.update(catalog);
        System.out.println("After catalog update---------------------------");
        System.out.println(this.repository.getAll());
        Assert.assertEquals(updatedDesc, catalog.getDescription());
    }

    @Test
    public void delete() {
        System.out.println(this.repository.getAll().size());
        System.out.println("--------------------------------");
        Catalog catalog= CatalogFactory.getCatalog("Catalog1");
        Catalog catalog2= CatalogFactory.getCatalog("Catalog2");
        repository.create(catalog);
        repository.create(catalog2);
        System.out.println(this.repository.getAll().size());

        this.repository.delete(catalog.getItemID());
        System.out.println("After Delete");
        System.out.println(this.repository.getAll().size());
        Assert.assertNotNull(this.repository);
    }

    @Test
    public void read() {
        Catalog catalog= CatalogFactory.getCatalog("Catalog1");
        Catalog catalog2= CatalogFactory.getCatalog("Catalog2");
        this.repository.create(catalog);
        this.repository.create(catalog2);
        System.out.println("Size after creating Objects->");
        System.out.println(this.repository.getAll().size());
        System.out.println("-------------------------------");
        Catalog readCatalog = this.repository.read(catalog.getItemID());
        System.out.println("Reading Object into new Object of type Catalog: ");
        System.out.println(readCatalog.getItemID());
        System.out.println("-----------------------------------");

        Assert.assertNotEquals(catalog2.getItemID(), readCatalog.getItemID());

    }
}