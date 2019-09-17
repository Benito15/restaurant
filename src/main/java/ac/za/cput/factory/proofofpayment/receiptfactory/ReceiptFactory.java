package ac.za.cput.factory.proofofpayment.receiptfactory;

import ac.za.cput.domains.proofofpayment.receipt.Receipt;
import ac.za.cput.util.Misc;

import java.util.Date;

public class ReceiptFactory {


    public static Receipt getReceipt(String billID,Date dte, String desc, double total)
    {
        return new Receipt.Builder().dte(dte)
                .desc(desc)
                .total(total)
                .billID(billID)
                .recID(Misc.generateId())
                .build();


    }
}
