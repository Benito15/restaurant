package ac.za.cput.repositorytest.suppliertest;

import ac.za.cput.domains.supplier.Supplier;
import ac.za.cput.factory.supplierfactory.SupplierFactory;
import ac.za.cput.repositories.supplierrepository.SupplierRepository;
import ac.za.cput.repositories.supplierrepository.impl.SupplierRepositoryImpl;
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
public class SupplierRepositoryImplTest {

    @Autowired
    private SupplierRepository repository;

    @Before
    public void setUp() throws Exception {
        this.repository = SupplierRepositoryImpl.getRepository();

    }

    @Test
    public void getAll() {
        Set<Supplier> getAllSuppliers = this.repository.getAll();
        System.out.println("Get all Suppliers: " + this.repository.getAll().size());
        Assert.assertNotNull("SupplierRepository: ", repository.getAll());
    }

    @Test
    public void create() {
        Supplier supplier = SupplierFactory.getSupplier("Tommies Patties","Cape Town");
        this.repository.create(supplier);
        int size = this.repository.getAll().size();
        System.out.println(size);
        Assert.assertTrue("This repository is not 0", this.repository.getAll().size() >0);

    }

    @Test
    public void update() {
        String newAddress = "Durban";
        Supplier supplier = SupplierFactory.getSupplier("Tommies Patties","Cape Town");

        repository.create(supplier);
        System.out.println("Address1: \n" + this.repository.getAll());
        System.out.println("----------------------------------------");
        supplier.setAddress(newAddress);

        this.repository.update(supplier);
        System.out.println("After address update---------------------------");
        System.out.println(this.repository.getAll());
        Assert.assertEquals(newAddress, supplier.getAddress());
    }

    @Test
    public void delete() {
        System.out.println(this.repository.getAll().size());
        System.out.println("--------------------------------");
        Supplier supplier = SupplierFactory.getSupplier("Tommies Patties","Cape Town");
        Supplier supplier1 = SupplierFactory.getSupplier("Hot Buns","Cape Town");
        this.repository.create(supplier);
        this.repository.create(supplier1);
        System.out.println(this.repository.getAll().size());

        this.repository.delete(supplier1.getSupID());
        System.out.println("After Delete");
        System.out.println(this.repository.getAll().size());
        Assert.assertNotNull(this.repository);
    }

    @Test
    public void read() {
        Supplier supplier = SupplierFactory.getSupplier("Tommies Patties","Cape Town");
        Supplier supplier1 = SupplierFactory.getSupplier("Tommies Patties","Cape Town");
        this.repository.create(supplier);
        this.repository.create(supplier1);
        System.out.println("Size after creating Objects->");
        System.out.println(this.repository.getAll().size());
        System.out.println("-------------------------------");
        Supplier readSupplier = this.repository.read(supplier.getSupID());
        System.out.println("Reading Object into new Object of type Supplier");
        System.out.println(readSupplier.getSupID());
        System.out.println("-----------------------------------");

        Assert.assertNotEquals(supplier1.getSupID(), readSupplier.getSupID());



    }
}