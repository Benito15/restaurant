package ac.za.cput.servicetest.payment;

import ac.za.cput.domains.payment.Credit;
import ac.za.cput.factory.proofofpayment.paymentfactory.CreditFactory;
import ac.za.cput.service.payment.impl.CreditServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CreditServiceImplTest {

    @Autowired
    private CreditServiceImpl service;


    @Test
    public void getAll() {
        Credit credit = CreditFactory.getCredit("436436", 299, "57820752", "Capitec");
        this.service.create(credit);
        System.out.println(service.getAll());
        Assert.assertNotNull(service);
    }

    @Test
    public void create() {
        Credit credit = CreditFactory.getCredit("436436", 299, "57820752", "Capitec");
        this.service.create(credit);
        System.out.println(service.getAll());
        Assert.assertTrue(this.service.getAll().size()>0);
    }

    @Test
    public void update() {
        String updateDescription = "Updated Description";
        Credit credit = CreditFactory.getCredit("436436", 299, "57820752", "Capitec");
        this.service.create(credit);
        Credit updatedCredit = CreditFactory.getCredit(credit.getOrderID(), credit.getAmount(), credit.getCardID(), credit.getName());
        this.service.update(updatedCredit);
        Assert.assertNotNull(credit);

    }

    @Test
    public void delete() {
        Credit credit = CreditFactory.getCredit("545", 99, "3535543", "Standard-Bank");
        Credit credit2 = CreditFactory.getCredit("436436", 299, "57820752", "Capitec");
        this.service.create(credit);
        this.service.create(credit2);
        this.service.delete(credit.getCardID());
        Assert.assertTrue(this.service.getAll().size()>=1);

    }

    @Test
    public void read() {
        Credit credit = CreditFactory.getCredit("545", 99, "3535543", "Standard-Bank");
        Credit credit2 = CreditFactory.getCredit("436436", 299, "57820752", "Capitec");
        this.service.create(credit);
        this.service.create(credit2);
        Credit readCredit = this.service.read(credit.getCardID());
        Assert.assertNotEquals(readCredit.getCardID(),credit2.getCardID());
    }
}