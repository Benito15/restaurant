package ac.za.cput.repositories.inventoryrepository.impl;

import ac.za.cput.domains.inventory.Inventory;
import ac.za.cput.repositories.inventoryrepository.InventoryRepository;

import java.util.HashSet;
import java.util.Set;

public class InventoryRepositoryImpl implements InventoryRepository {

    private static InventoryRepositoryImpl repository = null;
    private Set<Inventory> inventories;

    private InventoryRepositoryImpl()
    {
        this.inventories = new HashSet<>();
    }

    public static InventoryRepository getRepository()
    {
        if(repository == null) repository = new InventoryRepositoryImpl();
        return repository;
    }


    @Override
    public Set<Inventory> getAll() {
        return this.inventories;

    }

    @Override
    public Inventory create(Inventory inventory) {
        this.inventories.add(inventory);
        return inventory;
    }

    //// provide implementation

    @Override
    public Inventory update(Inventory inventory) {
        Inventory updateInv = findID(inventory.getInvID());
        if(updateInv != null)
        {
            this.inventories.remove(updateInv);
            return create(inventory);
        }
        return null;
    }

    @Override
    public void delete(String s) {
        Inventory inventory = findID(s);
        this.inventories.remove(inventory);
    }

    @Override
    public Inventory read(String s) {
        Inventory inventory = findID(s);
        if(inventory.equals(s))
            return inventory;
        return null;
    }


    public Inventory findID(String s)
    {
        return inventories.stream().filter(p -> p.getInvID().equals(s))
                .findAny().orElse(null);
    }
}
