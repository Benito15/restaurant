package ac.za.cput.repositorytest.billtest;

import ac.za.cput.domains.employee.Employee;
import ac.za.cput.domains.guest.Guest;
import ac.za.cput.domains.proofofpayment.bill.Bill;
import ac.za.cput.domains.purchase.order.Order;
import ac.za.cput.factory.employeefactory.CheffFactory;
import ac.za.cput.factory.guestfactory.GuestFactory;
import ac.za.cput.factory.proofofpayment.billfactory.BillFactory;
import ac.za.cput.factory.purchasefactory.orderfactory.OrderFactory;
import ac.za.cput.repositories.billrepository.BillRepository;
import ac.za.cput.repositories.billrepository.impl.BillRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Set;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BillRepositoryImplTest {

    @Autowired
    private BillRepository billRepository;
    Bill bill;
    Order order;
    Guest guest;
    Date nowDate ;
    Employee waiter;
    SimpleDateFormat format;


    @Before
    public void setUp() throws Exception {
        this.billRepository = BillRepositoryImpl.getRepository();
        format = new SimpleDateFormat("-yyyy-MM-dd");
        nowDate = new Date();
        guest = GuestFactory.getGuest("Hilda", "Oubaas",86);
        waiter = CheffFactory.getCheff("waiter","Chicken", 2500);
        bill = BillFactory.getBill("sds", null,"This is the bill", 200);
        order = OrderFactory.getOrder(guest.getGuestId(), waiter.getEmpid(),null, bill.getTotal());

    }

    @Test
    public void getAll() {
        Set<Bill> getAllBill = this.billRepository.getAll();
        System.out.println("Get All Method: " + getAllBill.size());
    }

    @Test
    public void create() {

      billRepository.create(bill);
      System.out.println(billRepository.getAll());
        Assert.assertNotNull(billRepository);

    }

    @Test
    public void update() {

        Bill createBill = billRepository.create(bill);
        Bill readBill = this.billRepository.read(createBill);
        //billRepository.create(bill2);
        Bill updateBill = new Bill.Builder().copy(readBill).desc("Updated description").build();

        Assert.assertNotNull(updateBill);

    }

    @Test
    public void delete() {

        Bill createBill = billRepository.create(bill);
        Bill readBill = this.billRepository.read(createBill);
        this.billRepository.delete(createBill);

        Bill deleteBill = this.billRepository.read(createBill);
        Assert.assertNull(deleteBill);

    }

    @Test
    public void read() {


//        String pastDate = "20-12-2019";
//        SimpleDateFormat format = new SimpleDateFormat(pastDate);
//        System.out.println(format);
//        System.out.println("--------");
//        try {
//            Date testingDate  = format.parse(pastDate);
//            System.out.println(testingDate);
//        } catch (ParseException e) {
//            e.printStackTrace();
//
        Bill createBill = billRepository.create(bill);
        Bill readBill = this.billRepository.read(createBill);

        Assert.assertNotNull(readBill);





    }


}