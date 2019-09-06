package ac.za.cput.service.bill;

import ac.za.cput.domains.proofofpayment.bill.Bill;
import ac.za.cput.service.IService;

import java.util.Set;

public interface BillService extends IService<Bill, String> {
    Set<Bill> getAll();
}
