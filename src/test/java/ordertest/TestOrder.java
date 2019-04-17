package ordertest;

import ac.za.cput.domains.domainorder.Order;
import ac.za.cput.factories.orderfactory.OrderFactory;
import org.junit.Assert;
import org.junit.Test;

public class TestOrder {

    @Test
    public void orderTest() {

        String orderNum = "123";
        String orddte = "18/05/2019";
        double total = 125;

        Order order = OrderFactory.getOrder(orderNum,orddte,total);
        Assert.assertNotNull(order);

    }


}
