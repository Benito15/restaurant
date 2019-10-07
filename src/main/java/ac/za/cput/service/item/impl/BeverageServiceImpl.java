package ac.za.cput.service.item.impl;

import ac.za.cput.domains.purchase.item.Beverage;
import ac.za.cput.repositories.item.BeverageRepository;
import ac.za.cput.repositories.item.BeverageRepositoryHibernate;
import ac.za.cput.repositories.item.impl.BeverageRepositoryImpl;
import ac.za.cput.service.item.BeverageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("BeverageService")
public class BeverageServiceImpl implements BeverageService{

   private BeverageServiceImpl service = null;
   @Autowired
   private BeverageRepositoryHibernate repository;

    private  BeverageServiceImpl()
    {

    }

    public BeverageServiceImpl getService()
    {
        if(service == null) return new BeverageServiceImpl();
        return service;
    }

    @Override
    public Set<Beverage> getAll() {
        List<Beverage>list =(List<Beverage>) repository.findAll();
        return new HashSet<>(list);
    }

    @Override
    public Beverage create(Beverage type) {
        return repository.save(type);
    }

    @Override
    public Beverage update(Beverage type) {
        return this.repository.save(type);
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);

    }

    @Override
    public Beverage read(String s) {
        return this.repository.findById(s).orElse(null);
    }
}
