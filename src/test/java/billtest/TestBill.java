package billtest;

import ac.za.cput.domains.bill.Bill;
import ac.za.cput.factories.billfactory.BillFactory;
import org.junit.Assert;
import org.junit.Test;

public class TestBill {


    @Test
    public void billTest()
    {

        String dte = "18/04/2019";
        String desc = "Orange Juice";
        double total = 250;

        Bill bill = BillFactory.getBill(dte, desc, total);
        System.out.println(bill);
        Assert.assertNotNull(bill.getBillID());

    }

}
