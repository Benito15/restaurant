package ac.za.cput.service.item.impl;

import ac.za.cput.domains.purchase.item.Burger;
import ac.za.cput.repositories.item.BurgerRepository;
import ac.za.cput.repositories.item.BurgerRepositoryHibernate;
import ac.za.cput.repositories.item.impl.BurgerRepositoryImpl;
import ac.za.cput.service.item.BurgerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("BurgerService")
public class BurgerServiceImpl implements BurgerService {

    private BurgerServiceImpl service = null;
    @Autowired
    private BurgerRepositoryHibernate repository;

    private BurgerServiceImpl()
    {


    }

    public BurgerServiceImpl getService()
    {
        if(service == null) return new BurgerServiceImpl();
        return service;
    }

    @Override
    public Set<Burger> getAll() {
        List<Burger>list =(List<Burger>) repository.findAll();
        return new HashSet<>(list);    }

    @Override
    public Burger create(Burger type) {
        return repository.save(type);
    }

    @Override
    public Burger update(Burger type) {
        return this.repository.save(type);
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);

    }

    @Override
    public Burger read(String s) {
        return this.repository.findById(s).orElse(null);
    }
}
