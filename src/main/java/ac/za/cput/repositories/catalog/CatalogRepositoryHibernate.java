package ac.za.cput.repositories.catalog;

import ac.za.cput.domains.catalog.Catalog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogRepositoryHibernate extends CrudRepository<Catalog, String> {
}
