package ac.za.cput.repositories.catalog;

import ac.za.cput.domains.catalog.Catalog;
import ac.za.cput.repositories.IRepository;

import java.util.Set;

public interface CatalogRepository extends IRepository<Catalog,String> {

    Set<Catalog> getAll();



}
