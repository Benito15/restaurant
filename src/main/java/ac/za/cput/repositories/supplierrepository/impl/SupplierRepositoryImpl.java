package ac.za.cput.repositories.supplierrepository.impl;

import ac.za.cput.domains.supplier.Supplier;
import ac.za.cput.repositories.supplierrepository.SupplierRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("SupplierInMemory")
public class SupplierRepositoryImpl implements SupplierRepository {

    private static SupplierRepositoryImpl repository = null;
    private Set<Supplier> suppliers;

    public SupplierRepositoryImpl()
    {
        this.suppliers = new HashSet<>();
    }

    public static SupplierRepositoryImpl getRepository()
    {
        if(repository == null) repository = new SupplierRepositoryImpl();
        return repository;

    }

    @Override
    public Set<Supplier> getAll() {

        return suppliers;
    }


    @Override
    public Supplier create(Supplier supplier) {
        this.suppliers.add(supplier);
        return supplier;
    }

    @Override
    public Supplier update(Supplier supplier) {
        Supplier deleteSupplier = repository.read(supplier.getSupID());
        if (this.suppliers.contains(deleteSupplier)){
            this.suppliers.remove(deleteSupplier);
            this.suppliers.add(supplier);
            return supplier;

        }
        return null;

    }

    @Override
    public void delete(String s) {

        Supplier toDelete = read(s);
        if (toDelete != null) {
            this.suppliers.remove(toDelete);
        }
    }

    @Override
    public Supplier read(String s) {
        return this.suppliers.stream().
                filter(sup->sup.getSupID().equalsIgnoreCase(s)).findAny().orElse(null);

    }

}
