package ac.za.cput.factorytest.billtest;

import ac.za.cput.domains.employee.Employee;
import ac.za.cput.domains.guest.Guest;
import ac.za.cput.domains.proofofpayment.bill.Bill;
import ac.za.cput.domains.purchase.order.Order;
import ac.za.cput.factory.employeefactory.CheffFactory;
import ac.za.cput.factory.guestfactory.GuestFactory;
import ac.za.cput.factory.proofofpayment.billfactory.BillFactory;
import ac.za.cput.factory.purchasefactory.orderfactory.OrderFactory;
import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;

public class TestBill {


    @Test
    public void billTest()
    {

        Calendar dte = Calendar.getInstance();
        String desc = "Orange Juice";
        double total = 250;
        Guest guest = GuestFactory.getGuest("Ben","Kriel",20);
        Employee waiter = CheffFactory.getCheff("Jen","Zoloa", 20.22);
        Order order = OrderFactory.getOrder(guest.getGuestId(),waiter.getEmpid(),null, 250);
        Bill bill = BillFactory.getBill(order.getOrderID(),null, desc, total);

        Assert.assertNotNull(bill.getBillID());

    }

}
