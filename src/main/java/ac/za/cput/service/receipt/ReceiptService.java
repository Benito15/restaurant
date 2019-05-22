package ac.za.cput.service.receipt;

import ac.za.cput.domains.receipt.Receipt;
import ac.za.cput.service.IService;

import java.util.Set;

public interface ReceiptService extends IService<Receipt,String> {
    Set<Receipt> getAll();
}
