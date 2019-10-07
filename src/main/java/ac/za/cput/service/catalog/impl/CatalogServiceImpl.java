package ac.za.cput.service.catalog.impl;

import ac.za.cput.domains.catalog.Catalog;
import ac.za.cput.repositories.catalog.CatalogRepository;
import ac.za.cput.repositories.catalog.CatalogRepositoryHibernate;
import ac.za.cput.repositories.catalog.impl.CatalogRepositoryImpl;
import ac.za.cput.service.catalog.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("CatalogService")
public class CatalogServiceImpl implements CatalogService {

    private static CatalogServiceImpl service = null;
    @Autowired
    private CatalogRepositoryHibernate repository;

    private CatalogServiceImpl()
    {


    }

    public static CatalogServiceImpl getService()
    {
        if(service == null)
            return new CatalogServiceImpl();
        return service;
    }

    @Override
    public Set<Catalog> getAll() {
        return new HashSet<Catalog>((List<Catalog>)repository.findAll());
    }

    @Override
    public Catalog create(Catalog type) {
        return this.repository.save(type);

    }

    @Override
    public Catalog update(Catalog type) {
        return  this.repository.save(type);
    }

    @Override
    public void delete(String supplierID, String itemID) {
        Catalog deleteCatalog = read(supplierID, itemID);
        this.repository.delete(deleteCatalog);


    }

    @Override
    public Catalog read(String supplierID, String itemID) {
        return getAll().stream()
                .filter(thisCatalog -> thisCatalog.getItemID().equalsIgnoreCase(supplierID)
                        && thisCatalog.getSupID().equalsIgnoreCase(itemID))
                .findAny().orElse(null);
    }
}
