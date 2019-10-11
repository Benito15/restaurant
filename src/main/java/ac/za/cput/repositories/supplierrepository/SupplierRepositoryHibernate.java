package ac.za.cput.repositories.supplierrepository;

import ac.za.cput.domains.supplier.Supplier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepositoryHibernate extends CrudRepository<Supplier, String> {
}
