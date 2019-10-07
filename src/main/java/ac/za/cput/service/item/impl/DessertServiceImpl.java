package ac.za.cput.service.item.impl;

import ac.za.cput.domains.purchase.item.Dessert;
import ac.za.cput.repositories.item.DessertRepository;
import ac.za.cput.repositories.item.DessertRepositoryHibernate;
import ac.za.cput.repositories.item.impl.DessertRepositoryImpl;
import ac.za.cput.service.item.DessertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("DessertService")
public class DessertServiceImpl implements DessertService {

   private DessertServiceImpl service = null;
   @Autowired
   private DessertRepositoryHibernate repository;

   private DessertServiceImpl()
   {

   }

    public DessertServiceImpl getService() {
        if(service == null) return new DessertServiceImpl();
        return service;
    }

    @Override
    public Set<Dessert> getAll() {
        List<Dessert> list =(List<Dessert>) repository.findAll();
        return new HashSet<>(list);
    }

    @Override
    public Dessert create(Dessert type) {
        return repository.save(type);
    }

    @Override
    public Dessert update(Dessert type) {
        return this.repository.save(type);
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);

    }

    @Override
    public Dessert read(String s) {
        return this.repository.findById(s).orElse(null);
    }
}
