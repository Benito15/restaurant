package ac.za.cput.repositorytest.paymenttest;

import ac.za.cput.domains.employee.Employee;
import ac.za.cput.domains.guest.Guest;
import ac.za.cput.domains.payment.Credit;
import ac.za.cput.domains.purchase.order.Order;
import ac.za.cput.factory.employeefactory.WaiterFactory;
import ac.za.cput.factory.guestfactory.GuestFactory;
import ac.za.cput.factory.proofofpayment.paymentfactory.CreditFactory;
import ac.za.cput.factory.purchasefactory.orderfactory.OrderFactory;
import ac.za.cput.repositories.paymentrepositories.CreditRepository;
import ac.za.cput.repositories.paymentrepositories.impl.CreditRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CreditRepositoryImplTest {

    private CreditRepository repository;
    Credit credit;
    Order order;
    Guest guest;
    Employee waiter;

    @Before
    public void setUp() throws Exception {
        this.repository = CreditRepositoryImpl.getRepository();
        String cardID="34623789562795";
        String bankName="Capitec";
        guest = GuestFactory.getGuest("Hi","Bye", 25);
        waiter = WaiterFactory.getWaiter("Waiter", "employee", 0);
        order = OrderFactory.getOrder(guest.getGuestId(),waiter.getEmpid(), null, 250);
        credit = CreditFactory.getCredit(order.getOrderID(), order.getTotal(),cardID,bankName);

    }




    @Test
    public void getAll() {
        Set<Credit> credits = this.repository.getAll();
        Assert.assertNotNull(credits);

    }

    @Test
    public void create() {
        Credit createCredit = this.repository.create(credit);
        this.repository.create(createCredit);
        int size = this.repository.getAll().size();
        System.out.println(size);
        assertTrue("This repository is not 0: ", this.repository.getAll().size()>0);
    }

    @Test
    public void update() {
        Credit createCredit = this.repository.create(credit);
        Credit readCredit = this.repository.read(createCredit.getCardID());
        Credit updateCredit= new Credit(readCredit.getCardID(), readCredit.getAmount(),readCredit.getOrderID(),"absa");
        this.repository.update(updateCredit);
        Assert.assertNotNull(updateCredit);

    }

    @Test
    public void delete() {

        Credit createCredit = this.repository.create(credit);
        Credit readCredit = this.repository.read(createCredit.getCardID());
        Assert.assertNotNull(readCredit);

    }

    @Test
    public void read() {


        Credit createCredit = this.repository.create(credit);
        Credit readCredit = this.repository.read(createCredit.getCardID());
        Assert.assertNotNull(readCredit);

    }



}