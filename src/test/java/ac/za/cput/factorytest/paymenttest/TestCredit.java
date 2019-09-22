package ac.za.cput.factorytest.paymenttest;

import ac.za.cput.domains.employee.Employee;
import ac.za.cput.domains.guest.Guest;
import ac.za.cput.domains.payment.Payment;
import ac.za.cput.domains.purchase.item.Item;
import ac.za.cput.domains.purchase.order.Order;
import ac.za.cput.domains.purchase.orderline.OrderLine;
import ac.za.cput.factory.employeefactory.CheffFactory;
import ac.za.cput.factory.guestfactory.GuestFactory;
import ac.za.cput.factory.proofofpayment.paymentfactory.CreditFactory;
import ac.za.cput.factory.purchasefactory.itemfactory.BurgerFactory;
import ac.za.cput.factory.purchasefactory.orderfactory.OrderFactory;
import ac.za.cput.factory.purchasefactory.orderlinefactory.OrderLineFactory;
import org.junit.Assert;
import org.junit.Test;

public class TestCredit {

    @Test
    public void creditTest()
    {

       String cardID = "9605154";
       String cardName = "Absa";
        String paymentID = "12";

        Guest guest = GuestFactory.getGuest("Ben","Kriel",20);
        Employee waiter = CheffFactory.getCheff("Jen","Zoloa", 20.22);
        Order order = OrderFactory.getOrder(guest.getGuestId(),waiter.getEmpid(),null, 250);
        Item itemBurger = BurgerFactory.getBurger("Baked Beans", 2, 450);
        OrderLine orderLine = OrderLineFactory.getOrderLine(order.getOrderID(), itemBurger.getItemID(), itemBurger.getDesc(), itemBurger.getQty());



        Payment credit= CreditFactory.getCredit(order.getOrderID(),itemBurger.getPrice(), cardID, cardName);
        System.out.println(credit);
        Assert.assertNotNull(credit);

    }

}
