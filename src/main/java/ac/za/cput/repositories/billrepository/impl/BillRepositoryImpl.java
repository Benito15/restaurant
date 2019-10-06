package ac.za.cput.repositories.billrepository.impl;

import ac.za.cput.domains.proofofpayment.bill.Bill;
import ac.za.cput.repositories.billrepository.BillRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("BillinMemory")
public class BillRepositoryImpl implements BillRepository {

    private static BillRepositoryImpl repository = null;
    private Set<Bill> bills;

    public BillRepositoryImpl()
    {
        this.bills = new HashSet<>();

    }

    public static BillRepositoryImpl getRepository()
    {
        if(repository == null) repository = new BillRepositoryImpl();
        return repository;

    }

    @Override
    public Set<Bill> getAll()
    {
       return bills;
    }

    @Override
    public Bill create(Bill bill) {
        this.bills.add(bill);
        return bill;
    }

    @Override
    public Bill update(Bill bill) {
      Bill readBill = repository.read(bill);
      if (this.bills.contains(readBill)){
          this.bills.remove(readBill);
          this.bills.add(bill);
          return bill;

      }
        return null;
      }

    @Override
    public void delete(Bill bill) {
       Bill deleteBill = read(bill);
       this.bills.remove(deleteBill);

    }



    @Override
    public Bill read(Bill bill) {
        return this.bills.stream()
            .filter(thisBill -> thisBill.getBillID().equalsIgnoreCase(bill.getBillID())
            && thisBill.getOrderID().equalsIgnoreCase(bill.getOrderID()))
            .findAny().orElse(null);
    }


}
