//package ac.za.cput.servicetest.bill;
//
//import ac.za.cput.domains.employee.Employee;
//import ac.za.cput.domains.guest.Guest;
//import ac.za.cput.domains.proofofpayment.bill.Bill;
//import ac.za.cput.domains.purchase.order.Order;
//import ac.za.cput.factory.employeefactory.WaiterFactory;
//import ac.za.cput.factory.guestfactory.GuestFactory;
//import ac.za.cput.factory.proofofpayment.billfactory.BillFactory;
//import ac.za.cput.factory.purchasefactory.orderfactory.OrderFactory;
//import ac.za.cput.service.bill.BillService;
//import ac.za.cput.service.bill.impl.BillServiceImpl;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.Set;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class BillServiceImplTest {
//@Autowired
//    private BillService service;
//    Bill bill;
//    Order order;
//    Guest guest;
//    Date nowDate ;
//    Employee waiter;
//    SimpleDateFormat format;
//
//    @Before
//    public void setUp() throws Exception {
//        this.service = BillServiceImpl.getService();
//        guest = GuestFactory.getGuest("HELLO", "BYE", 20);
//        waiter = WaiterFactory.getWaiter("Waiter", "Employee", 0);
//
//        order = OrderFactory.getOrder(guest.getGuestId(), waiter.getEmpid(),null, 200);
//        bill = BillFactory.getBill(order.getOrderID(),null, "This is the BILL", order.getTotal());
//
//    }
//
//    @Test
//    public void getAll() throws Exception{
//        Set<Bill> billSet = this.service.getAll();
//        Assert.assertNotNull(billSet);
//
//
//    }
//
//    @Test
//    public void create()  throws Exception {
//        Bill createBill = this.service.create(bill);
//        Assert.assertNotNull(createBill);
//
//
//    }
//
//    @Test
//    public void update() throws Exception {
//        Bill createBill = this.service.create(bill);
//        Bill readBill= this.service.read(createBill);
//        Bill updateBill = new Bill.Builder().copy(readBill).desc("this is an UPDATED BILL").build();
//        Assert.assertNotNull(updateBill);
//
//    }
//
//    @Test
//    public void delete() throws Exception {
//        Bill createBill = this.service.create(bill);
//        Assert.assertNotNull(createBill);
//
//    }
//
//    @Test
//    public void read()  throws Exception{
//        Bill createBill = this.service.create(bill);
//        Bill readBill= this.service.read(createBill);
//        Assert.assertNotNull(readBill);
//
//
//
//    }
//}