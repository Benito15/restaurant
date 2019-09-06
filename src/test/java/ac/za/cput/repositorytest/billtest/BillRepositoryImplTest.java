package ac.za.cput.repositorytest.billtest;

import ac.za.cput.domains.proofofpayment.bill.Bill;
import ac.za.cput.factory.proofofpayment.billfactory.BillFactory;
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
    Date nowDate ;
    SimpleDateFormat format;

    @Before
    public void setUp() throws Exception {
        this.billRepository = BillRepositoryImpl.getRepository();
        format = new SimpleDateFormat("-yyyy-MM-dd");
        nowDate = new Date();

    }

    @Test
    public void getAll() {
        Set<Bill> getAllBill = this.billRepository.getAll();
        System.out.println("Get All Method: " + getAllBill.size());
    }

    @Test
    public void create() {

      Bill bill = BillFactory.getBill(nowDate,"1 - Bill", 200);
      billRepository.create(bill);
      System.out.println(billRepository.getAll());
        Assert.assertNotNull(billRepository);

    }

    @Test
    public void update() {
        Bill bill = BillFactory.getBill(nowDate,"1 - Bill", 200);
        billRepository.create(bill);
        Bill bill2 = BillFactory.getBill(nowDate,"2 - Bill", 400);
        //billRepository.create(bill2);
        billRepository.update(bill2);
        Assert.assertNotSame(bill, bill2);

    }

    @Test
    public void delete() {

        Bill bill = BillFactory.getBill(nowDate,"1 - Bill", 200);
        Bill bill2 = BillFactory.getBill(nowDate,"2 - Bill", 400);

        billRepository.create(bill);
        billRepository.create(bill2);

        billRepository.delete(bill2.getBillID());
        System.out.println(billRepository.getAll());
       // Assert.assertNotEquals(bill, bill2);

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
//        }
        LocalDate instantDate = LocalDate.of( 2015 , 2 , 25);
        Instant instant = Instant.from(instantDate.atStartOfDay(ZoneId.of("GMT")));
        Date pasteDate= Date.from(instant);

        System.out.println(pasteDate);

        Bill bill = BillFactory.getBill(this.nowDate,"1 - Bill", 100);
        Bill bill2 = BillFactory.getBill(pasteDate,"2- Bill", 150);

        //System.out.println(bill2);
        billRepository.create(bill);
        billRepository.create(bill2);
        Bill readBill = this.billRepository.read(bill.getBillID());

        Assert.assertTrue(bill2.getTotal() > readBill.getTotal());






    }


}