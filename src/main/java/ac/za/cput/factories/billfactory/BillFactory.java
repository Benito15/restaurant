package ac.za.cput.factories.billfactory;

import ac.za.cput.domains.bill.Bill;
import ac.za.cput.util.Misc;

public class BillFactory {


    public static Bill getBill(String dte, String desc, double total)
    {
        return new Bill.Builder().dte(dte)
                .desc(desc)
                .total(total)
                .billID(Misc.generateId())
                .build();


    }

}
