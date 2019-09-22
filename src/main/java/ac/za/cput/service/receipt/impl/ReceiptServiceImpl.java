package ac.za.cput.service.receipt.impl;

import ac.za.cput.domains.proofofpayment.receipt.Receipt;
import ac.za.cput.repositories.receiptrepository.ReceiptRepository;
import ac.za.cput.repositories.receiptrepository.impl.ReceiptRepositoryImpl;
import ac.za.cput.service.receipt.ReceiptService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("ReceiptService")
public class ReceiptServiceImpl implements ReceiptService {

    private static ReceiptServiceImpl service = null;
    private ReceiptRepository repository;

    private ReceiptServiceImpl()
    {
        repository = ReceiptRepositoryImpl.getRepository();
    }

    public  static ReceiptServiceImpl getService()
    {
        if(service == null)return  new ReceiptServiceImpl();
        return  service;
    }


    @Override
    public Set<Receipt> getAll() {
        return repository.getAll();
    }

    @Override
    public Receipt create(Receipt type) {
        return repository.create(type);

    }

    @Override
    public Receipt update(Receipt type) {
        return this.repository.update(type);
    }

    @Override
    public void delete(Receipt receipt) {
        this.repository.delete(receipt);

    }

    @Override
    public Receipt read(Receipt receipt) {
        return this.repository.read(receipt);
    }
}
