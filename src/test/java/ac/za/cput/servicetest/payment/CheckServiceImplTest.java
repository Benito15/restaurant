package ac.za.cput.servicetest.payment;

import ac.za.cput.domains.payment.Check;
import ac.za.cput.factory.paymentfactory.CheckFactory;
import ac.za.cput.service.payment.impl.CheckServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CheckServiceImplTest {

    @Autowired
    private CheckServiceImpl service;




    @Test
    public void create() {
        Check check = CheckFactory.getCheck("CHECK", "413614134");
        this.service.create(check);
        System.out.println(service.getAll());
        Assert.assertTrue(this.service.getAll().size()>0);
    }

    @Test
    public void update() {
        String updatedDescription = "UPDATED";
        Check check = CheckFactory.getCheck("CHECK", "413614134");
        this.service.create(check);
        Check updatedCheck = CheckFactory.getCheck(updatedDescription,check.getBankID());
        this.service.update(updatedCheck);
      Assert.assertNull(updatedCheck.getBankID());

    }

    @Test
    public void delete() {
        Check check = CheckFactory.getCheck("CHECK", "413614134");
        Check check2 = CheckFactory.getCheck("1CHECK1", "4413614134");
        this.service.create(check);
        this.service.create(check2);
        this.service.delete(check2.getBankID());
        Assert.assertNotNull(this.service.getAll().size()>=1);

    }

    @Test
    public void read() {
        Check check = CheckFactory.getCheck("CHECK", "413614134");
        Check check2 = CheckFactory.getCheck("4CHECK1", "441354614134");
        this.service.create(check);
        this.service.create(check2);
        Check readCheck = this.service.read(check.getBankID());
        Assert.assertNull(readCheck.getName());

    }
}