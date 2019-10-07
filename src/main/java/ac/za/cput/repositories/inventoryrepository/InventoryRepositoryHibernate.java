package ac.za.cput.repositories.inventoryrepository;

import ac.za.cput.domains.inventory.Inventory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepositoryHibernate extends CrudRepository <Inventory, String> {
}
