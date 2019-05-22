package ac.za.cput.service.employee.impl;

import ac.za.cput.domains.employee.Waiter;
import ac.za.cput.repositories.emprepositories.WaiterRepository;
import ac.za.cput.repositories.emprepositories.impl.WaiterRepositoryImpl;
import ac.za.cput.service.IService;
import ac.za.cput.service.employee.WaiterService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("WaiterService")
public class WaiterServiceImpl implements WaiterService {

    private WaiterServiceImpl service = null;
    private WaiterRepository repository;

    private WaiterServiceImpl()
    {
        repository = WaiterRepositoryImpl.getRepository();
    }

    public WaiterServiceImpl getService()
    {
        if(service == null) return new WaiterServiceImpl();
        return service;


    }


    @Override
    public Set<Waiter> getAll() {
        return repository.getAll();
    }

    @Override
    public Waiter create(Waiter type) {
        return repository.create(type);
    }

    @Override
    public Waiter update(Waiter type) {
        return this.repository.update(type);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);

    }

    @Override
    public Waiter read(String s) {
        return this.repository.read(s);
    }
}
