package ac.za.cput.factorytest.receipttest;

import ac.za.cput.domains.employee.Employee;
import ac.za.cput.domains.guest.Guest;
import ac.za.cput.domains.proofofpayment.bill.Bill;
import ac.za.cput.domains.proofofpayment.receipt.Receipt;
import ac.za.cput.domains.purchase.item.Item;
import ac.za.cput.domains.purchase.order.Order;
import ac.za.cput.factory.employeefactory.CheffFactory;
import ac.za.cput.factory.guestfactory.GuestFactory;
import ac.za.cput.factory.proofofpayment.billfactory.BillFactory;
import ac.za.cput.factory.proofofpayment.receiptfactory.ReceiptFactory;
import ac.za.cput.factory.purchasefactory.itemfactory.BurgerFactory;
import ac.za.cput.factory.purchasefactory.orderfactory.OrderFactory;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class ReceiptTest {


        @Test
    public void receiptTest()
    {
        Date dte = new Date();
        String desc = "Descriptionss";
        double total = 30;
        Guest guest = GuestFactory.getGuest("Ben","Kriel",20);
        Employee waiter = CheffFactory.getCheff("Jen","Zoloa", 20.22);
        Order order = OrderFactory.getOrder(guest.getGuestId(),waiter.getEmpid(),null, 250);

        Item itemBurger = BurgerFactory.getBurger("Baked Beans", 2, 450);
        Bill bill = BillFactory.getBill(order.getOrderID(),null, desc, total);
        Receipt receipt = ReceiptFactory.getReceipt(bill.getBillID(),null,itemBurger.getDesc(),order.getTotal());
        System.out.println(receipt);
        Assert.assertNotNull(receipt.getTotal());

    }

}
