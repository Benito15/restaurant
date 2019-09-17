package ac.za.cput.repositories.inventoryrepository;

import ac.za.cput.domains.inventory.Inventory;
import ac.za.cput.repositories.IRepository;

import java.util.Set;

public interface InventoryRepository extends IRepository<Inventory,String> {



    Set<Inventory> getAll();

}
