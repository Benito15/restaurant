package ac.za.cput.repositories.billrepository.impl;

import ac.za.cput.domains.bill.Bill;
import ac.za.cput.repositories.billrepository.BillRepository;

import java.util.HashSet;
import java.util.Set;


public class BillRepositoryImpl implements BillRepository {

    private static BillRepositoryImpl repository = null;
    private Set<Bill> bills;

    private BillRepositoryImpl()
    {
        this.bills = new HashSet<>();

    }

    public static BillRepositoryImpl getRepository()
    {
        if(repository == null) repository = new BillRepositoryImpl();
        return repository;

    }

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
        Bill updateBill = findID(bill.getBillID());
        if(updateBill != null)
        {
            this.bills.remove(updateBill);
            return create(bill);

        }
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
        else return null;
    }

    public Bill findID(String s)
    {
        return bills.stream().filter(p -> p.getBillID().equals(s))
                .findFirst().orElse(null);


    }

}
