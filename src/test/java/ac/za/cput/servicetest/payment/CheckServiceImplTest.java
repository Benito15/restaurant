package ac.za.cput.servicetest.payment;

import ac.za.cput.domains.employee.Employee;
import ac.za.cput.domains.guest.Guest;
import ac.za.cput.domains.payment.Check;
import ac.za.cput.domains.payment.Credit;
import ac.za.cput.domains.purchase.order.Order;
import ac.za.cput.factory.proofofpayment.paymentfactory.CheckFactory;
import ac.za.cput.service.payment.impl.CheckServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CheckServiceImplTest {

    @Autowired
    private CheckServiceImpl service;
    Credit credit;
    Order order;
    Guest guest;
    Employee waiter;




    @Test
    public void create() {


        Check check = CheckFactory.getCheck("436436", 299, "57820752", "Capitec");
        this.service.create(check);
        System.out.println(service.getAll());
        Assert.assertTrue(this.service.getAll().size()>0);
    }

    @Test
    public void update() {
        String updatedDescription = "UPDATED";
        Check check = CheckFactory.getCheck("436436", 299, "57820752", "Capitec");
        this.service.create(check);
        Check updatedCheck = CheckFactory.getCheck(check.getOrderID(), check.getAmount(), check.getBankID(), check.getName());
        this.service.update(updatedCheck);
      Assert.assertNotNull(check);

    }

    @Test
    public void delete() {
        Check check = CheckFactory.getCheck("436436", 299, "57820752", "Capitec");
        Check check2 = CheckFactory.getCheck("45425", 234, "54354452", "Standard-Bank");
        this.service.create(check);
        this.service.create(check2);
        this.service.delete(check2.getBankID());
        Assert.assertNotNull(check);

    }

    @Test
    public void read() {
        Check check = CheckFactory.getCheck("436436", 299, "57820752", "Capitec");
        Check check2 = CheckFactory.getCheck("45425", 234, "54354452", "Standard-Bank");
        this.service.create(check);
        this.service.create(check2);
        Check readCheck = this.service.read(check.getBankID());
        Assert.assertNotNull(readCheck.getName());

    }
}