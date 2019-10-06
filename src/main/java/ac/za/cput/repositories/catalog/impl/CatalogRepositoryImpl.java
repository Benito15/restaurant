package ac.za.cput.repositories.catalog.impl;

import ac.za.cput.domains.catalog.Catalog;
import ac.za.cput.repositories.catalog.CatalogRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("CatalogInMemory")
public class CatalogRepositoryImpl implements CatalogRepository {

    private static CatalogRepository repository = null;
    private Set<Catalog> catalogs;

    public CatalogRepositoryImpl() {
        this.catalogs = new HashSet<>();
    }

    public static CatalogRepository getRepository() {
        if (repository == null) repository = new CatalogRepositoryImpl();
        return repository;

    }

    @Override
    public Set<Catalog> getAll() {
        return catalogs;
    }

    @Override
    public Catalog create(Catalog catalog) {
        this.catalogs.add(catalog);
        return catalog;
    }

    @Override
    public Catalog update(Catalog catalog) {
        Catalog readCatalog = repository.read(catalog.getItemID(), catalog.getSupID());
        if (this.catalogs.contains(readCatalog)) {
            this.catalogs.remove(readCatalog);
            this.catalogs.add(catalog);
            return catalog;
        }
        return null;
    }

    @Override
    public void delete(String supplierID, String itemID) {
        Catalog deleteCatalog = read(supplierID, itemID);
        this.catalogs.remove(deleteCatalog);


    }

    @Override
    public Catalog read(String supplierID, String itemID) {
        return this.catalogs.stream()
                .filter(thisCatalog -> thisCatalog.getItemID().equalsIgnoreCase(supplierID)
                        && thisCatalog.getSupID().equalsIgnoreCase(itemID))
                .findAny().orElse(null);
    }

}
