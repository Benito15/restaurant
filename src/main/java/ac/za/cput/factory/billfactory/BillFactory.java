package ac.za.cput.factory.billfactory;

import ac.za.cput.domains.bill.Bill;
import ac.za.cput.util.Misc;

import java.util.Date;

public class BillFactory {


    public static Bill getBill(Date dte, String desc, double total)
    {
        return new Bill.Builder().dte(dte)
                .desc(desc)
                .total(total)
                .billID(Misc.generateId())
                .build();


    }

}
