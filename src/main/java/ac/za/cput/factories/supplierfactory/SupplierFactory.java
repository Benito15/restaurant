package ac.za.cput.factories.supplierfactory;

import ac.za.cput.domains.supplier.Supplier;
import ac.za.cput.util.Misc;

public class SupplierFactory {


    public static Supplier getSupplier(String name,String address)
    {
        return new Supplier.Builder().name(name)
                .address(address)
                .supID(Misc.generateId())
                .build();


    }

}
