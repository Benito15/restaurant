package ac.za.cput.repositories.receiptrepository;

import ac.za.cput.domains.receipt.Receipt;
import ac.za.cput.repositories.IRepository;

import java.util.Set;

public interface ReceiptRepository extends IRepository<Receipt,String> {


    Set<Receipt> getAll();

}
