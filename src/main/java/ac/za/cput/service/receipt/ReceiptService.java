package ac.za.cput.service.receipt;

import ac.za.cput.domains.proofofpayment.receipt.Receipt;
import ac.za.cput.service.IService;

import java.util.Set;

public interface ReceiptService {
    Receipt create(Receipt receipt);
    Receipt read(Receipt receipt);
    Receipt update(Receipt receipt);
    void delete(Receipt receipt);
    Set<Receipt> getAll();
}
