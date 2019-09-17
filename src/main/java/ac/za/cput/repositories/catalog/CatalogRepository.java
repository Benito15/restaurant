package ac.za.cput.repositories.catalog;

import ac.za.cput.domains.catalog.Catalog;
import ac.za.cput.repositories.IRepository;

import java.util.Set;

public interface CatalogRepository  {


    Catalog create(Catalog catalog);
    Catalog read(Catalog catalog);
    Catalog update(Catalog catalog);
    void delete(Catalog catalog);
    Set<Catalog> getAll();



}
