package ac.za.cput.service.supplier.impl;

import ac.za.cput.domains.supplier.Supplier;
import ac.za.cput.repositories.supplierrepository.SupplierRepository;
import ac.za.cput.repositories.supplierrepository.impl.SupplierRepositoryImpl;
import ac.za.cput.service.supplier.SupplierService;
import org.springframework.stereotype.Service;


import java.util.Set;

@Service("SupplierService")
public class SupplierServiceImpl implements SupplierService {

    private SupplierServiceImpl service = null;
    private SupplierRepository repository;

    private SupplierServiceImpl()
    {
        repository = SupplierRepositoryImpl.getRepository();

    }

    public  SupplierServiceImpl getService()
    {
        if(service == null)return  new SupplierServiceImpl();
        return  service;
    }

    @Override
    public Set<Supplier> getAll() {
        return repository.getAll();
    }

    @Override
    public Supplier create(Supplier type) {
        return repository.create(type);
    }

    @Override
    public Supplier update(Supplier type) {
        return this.repository.update(type);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);

    }

    @Override
    public Supplier read(String s) {
        return this.repository.read(s);
    }
}
