//package ac.za.cput.servicetest.receipt;
//
//import ac.za.cput.domains.employee.Employee;
//import ac.za.cput.domains.guest.Guest;
//import ac.za.cput.domains.proofofpayment.bill.Bill;
//import ac.za.cput.domains.proofofpayment.receipt.Receipt;
//import ac.za.cput.factory.employeefactory.CheffFactory;
//import ac.za.cput.factory.guestfactory.GuestFactory;
//import ac.za.cput.factory.proofofpayment.billfactory.BillFactory;
//import ac.za.cput.factory.proofofpayment.receiptfactory.ReceiptFactory;
//import ac.za.cput.service.receipt.impl.ReceiptServiceImpl;
//
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.Date;
//import java.util.Set;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class ReceiptServiceImplTest {
//
//    @Autowired
//    private ReceiptServiceImpl service;
//    Date dte;
//    Guest guest;
//    Employee waiter;
//    Bill bill;
//    Receipt receipt;
//
//    @Before
//    public void setUp() throws Exception {
//        service = ReceiptServiceImpl.getService();
//        dte = new Date();
//        guest = GuestFactory.getGuest("Hilda", "Oubaas",86);
//        waiter = CheffFactory.getCheff("waiter","Chicken", 2500);
//        bill = BillFactory.getBill("sds", null,"This is the bill", 200);
//        receipt = ReceiptFactory.getReceipt(bill.getBillID(), null, bill.getDesc(), bill.getTotal());
//
//    }
//
//    @Test
//    public void getAll() {
//        Set<Receipt> getAllReceipts = this.service.getAll();
//        System.out.println("GetAll Receipts: \n"+service.getAll().size());
//
//
//    }
//
//    @Test
//    public void create() {
//        Receipt createReceipt = this.service.create(receipt);
//        Assert.assertNotNull(createReceipt.getRecID());
//    }
//
//    @Test
//    public void update() {
//        Receipt createReceipt = this.service.create(receipt);
//        Receipt readReceipt = this.service.read(createReceipt);
//        Receipt updateReceipt = new Receipt.Builder().copy(readReceipt).desc("UPDATED").build();
//        this.service.update(updateReceipt);
//        Assert.assertNotNull(updateReceipt);    }
//
//    @Test
//    public void delete() {
//        System.out.println("Start");
//        Receipt createReceipt = this.service.create(receipt);
//        Receipt readReceipt = this.service.read(createReceipt);
//        this.service.delete(createReceipt);
//        Assert.assertNotNull(readReceipt);
//    }
//
//    @Test
//    public void read() {
//        Receipt createReceipt = this.service.create(receipt);
//        Receipt readReceipt = this.service.read(createReceipt);
//        Assert.assertNotNull(readReceipt);
//
//
//    }
//}