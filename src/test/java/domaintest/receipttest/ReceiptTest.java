package domaintest.receipttest;

import ac.za.cput.domains.receipt.Receipt;
import ac.za.cput.factory.receiptfactory.ReceiptFactory;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class ReceiptTest {


        @Test
    public void receiptTest()
    {
        Date dte = new Date();
        String desc = "Descriptionss";
        double total = 30;

        Receipt receipt = ReceiptFactory.getReceipt(dte,desc,total);
        System.out.println(receipt);
        Assert.assertNotNull(receipt.getTotal());

    }

}
