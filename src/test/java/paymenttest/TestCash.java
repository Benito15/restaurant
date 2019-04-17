package paymenttest;

import ac.za.cput.domains.payment.Cash;
import ac.za.cput.factories.paymentfactory.CashFactory;
import org.junit.Assert;
import org.junit.Test;

public class TestCash {

    @Test
    public void cashTest()
    {

        double amount = 250;

        Cash cash = CashFactory.getCash(amount);
        System.out.println(cash);
        Assert.assertNotNull(cash);

    }

}
