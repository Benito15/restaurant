package ac.za.cput.repositories.catalog;

import ac.za.cput.domains.catalog.Catalog;
import ac.za.cput.repositories.IRepository;

import java.util.Set;

public interface CatalogRepository  {


    Catalog create(Catalog catalog);
    Catalog read(String supplierID, String itemID);
    Catalog update(Catalog catalog);
    void delete(String supplierID, String itemID);
    Set<Catalog> getAll();



}
