package ac.za.cput.service.catalog.impl;

import ac.za.cput.domains.catalog.Catalog;
import ac.za.cput.repositories.catalog.CatalogRepository;
import ac.za.cput.repositories.catalog.impl.CatalogRepositoryImpl;
import ac.za.cput.service.catalog.CatalogService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("CatalogService")
public class CatalogServiceImpl implements CatalogService {

    private static CatalogServiceImpl service = null;
    private CatalogRepository repository;

    private CatalogServiceImpl()
    {
        repository = CatalogRepositoryImpl.getRepository();

    }

    public static CatalogServiceImpl getService()
    {
        if(service == null)
            return new CatalogServiceImpl();
        return service;
    }

    @Override
    public Set<Catalog> getAll() {
        return repository.getAll();
    }

    @Override
    public Catalog create(Catalog type) {
        return this.repository.create(type);

    }

    @Override
    public Catalog update(Catalog type) {
        return  this.repository.update(type);
    }

    @Override
    public void delete(String supplierID, String itemID) {
        this.repository.delete(supplierID, itemID);
    }

    @Override
    public Catalog read(String supplierID, String itemID) {
        return this.repository.read(supplierID, itemID);
    }
}
