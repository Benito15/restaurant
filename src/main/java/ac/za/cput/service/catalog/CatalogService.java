package ac.za.cput.service.catalog;

import ac.za.cput.domains.catalog.Catalog;
import ac.za.cput.service.IService;

import java.util.Set;

public interface CatalogService extends IService<Catalog, String> {
    Set<Catalog> getAll();

}
