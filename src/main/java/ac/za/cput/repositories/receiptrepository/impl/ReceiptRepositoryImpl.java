package ac.za.cput.repositories.receiptrepository.impl;

import ac.za.cput.domains.proofofpayment.receipt.Receipt;
import ac.za.cput.repositories.receiptrepository.ReceiptRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("ReceiptInMemory")
public class ReceiptRepositoryImpl implements ReceiptRepository {

    private static ReceiptRepositoryImpl repository = null;
    private Set<Receipt> receipts;

    private ReceiptRepositoryImpl()
    {
        this.receipts = new HashSet<>();
    }

    public static ReceiptRepositoryImpl getRepository()
    {
        if(repository == null) repository = new ReceiptRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Receipt> getAll() {

        return receipts;
    }

    @Override
    public Receipt create(Receipt receipt) {
        this.receipts.add(receipt);
        return receipt;
    }

    @Override
    public Receipt update(Receipt receipt) {
        Receipt readBill = repository.read(receipt);
        if (this.receipts.contains(readBill)){
            this.receipts.remove(readBill);
            this.receipts.add(receipt);
            return receipt;

        }
        return null;
    }

    @Override
    public void delete(Receipt receipt) {
        Receipt deleteReceipt = read(receipt);
        this.receipts.remove(deleteReceipt);
    }

    @Override
    public Receipt read(Receipt receipt) {
        return this.receipts.stream()
                .filter(thisReceipt-> thisReceipt.getRecID().equalsIgnoreCase(receipt.getRecID())
                        && thisReceipt.getBillID().equalsIgnoreCase(receipt.getBillID()))
                .findAny().orElse(null);
    }
    }

//



