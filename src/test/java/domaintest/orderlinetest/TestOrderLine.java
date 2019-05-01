package domaintest.orderlinetest;

import ac.za.cput.domains.orderline.OrderLine;
import ac.za.cput.factory.orderlinefactory.OrderLineFactory;
import org.junit.Assert;
import org.junit.Test;

public class TestOrderLine {

    //    private String orderID;
//    private String desc;

    @Test
    public void orderLineTest()
    {
        String orderID = "20";
        String desc = "ManyORDERS";



        OrderLine orderLine= OrderLineFactory.getOrderLine(orderID,desc);
        System.out.println(orderLine);
        Assert.assertNotNull(orderLine.getOrderID());

    }
}
