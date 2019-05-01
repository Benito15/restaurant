package ac.za.cput.repositories.supplierrepository.impl;

import ac.za.cput.domains.supplier.Supplier;
import ac.za.cput.repositories.supplierrepository.SupplierRepository;

import java.util.HashSet;
import java.util.Set;

public class SupplierRepositoryImpl implements SupplierRepository {

    private static SupplierRepositoryImpl repository = null;
    private Set <Supplier> suppliers;

    private SupplierRepositoryImpl()
    {
        this.suppliers = new HashSet<>();
    }

    @Override
    public Set<Supplier> getAll() {
        return this.suppliers;
    }


    @Override
    public Supplier create(Supplier supplier) {
        suppliers.add(supplier);
        return supplier;
    }

    @Override
    public Supplier update(Supplier supplier) {
        return null;
    }

    @Override
    public void delete(String s) {
        Supplier supplier = findID(s);
        this.suppliers.remove(supplier);
    }

    @Override
    public Supplier read(String s) {
        Supplier supplier = findID(s);
        if(supplier.equals(s))return supplier;
        return null;
    }



    public Supplier findID(String s)
    {
        return suppliers.stream().filter(p -> p.getSupID().equals(s))
                .findFirst().orElse(null);


    }
}
