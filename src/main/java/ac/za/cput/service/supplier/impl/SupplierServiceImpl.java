package ac.za.cput.service.supplier.impl;

import ac.za.cput.domains.supplier.Supplier;
import ac.za.cput.repositories.supplierrepository.SupplierRepository;
import ac.za.cput.repositories.supplierrepository.SupplierRepositoryHibernate;
import ac.za.cput.repositories.supplierrepository.impl.SupplierRepositoryImpl;
import ac.za.cput.service.supplier.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("SupplierService")
public class SupplierServiceImpl implements SupplierService {

    private SupplierServiceImpl service = null;
    @Autowired
    private SupplierRepositoryHibernate repository;

    private SupplierServiceImpl()
    {
    }

    public  SupplierServiceImpl getService()
    {
        if(service == null)return  new SupplierServiceImpl();
        return  service;
    }

    @Override
    public Set<Supplier> getAll() {
        return new HashSet<Supplier>((List<Supplier>)repository.findAll());
    }

    @Override
    public Supplier create(Supplier type) {
        return repository.save(type);
    }

    @Override
    public Supplier update(Supplier type) {
        return this.repository.save(type);
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);

    }

    @Override
    public Supplier read(String s) {
        return this.repository.findById(s).orElse(null);
    }
}
