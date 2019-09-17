package ac.za.cput.repositories.inventoryrepository.impl;

import ac.za.cput.domains.inventory.Inventory;
import ac.za.cput.repositories.inventoryrepository.InventoryRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("InventoryInMemory")
public class InventoryRepositoryImpl implements InventoryRepository {

    private static InventoryRepositoryImpl repository = null;
    private Set<Inventory> inventories;

    public InventoryRepositoryImpl()
    {
        this.inventories = new HashSet<>();
    }

    public static InventoryRepositoryImpl getRepository()
    {
        if(repository == null) repository = new InventoryRepositoryImpl();
        return repository;
    }

//    public Inventory findID(String s)
//    {
//        return inventories.stream().filter(p -> p.getInvID().trim().equals(s))
//                .findAny().orElse(null);
//    }

    @Override
    public Set<Inventory> getAll() {
        return inventories;

    }

    @Override
    public Inventory create(Inventory inventory) {
        this.inventories.add(inventory);
        return inventory;
    }

    //// provide implementation

    @Override
    public Inventory update(Inventory inventory) {

        Inventory readInventory = repository.read(inventory.getInvID());
        if(this.inventories.contains(readInventory)){
            this.inventories.remove(readInventory);
            this.inventories.add(inventory);
            return inventory;
        }
        return null;

    }

    @Override
    public void delete(String  inventory) {
        Inventory deleteInventory = read(inventory);
        this.inventories.remove(deleteInventory);

    }

    @Override
    public Inventory read(String inventory) {
        return this.inventories.stream()
                .filter(thisInventories-> thisInventories.getInvID().equalsIgnoreCase(inventory))
                .findAny().orElse(null);
    }




}
