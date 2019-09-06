package ac.za.cput.factorytest.paymenttest;

import ac.za.cput.domains.proofofpayment.payment.Credit;
import ac.za.cput.factory.proofofpayment.paymentfactory.CreditFactory;
import org.junit.Assert;
import org.junit.Test;

public class TestCredit {

    @Test
    public void creditTest()
    {

       String cardID = "9605154";
       String cardName = "Absa";

        Credit credit= CreditFactory.getCredit(cardID,cardName);
        System.out.println(credit);
        Assert.assertNotNull(credit);

    }

}
