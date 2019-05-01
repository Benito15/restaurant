package ac.za.cput.repositories.supplierrepository;

import ac.za.cput.domains.supplier.Supplier;
import ac.za.cput.repositories.IRepository;

import java.util.Set;

public interface SupplierRepository extends IRepository<Supplier,String> {

    Set<Supplier> getAll();

}
