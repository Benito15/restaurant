package ac.za.cput.factorytest.paymenttest;

import ac.za.cput.domains.proofofpayment.payment.Check;
import ac.za.cput.factory.proofofpayment.paymentfactory.CheckFactory;
import org.junit.Assert;
import org.junit.Test;

public class TestCheck {
    private String bankID;
    private String name;

    @Test
    public void checkTest()
    {

        String bankID = "9605154";
        String cardName = "Absa";

        Check check= CheckFactory.getCheck(bankID,cardName);
        System.out.println(check);
        Assert.assertNotNull(check);

    }



}
