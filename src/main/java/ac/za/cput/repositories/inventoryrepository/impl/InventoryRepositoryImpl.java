package ac.za.cput.repositories.inventoryrepository.impl;

import ac.za.cput.domains.inventory.Inventory;
import ac.za.cput.repositories.inventoryrepository.InventoryRepository;

import java.util.*;

public class InventoryRepositoryImpl implements InventoryRepository {

    private static InventoryRepositoryImpl repository = null;
    private Map<String,Inventory> inventories;

    public InventoryRepositoryImpl()
    {
        this.inventories = new HashMap<>();
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
        Collection<Inventory> inventories = this.inventories.values();
        Set<Inventory> set = new HashSet<>();
        set.addAll(inventories);
        return set;

    }

    @Override
    public Inventory create(Inventory inventory) {
        this.inventories.put(inventory.getInvID(), inventory);
        return inventory;
    }

    //// provide implementation

    @Override
    public Inventory update(Inventory inventory) {
        this.inventories.replace(inventory.getInvID(), inventory);
        return this.inventories.get(inventory.getInvID());

    }

    @Override
    public void delete(String s) {

        this.inventories.remove(s);
    }

    @Override
    public Inventory read(String s) {
        return this.inventories.get(s);

    }




}
