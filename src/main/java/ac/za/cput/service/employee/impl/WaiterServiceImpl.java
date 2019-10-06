package ac.za.cput.service.employee.impl;

import ac.za.cput.domains.employee.Employee;
import ac.za.cput.domains.employee.Waiter;
import ac.za.cput.repositories.emprepositories.WaiterRepositoryHibernate;
import ac.za.cput.service.employee.WaiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("WaiterService")
public class WaiterServiceImpl implements WaiterService {

    private WaiterServiceImpl service = null;
    @Autowired
    private WaiterRepositoryHibernate repository;

    public WaiterServiceImpl()
    {

    }

    public WaiterServiceImpl getService()
    {
        if(service == null) return new WaiterServiceImpl();
        return service;


    }


    @Override
    public Set<Waiter> getAll() {
      List<Waiter>list =(List<Waiter>) repository.findAll();
      return new HashSet<>(list);
    }

    @Override
    public Waiter create(Waiter type) {
        return repository.save(type);
    }

    @Override
    public Waiter update(Waiter type) {
        return this.repository.save(type);
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);

    }

    @Override
    public Waiter read(String s) {
        return this.repository.findById(s).orElse(null);
    }
}
