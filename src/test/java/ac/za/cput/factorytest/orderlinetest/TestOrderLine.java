package ac.za.cput.factorytest.orderlinetest;

import ac.za.cput.domains.employee.Employee;
import ac.za.cput.domains.guest.Guest;
import ac.za.cput.domains.purchase.item.Item;
import ac.za.cput.domains.purchase.order.Order;
import ac.za.cput.domains.purchase.orderline.OrderLine;
import ac.za.cput.factory.employeefactory.CheffFactory;
import ac.za.cput.factory.guestfactory.GuestFactory;
import ac.za.cput.factory.purchasefactory.itemfactory.BurgerFactory;
import ac.za.cput.factory.purchasefactory.orderfactory.OrderFactory;
import ac.za.cput.factory.purchasefactory.orderlinefactory.OrderLineFactory;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class TestOrderLine {

    //    private String orderID;
//    private String desc;

    @Test
    public void orderLineTest() {
        Date dte = new Date();
        Employee waiter = CheffFactory.getCheff("Jen","Zoloa", 20.22);
        Guest guest = GuestFactory.getGuest("Ben","Kriel",20);
        Order order = OrderFactory.getOrder(guest.getGuestId(),waiter.getEmpid(),null, 250);

        Item itemBurger = BurgerFactory.getBurger("Baked Beans", 2, 450);
        OrderLine orderLine = OrderLineFactory.getOrderLine(order.getOrderID(), itemBurger.getItemID(), itemBurger.getDesc(), itemBurger.getQty());

        Assert.assertNotNull(orderLine.getItemID());
    }
}
