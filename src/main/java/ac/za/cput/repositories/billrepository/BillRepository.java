package ac.za.cput.repositories.billrepository;

import ac.za.cput.domains.bill.Bill;
import ac.za.cput.repositories.IRepository;

import java.util.Set;

public interface BillRepository extends IRepository <Bill,String> {

    Set<Bill> getAll();

}
