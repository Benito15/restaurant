package ac.za.cput.service.bill;

import ac.za.cput.domains.proofofpayment.bill.Bill;
import ac.za.cput.service.IService;

import java.util.Set;

public interface BillService  {
    Bill create(Bill bill);
    Bill read(Bill bill);
    Bill update(Bill bill);
    void delete(Bill bill);
    Set<Bill> getAll();
}
