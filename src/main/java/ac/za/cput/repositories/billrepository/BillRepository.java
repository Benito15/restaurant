package ac.za.cput.repositories.billrepository;

import ac.za.cput.domains.proofofpayment.bill.Bill;
import ac.za.cput.repositories.IRepository;

import java.util.Set;

public interface BillRepository {

    Bill create(Bill bill);
    Bill read(Bill bill);
    Bill update(Bill bill);
    void delete(Bill bill);
    Set<Bill> getAll();


}
