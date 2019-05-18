package ac.za.cput.repositories.receiptrepository.impl;

import ac.za.cput.domains.receipt.Receipt;
import ac.za.cput.repositories.receiptrepository.ReceiptRepository;

import java.util.*;

public class ReceiptRepositoryImpl implements ReceiptRepository {

    private static ReceiptRepositoryImpl repository = null;
    private Map<String,Receipt> receipts;

    private ReceiptRepositoryImpl()
    {
        this.receipts = new HashMap<>();
    }

    public static ReceiptRepositoryImpl getRepository()
    {
        if(repository == null) repository = new ReceiptRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Receipt> getAll() {
        Collection<Receipt> receipts = this.receipts.values();
        Set<Receipt> set = new HashSet<>();
        set.addAll(receipts);
        return set;
    }

    @Override
    public Receipt create(Receipt receipt) {
        this.receipts.put(receipt.getRecID(), receipt);
        return receipt;
    }

    @Override
    public Receipt update(Receipt receipt) {
        this.receipts.replace(receipt.getRecID(), receipt);
        return this.receipts.get(receipt.getRecID());
    }

    @Override
    public void delete(String s) {

        this.receipts.remove(s);
    }

    @Override
    public Receipt read(String s) {
        return this.receipts.get(s);

    }

//    public Receipt findID(String s)
//    {
//        return receipts.stream().filter(p -> p.getRecID().equals(s))
//                .findAny().orElse(null);
//
//
//    }

}
