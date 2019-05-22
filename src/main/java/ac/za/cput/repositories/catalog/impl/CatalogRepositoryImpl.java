package ac.za.cput.repositories.catalog.impl;

import ac.za.cput.domains.catalog.Catalog;
import ac.za.cput.repositories.catalog.CatalogRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("CatalogInMemory")
public class CatalogRepositoryImpl implements CatalogRepository {

    private static CatalogRepositoryImpl repository = null;
    private Map<String,Catalog> catalogs;

    private CatalogRepositoryImpl()
    {
        this.catalogs = new HashMap<>();
    }

    public  static CatalogRepositoryImpl getRepository()
    {
        if(repository == null) repository = new CatalogRepositoryImpl();
        return repository;

    }

    @Override
    public Set<Catalog> getAll() {
        Collection<Catalog> catalogs = this.catalogs.values();
        Set<Catalog> set = new HashSet<>();
        set.addAll(catalogs);
        return set;
    }

    @Override
    public Catalog create(Catalog catalog) {
        this.catalogs.put(catalog.getItemID(),catalog);
        return catalog;
    }

    @Override
    public Catalog update(Catalog catalog) {
        this.catalogs.replace(catalog.getItemID(), catalog);
        return this.catalogs.get(catalog.getItemID());
    }

    @Override
    public void delete(String s) {

        this.catalogs.remove(s);

    }

    @Override
    public Catalog read(String s) {
        return this.catalogs.get(s);
    }

    //public Catalog findID(String s)
//    {
//        return this.catalogs.stream().filter(catalog -> catalog.getItemID().equals(s))
//                .findAny().orElse(null);
//
//
//    }


}
