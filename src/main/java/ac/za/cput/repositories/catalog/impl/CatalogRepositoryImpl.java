package ac.za.cput.repositories.catalog.impl;

import ac.za.cput.domains.catalog.Catalog;
import ac.za.cput.repositories.catalog.CatalogRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("CatalogInMemory")
public class CatalogRepositoryImpl implements CatalogRepository {

    private static CatalogRepositoryImpl repository = null;
    private Set<Catalog> catalogs;

    private CatalogRepositoryImpl() {
        this.catalogs = new HashSet<>();
    }

    public static CatalogRepositoryImpl getRepository() {
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
        Catalog readCatalog = repository.read(catalog);
        if (this.catalogs.contains(readCatalog)) {
            this.catalogs.remove(readCatalog);
            this.catalogs.add(catalog);
            return catalog;
        }
        return null;
    }

    @Override
    public void delete(Catalog catalog) {
        Catalog deleteCatalog = read(catalog);
        this.catalogs.remove(deleteCatalog);


    }

    @Override
    public Catalog read(Catalog catalog) {
        return this.catalogs.stream()
                .filter(thisCatalog -> thisCatalog.getItemID().equalsIgnoreCase(catalog.getItemID())
                        && thisCatalog.getSupID().equalsIgnoreCase(catalog.getSupID()))
                .findAny().orElse(null);
    }

}
