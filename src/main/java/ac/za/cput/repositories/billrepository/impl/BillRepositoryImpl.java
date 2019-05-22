package ac.za.cput.repositories.billrepository.impl;

import ac.za.cput.domains.bill.Bill;
import ac.za.cput.repositories.billrepository.BillRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("BillinMemory")
public class BillRepositoryImpl implements BillRepository {

    private static BillRepositoryImpl repository = null;
    private Map<String,Bill> bills;

    private BillRepositoryImpl()
    {
        this.bills = new HashMap<>();

    }

    public static BillRepositoryImpl getRepository()
    {
        if(repository == null) repository = new BillRepositoryImpl();
        return repository;

    }

    @Override
    public Set<Bill> getAll()
    {
        Collection<Bill>bills = this.bills.values();
        Set<Bill>set = new HashSet<>();
        set.addAll(bills);
        return set;
    }

    @Override
    public Bill create(Bill bill) {
        this.bills.put(bill.getBillID(),bill);
        return bill;
    }

    @Override
    public Bill update(Bill bill) {
       this.bills.replace(bill.getBillID(),bill);
       return this.bills.get(bill.getBillID());

    }

    @Override
    public void delete(String s) {

        this.bills.remove(s);
    }

    @Override
    public Bill read(String s) {
      return this.bills.get(s);
    }


}
