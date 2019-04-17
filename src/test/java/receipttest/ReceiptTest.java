package receipttest;

import ac.za.cput.domains.receipt.Receipt;
import ac.za.cput.factories.receiptfactory.ReceiptFactory;
import org.junit.Assert;
import org.junit.Test;

public class ReceiptTest {


        @Test
    public void receiptTest()
    {
        String dte = "18/04/2018";
        String desc = "Descriptionss";
        double total = 30;

        Receipt receipt = ReceiptFactory.getReceipt(dte,desc,total);
        System.out.println(receipt);
        Assert.assertNotNull(receipt.getTotal());

    }

}
