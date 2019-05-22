package ac.za.cput.service.inventory;

import ac.za.cput.domains.inventory.Inventory;
import ac.za.cput.service.IService;

import java.util.Set;

public interface InventoryService extends IService<Inventory,String> {
    Set<Inventory> getAll();
}
