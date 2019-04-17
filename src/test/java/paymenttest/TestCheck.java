package paymenttest;

import ac.za.cput.domains.payment.Check;
import ac.za.cput.factories.paymentfactory.CheckFactory;
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
