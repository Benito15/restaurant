package factorytest.suppliertest;

import ac.za.cput.domains.supplier.Supplier;
import ac.za.cput.factory.supplierfactory.SupplierFactory;
import org.junit.Assert;
import org.junit.Test;

public class TestSupplier {

    @Test
    public void supplierTest()
    {
        String name = "OneZone";
        String address = "kaizer Chiefs Square";


        Supplier supplier = SupplierFactory.getSupplier(name, address);
        System.out.println(supplier);
        Assert.assertNotNull(supplier.getSupID());

    }

}
