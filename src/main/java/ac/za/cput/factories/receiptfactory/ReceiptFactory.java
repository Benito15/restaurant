package ac.za.cput.factories.receiptfactory;

import ac.za.cput.domains.receipt.Receipt;
import ac.za.cput.util.Misc;

public class ReceiptFactory {

    private String recID, dte, desc;
    private double total;

    public static Receipt getReceipt(String dte, String desc, double total)
    {
        return new Receipt.Builder().dte(dte)
                .desc(desc)
                .total(total)
                .recID(Misc.generateId())
                .build();


    }
}
