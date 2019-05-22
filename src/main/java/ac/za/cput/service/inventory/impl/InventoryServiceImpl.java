package ac.za.cput.service.inventory.impl;

import ac.za.cput.domains.inventory.Inventory;
import ac.za.cput.repositories.inventoryrepository.InventoryRepository;
import ac.za.cput.repositories.inventoryrepository.impl.InventoryRepositoryImpl;
import ac.za.cput.service.inventory.InventoryService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("InventoryService")
public class InventoryServiceImpl implements InventoryService {

    private InventoryServiceImpl service = null;
    private InventoryRepository repository;

    private InventoryServiceImpl()
    {
        repository = InventoryRepositoryImpl.getRepository();
    }

    public  InventoryServiceImpl getService()
    {
        if(service == null)return  new InventoryServiceImpl();
        return  service;
    }

    @Override
    public Set<Inventory> getAll() {
        return repository.getAll();

    }

    @Override
    public Inventory create(Inventory type) {
        return repository.create(type);
    }

    @Override
    public Inventory update(Inventory type) {
        return this.repository.update(type);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Inventory read(String s) {
        return this.repository.read(s);
    }
}
