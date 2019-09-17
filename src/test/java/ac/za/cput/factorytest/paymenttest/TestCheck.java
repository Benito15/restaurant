package ac.za.cput.factorytest.paymenttest;

import ac.za.cput.domains.employee.Employee;
import ac.za.cput.domains.guest.Guest;
import ac.za.cput.domains.proofofpayment.payment.Check;
import ac.za.cput.domains.purchase.item.Item;
import ac.za.cput.domains.purchase.order.Order;
import ac.za.cput.domains.purchase.orderline.OrderLine;
import ac.za.cput.factory.employeefactory.CheffFactory;
import ac.za.cput.factory.guestfactory.GuestFactory;
import ac.za.cput.factory.proofofpayment.paymentfactory.CheckFactory;
import ac.za.cput.factory.purchasefactory.itemfactory.BurgerFactory;
import ac.za.cput.factory.purchasefactory.orderfactory.OrderFactory;
import ac.za.cput.factory.purchasefactory.orderlinefactory.OrderLineFactory;
import org.junit.Assert;
import org.junit.Test;

public class TestCheck {
    private String bankID;
    private String name;

    @Test
    public void checkTest()
    {

        String bankID = "9605154";
        String cardName = "Absa";
        Guest guest = GuestFactory.getGuest("Ben","Kriel",20);
        Employee waiter = CheffFactory.getCheff("Jen","Zoloa", 20.22);
        Order order = OrderFactory.getOrder(guest.getGuestId(),waiter.getEmpid(),null, 250);
        Item itemBurger = BurgerFactory.getBurger("Baked Beans", 2, 450);
        OrderLine orderLine = OrderLineFactory.getOrderLine(order.getOrderID(), itemBurger.getItemID(), itemBurger.getDesc(), itemBurger.getQty());


        Check check= CheckFactory.getCheck(order.getOrderID(),itemBurger.getDesc(),itemBurger.getPrice(),cardName, bankID);
        System.out.println(check);
        Assert.assertNotNull(check);

    }



}
