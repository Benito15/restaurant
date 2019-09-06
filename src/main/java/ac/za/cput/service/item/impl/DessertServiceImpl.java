package ac.za.cput.service.item.impl;

import ac.za.cput.domains.purchase.item.Dessert;
import ac.za.cput.repositories.item.DessertRepository;
import ac.za.cput.repositories.item.impl.DessertRepositoryImpl;
import ac.za.cput.service.item.DessertService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("DessertService")
public class DessertServiceImpl implements DessertService {

   private DessertServiceImpl service = null;
   private DessertRepository repository;

   private DessertServiceImpl()
   {
       repository = DessertRepositoryImpl.getRepository();
   }

    public DessertServiceImpl getService() {
        if(service == null) return new DessertServiceImpl();
        return service;
    }

    @Override
    public Set<Dessert> getAll() {
        return repository.getAll();
    }

    @Override
    public Dessert create(Dessert type) {
        return repository.create(type);
    }

    @Override
    public Dessert update(Dessert type) {
        return this.repository.update(type);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);

    }

    @Override
    public Dessert read(String s) {
        return this.repository.read(s);
    }
}
