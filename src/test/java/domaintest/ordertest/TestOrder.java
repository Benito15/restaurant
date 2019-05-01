package domaintest.ordertest;

import ac.za.cput.domains.domainorder.Order;
import ac.za.cput.factory.orderfactory.OrderFactory;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class TestOrder {

    @Test
    public void orderTest() {

        String orderNum = "123";
        Date orddte = new Date();
        double total = 125;

        Order order = OrderFactory.getOrder(orderNum,orddte,total);
        Assert.assertNotNull(order);

    }


}
