package ac.za.cput.repositories.receiptrepository.impl;

import ac.za.cput.domains.receipt.Receipt;
import ac.za.cput.repositories.receiptrepository.ReceiptRepository;

import java.util.HashSet;
import java.util.Set;

public class ReceiptRepositoryImpl implements ReceiptRepository {

    private static ReceiptRepository repository = null;
    private Set<Receipt> receipts;

    private ReceiptRepositoryImpl()
    {
        this.receipts = new HashSet<>();
    }
    public static ReceiptRepository getRepository()
    {
        if(repository == null) repository = new ReceiptRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Receipt> getAll() {
        return this.receipts;
    }

    @Override
    public Receipt create(Receipt receipt) {
        this.receipts.add(receipt);
        return receipt;
    }

    @Override
    public Receipt update(Receipt receipt) {
        return null;
    }

    @Override
    public void delete(String s) {
        Receipt receipt = findID(s);
        this.receipts.remove(receipt);
    }

    @Override
    public Receipt read(String s) {
        Receipt receipt = findID(s);
        if(receipt.equals(s))return receipt;
        return null;
    }

    public Receipt findID(String s)
    {
        return receipts.stream().filter(p -> p.getBillID().equals(s))
                .findFirst().orElse(null);


    }

}
