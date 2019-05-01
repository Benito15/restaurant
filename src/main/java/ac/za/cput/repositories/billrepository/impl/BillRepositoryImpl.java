package ac.za.cput.repositories.billrepository.impl;

import ac.za.cput.domains.bill.Bill;
import ac.za.cput.repositories.billrepository.BillRepository;

import java.util.Set;


public class BillRepositoryImpl implements BillRepository {

    private static BillRepositoryImpl repository = null;
    private Set<Bill> bills;

    @Override
    public Set<Bill> getAll() {
        return this.bills;
    }

    @Override
    public Bill create(Bill bill) {
        this.bills.add(bill);
        return bill;
    }

    @Override
    public Bill update(Bill bill) {
        return null;
    }

    @Override
    public void delete(String s) {
        Bill bills = findID(s);
        this.bills.remove(s);
    }

    @Override
    public Bill read(String s) {
        Bill bill = findID(s);
        if(bills.equals(s))
            return bill;
        return null;
    }

    public Bill findID(String s)
    {
        return bills.stream().filter(p -> p.getBillID().equals(s))
                .findFirst().orElse(null);


    }

}
