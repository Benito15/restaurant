package ac.za.cput.service.payment.impl;

import ac.za.cput.domains.payment.Check;
import ac.za.cput.repositories.paymentrepositories.CheckRepository;
import ac.za.cput.repositories.paymentrepositories.CheckRepositoryHibernate;
import ac.za.cput.repositories.paymentrepositories.impl.CheckRepositoryImpl;
import ac.za.cput.service.payment.CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("Check")
public class CheckServiceImpl implements CheckService {

    private CheckServiceImpl service = null;
    @Autowired
    private CheckRepositoryHibernate repository;

    private  CheckServiceImpl()
    {

    }

    public  CheckServiceImpl getService()
    {
        if(service ==null)
            return new CheckServiceImpl();
        return service;
    }

    @Override
    public Set<Check> getAll() {
        return new HashSet<Check>((List<Check>)repository.findAll());
    }

    @Override
    public Check create(Check type) {
        return repository.save(type);
    }

    @Override
    public Check update(Check type) {
        return this.repository.save(type);
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);

    }

    @Override
    public Check read(String s) {
        return this.repository.findById(s).orElse(null);
    }
}
