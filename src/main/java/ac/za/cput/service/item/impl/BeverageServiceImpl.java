package ac.za.cput.service.item.impl;

import ac.za.cput.domains.purchase.item.Beverage;
import ac.za.cput.repositories.item.BeverageRepository;
import ac.za.cput.repositories.item.impl.BeverageRepositoryImpl;
import ac.za.cput.service.item.BeverageService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("BeverageService")
public class BeverageServiceImpl implements BeverageService{

   private BeverageServiceImpl service = null;
   private BeverageRepository repository;

    private  BeverageServiceImpl()
    {
        repository = BeverageRepositoryImpl.getRepository();
    }

    public BeverageServiceImpl getService()
    {
        if(service == null) return new BeverageServiceImpl();
        return service;
    }

    @Override
    public Set<Beverage> getAll() {
        return repository.getAll();
    }

    @Override
    public Beverage create(Beverage type) {
        return repository.create(type);
    }

    @Override
    public Beverage update(Beverage type) {
        return this.repository.update(type);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);

    }

    @Override
    public Beverage read(String s) {
        return this.repository.read(s);
    }
}
