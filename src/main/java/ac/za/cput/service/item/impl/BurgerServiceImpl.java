package ac.za.cput.service.item.impl;

import ac.za.cput.domains.item.Burger;
import ac.za.cput.repositories.item.BurgerRepository;
import ac.za.cput.repositories.item.impl.BurgerRepositoryImpl;
import ac.za.cput.service.item.BurgerService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("BurgerService")
public class BurgerServiceImpl implements BurgerService {

    private BurgerServiceImpl service = null;
    private BurgerRepository repository;

    private BurgerServiceImpl()
    {
        this.repository = BurgerRepositoryImpl.getRepository();

    }

    public BurgerServiceImpl getService()
    {
        if(service == null) return new BurgerServiceImpl();
        return service;
    }

    @Override
    public Set<Burger> getAll() {
        return repository.getAll();
    }

    @Override
    public Burger create(Burger type) {
        return repository.create(type);
    }

    @Override
    public Burger update(Burger type) {
        return this.repository.update(type);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);

    }

    @Override
    public Burger read(String s) {
        return this.repository.read(s);
    }
}
