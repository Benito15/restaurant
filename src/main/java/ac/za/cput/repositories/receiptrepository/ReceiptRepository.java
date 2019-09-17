package ac.za.cput.repositories.receiptrepository;

import ac.za.cput.domains.proofofpayment.receipt.Receipt;
import ac.za.cput.repositories.IRepository;

import java.util.Set;

public interface ReceiptRepository  {


    Receipt create(Receipt receipt);
    Receipt read(Receipt receipt);
    Receipt update(Receipt receipt);
    void delete(Receipt receipt);
    Set<Receipt> getAll();


}
