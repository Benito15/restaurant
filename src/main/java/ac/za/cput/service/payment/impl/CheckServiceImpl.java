package ac.za.cput.service.payment.impl;

import ac.za.cput.domains.proofofpayment.payment.Check;
import ac.za.cput.repositories.paymentrepositories.CheckRepository;
import ac.za.cput.repositories.paymentrepositories.impl.CheckRepositoryImpl;
import ac.za.cput.service.payment.CheckService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("Check")
public class CheckServiceImpl implements CheckService {

    private CheckServiceImpl service = null;
    private CheckRepository repository;

    private  CheckServiceImpl()
    {
        repository = CheckRepositoryImpl.getRepository();
    }

    public  CheckServiceImpl getService()
    {
        if(service ==null)
            return new CheckServiceImpl();
        return service;
    }

    @Override
    public Set<Check> getAll() {
        return repository.getAll();
    }

    @Override
    public Check create(Check type) {
        return repository.create(type);
    }

    @Override
    public Check update(Check type) {
        return this.repository.update(type);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);

    }

    @Override
    public Check read(String s) {
        return this.repository.read(s);
    }
}
