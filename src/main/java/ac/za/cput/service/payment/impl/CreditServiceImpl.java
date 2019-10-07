package ac.za.cput.service.payment.impl;

import ac.za.cput.domains.payment.Credit;

import ac.za.cput.repositories.paymentrepositories.CreditRepository;
import ac.za.cput.repositories.paymentrepositories.CreditRepositoryHibernate;
import ac.za.cput.repositories.paymentrepositories.impl.CreditRepositoryImpl;

import ac.za.cput.service.payment.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("CreditService")
public class CreditServiceImpl implements CreditService {

    private CreditServiceImpl service = null;
    @Autowired
    private CreditRepositoryHibernate repository;

    private CreditServiceImpl()
    {

    }

    private CreditServiceImpl getService()
    {
        if(service ==null) return new CreditServiceImpl();
        return service;
    }

    @Override
    public Set<Credit> getAll() {
        return new HashSet<Credit>((List<Credit>)repository.findAll());

    }

    @Override
    public Credit create(Credit type) {
        return repository.save(type);
    }

    @Override
    public Credit update(Credit type) {
        return this.repository.save(type);
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);

    }

    @Override
    public Credit read(String s) {
        return this.repository.findById(s).orElse(null);
    }
}
