package ac.za.cput.service.supplier;

import ac.za.cput.domains.supplier.Supplier;
import ac.za.cput.service.IService;

import java.util.Set;

public interface SupplierService extends IService<Supplier, String> {
    Set<Supplier> getAll();
}
