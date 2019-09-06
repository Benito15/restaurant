package ac.za.cput.service.bill.impl;

import ac.za.cput.domains.proofofpayment.bill.Bill;
import ac.za.cput.repositories.billrepository.BillRepository;
import ac.za.cput.repositories.billrepository.impl.BillRepositoryImpl;
import ac.za.cput.service.bill.BillService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service("BillServiceImpl")
public class BillServiceImpl implements BillService {

    private BillServiceImpl service = null;
    private BillRepository repository;

    private BillServiceImpl()
    {
        repository = BillRepositoryImpl.getRepository();
    }

    public BillServiceImpl getService()
    {
        if(service == null) return new BillServiceImpl();
        return service;
    }

    @Override
    public Set<Bill> getAll() {
        return repository.getAll();
    }

    @Override
    public Bill create(Bill type) {
        return repository.create(type);
    }

    @Override
    public Bill update(Bill type) {
        return this.repository.update(type);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);

    }

    @Override
    public Bill read(String s) {
        return this.repository.read(s);
    }
}
