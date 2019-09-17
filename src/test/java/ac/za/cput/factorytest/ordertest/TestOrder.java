package ac.za.cput.factorytest.ordertest;

import ac.za.cput.domains.employee.Employee;
import ac.za.cput.domains.guest.Guest;
import ac.za.cput.domains.purchase.order.Order;
import ac.za.cput.factory.employeefactory.CheffFactory;
import ac.za.cput.factory.guestfactory.GuestFactory;
import ac.za.cput.factory.purchasefactory.orderfactory.OrderFactory;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class TestOrder {

    @Test
    public void orderTest() {

        double total = 125;
        Guest guest = GuestFactory.getGuest("Ben","Kriel",20);
        Employee waiter = CheffFactory.getCheff("Jen","Zoloa", 20.22);
        Order order = OrderFactory.getOrder(guest.getGuestId(),waiter.getEmpid(),null, 250);

        Assert.assertNotNull(order);

    }


}
