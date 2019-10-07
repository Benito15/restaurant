package ac.za.cput.service.inventory.impl;

import ac.za.cput.domains.inventory.Inventory;
import ac.za.cput.repositories.inventoryrepository.InventoryRepository;
import ac.za.cput.repositories.inventoryrepository.InventoryRepositoryHibernate;
import ac.za.cput.repositories.inventoryrepository.impl.InventoryRepositoryImpl;
import ac.za.cput.service.inventory.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("InventoryService")
public class InventoryServiceImpl implements InventoryService {

    private InventoryServiceImpl service = null;
    @Autowired
    private InventoryRepositoryHibernate repository;

    private InventoryServiceImpl()
    {

    }

    public  InventoryServiceImpl getService()
    {
        if(service == null)return  new InventoryServiceImpl();
        return  service;
    }

    @Override
    public Set<Inventory> getAll() {
        return new HashSet<Inventory>((List<Inventory>)repository.findAll());

    }

    @Override
    public Inventory create(Inventory type) {
        return repository.save(type);
    }

    @Override
    public Inventory update(Inventory type) {
        return this.repository.save(type);
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);
    }

    @Override
    public Inventory read(String s) {
        return this.repository.findById(s).orElse(null);
    }
}
