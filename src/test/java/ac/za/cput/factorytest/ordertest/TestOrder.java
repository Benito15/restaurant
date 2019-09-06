package ac.za.cput.factorytest.ordertest;

import ac.za.cput.domains.purchase.order.Order;
import ac.za.cput.factory.purchasefactory.orderfactory.OrderFactory;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class TestOrder {

    @Test
    public void orderTest() {

        String orderNum = "123";
        String guestID= "2";
        Date orddte = new Date();
        double total = 125;

        Order order = OrderFactory.getOrder(orddte,total);
        Assert.assertNotNull(order);

    }


}
