package ac.za.cput.repositories.supplierrepository.impl;

import ac.za.cput.domains.supplier.Supplier;
import ac.za.cput.repositories.supplierrepository.SupplierRepository;

import java.util.*;

public class SupplierRepositoryImpl implements SupplierRepository {

    private static SupplierRepositoryImpl repository = null;
    private Map<String,Supplier> suppliers;

    public SupplierRepositoryImpl()
    {
        this.suppliers = new HashMap<>();
    }

    public static SupplierRepositoryImpl getRepository()
    {
        if(repository == null) repository = new SupplierRepositoryImpl();
        return repository;

    }

    @Override
    public Set<Supplier> getAll() {
        Collection<Supplier> suppliers = this.suppliers.values();
        Set<Supplier> set = new HashSet<>();
        set.addAll(suppliers);
        return set;
    }


    @Override
    public Supplier create(Supplier supplier) {
        suppliers.put(supplier.getSupID(), supplier);
        return supplier;
    }

    @Override
    public Supplier update(Supplier supplier) {
        this.suppliers.replace(supplier.getSupID(), supplier);
        return this.suppliers.get(supplier.getSupID());

    }

    @Override
    public void delete(String s) {

        this.suppliers.remove(s);
    }

    @Override
    public Supplier read(String s) {
        return this.suppliers.get(s);

    }


//    public Supplier findID(String s)
//    {
//        return suppliers.stream().filter(p -> p.getSupID().equals(s))
//                .findFirst().orElse(null);
//
//
//    }
}
