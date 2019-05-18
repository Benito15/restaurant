package ac.za.cput.factory.receiptfactory;

import ac.za.cput.domains.receipt.Receipt;
import ac.za.cput.util.Misc;

import java.util.Date;

public class ReceiptFactory {


    public static Receipt getReceipt(Date dte, String desc, double total)
    {
        return new Receipt.Builder().dte(dte)
                .desc(desc)
                .total(total)
                .billID(Misc.generateId())
                .recID(Misc.generateId())
                .build();


    }
}
