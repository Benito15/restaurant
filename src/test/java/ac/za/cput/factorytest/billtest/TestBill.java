package ac.za.cput.factorytest.billtest;

import ac.za.cput.domains.bill.Bill;
import ac.za.cput.factory.billfactory.BillFactory;
import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;

public class TestBill {


    @Test
    public void billTest()
    {

        Calendar dte = Calendar.getInstance();
        String desc = "Orange Juice";
        double total = 250;

        Bill bill = BillFactory.getBill(null, desc, total);
        System.out.println(bill);
        Assert.assertNotNull(bill.getBillID());

    }

}
