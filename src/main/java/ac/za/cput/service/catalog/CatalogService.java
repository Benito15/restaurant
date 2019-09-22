package ac.za.cput.service.catalog;

import ac.za.cput.domains.catalog.Catalog;
import ac.za.cput.service.IService;

import java.util.Set;

public interface CatalogService  {
    Catalog create(Catalog catalog);
    Catalog read(String supplierID, String itemID);
    Catalog update(Catalog catalog);
    void delete(String supplierID, String itemID);
    Set<Catalog> getAll();

}
