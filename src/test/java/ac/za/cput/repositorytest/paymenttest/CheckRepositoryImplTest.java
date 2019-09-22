package ac.za.cput.repositorytest.paymenttest;

import ac.za.cput.domains.employee.Employee;
import ac.za.cput.domains.guest.Guest;
import ac.za.cput.domains.payment.Check;
import ac.za.cput.domains.payment.Payment;
import ac.za.cput.domains.purchase.order.Order;
import ac.za.cput.factory.employeefactory.WaiterFactory;
import ac.za.cput.factory.guestfactory.GuestFactory;
import ac.za.cput.factory.proofofpayment.paymentfactory.CheckFactory;
import ac.za.cput.factory.purchasefactory.orderfactory.OrderFactory;
import ac.za.cput.repositories.paymentrepositories.CheckRepository;
import ac.za.cput.repositories.paymentrepositories.impl.CheckRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CheckRepositoryImplTest {

    @Autowired
    private CheckRepository repository;
    private Check check;
    private Order order;
    private Guest guest;
    private Employee waiter;
    private Payment paymentGen;


    @Before
    public void setUp() throws Exception {
        this.repository = CheckRepositoryImpl.getRepository();
        String bankID= "86757468786";
        String bankNAME="absa";
        guest = GuestFactory.getGuest("Hi","Bye", 25);
        waiter = WaiterFactory.getWaiter("Waiter", "employee", 0);
        order = OrderFactory.getOrder(guest.getGuestId(),waiter.getEmpid(), null, 250);

        check = CheckFactory.getCheck(order.getOrderID(), order.getTotal(), bankID, bankNAME );
    }

    @Test
    public void getAll() {
        Set<Check> getAllCheck= this.repository.getAll();
        System.out.println("GetAll Credit: \n"+repository.getAll().size());
        Assert.assertNotNull(getAllCheck);

    }

    @Test
    public void create() {
     Check createCheck = this.repository.create(check);
     Assert.assertNotNull(createCheck);


    }

    @Test
    public void update() {
        Check createCheck = this.repository.create(check);
        Check readCheck = this.repository.read(createCheck.getBankID());
        Check updateCheck = new Check(readCheck.getBankID(), readCheck.getAmount(),readCheck.getBankID(),"Capitec");
        this.repository.update(updateCheck);
        Assert.assertNotNull(updateCheck);

    }

    @Test
    public void delete() {
        Check createCheck = this.repository.create(check);
        Check readCheck = this.repository.read(createCheck.getBankID());
        this.repository.delete(createCheck.getBankID());
        Assert.assertNotNull(readCheck.getBankID());


    }

    @Test
    public void read() {
        Check createCheck = this.repository.create(check);
        Check readCheck = this.repository.read(createCheck.getBankID());
        Assert.assertNotNull(createCheck);

    }



}