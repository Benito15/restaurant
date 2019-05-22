package ac.za.cput.servicetest.supplier;

import ac.za.cput.domains.supplier.Supplier;
import ac.za.cput.factory.supplierfactory.SupplierFactory;
import ac.za.cput.service.supplier.impl.SupplierServiceImpl;
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
public class SupplierServiceImplTest {


    @Autowired
    private SupplierServiceImpl service;




    @Test
    public void create() {
        Supplier supplier = SupplierFactory.getSupplier("ZEEEE", "Cape Town");
        service.create(supplier);
        System.out.println(service.getAll());
        Assert.assertTrue(this.service.getAll().size()>0);
    }

    @Test
    public void update() {
        String newAddress  = "Durban";
        Supplier supplier = SupplierFactory.getSupplier("ZEEEE", "Cape Town");
        service.create(supplier);
        Supplier updateSupplier = SupplierFactory.getSupplier(supplier.getName(), newAddress);
        this.service.update(updateSupplier);
        Assert.assertTrue(updateSupplier.getAddress().contains(newAddress));

    }

    @Test
    public void delete() {
    }

    @Test
    public void read() {
    }
}