package ac.za.cput.service.payment.impl;

import ac.za.cput.domains.payment.Credit;

import ac.za.cput.repositories.paymentrepositories.CreditRepository;
import ac.za.cput.repositories.paymentrepositories.impl.CreditRepositoryImpl;

import ac.za.cput.service.payment.CreditService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("CreditService")
public class CreditServiceImpl implements CreditService {

    private CreditServiceImpl service = null;
    private CreditRepository repository;

    private CreditServiceImpl()
    {
        repository = CreditRepositoryImpl.getRepository();
    }

    private CreditServiceImpl getService()
    {
        if(service ==null) return new CreditServiceImpl();
        return service;
    }

    @Override
    public Set<Credit> getAll() {
        return repository.getAll();
    }

    @Override
    public Credit create(Credit type) {
        return repository.create(type);
    }

    @Override
    public Credit update(Credit type) {
        return this.repository.update(type);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);

    }

    @Override
    public Credit read(String s) {
        return this.repository.read(s);
    }
}
