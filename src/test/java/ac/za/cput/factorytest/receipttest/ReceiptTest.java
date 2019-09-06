package ac.za.cput.factorytest.receipttest;

import ac.za.cput.domains.proofofpayment.receipt.Receipt;
import ac.za.cput.factory.proofofpayment.receiptfactory.ReceiptFactory;
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
