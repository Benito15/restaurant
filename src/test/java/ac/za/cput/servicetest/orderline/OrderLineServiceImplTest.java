package ac.za.cput.servicetest.orderline;

import ac.za.cput.domains.purchase.orderline.OrderLine;
import ac.za.cput.factory.purchasefactory.orderlinefactory.OrderLineFactory;
import ac.za.cput.service.orderline.impl.OrderLineServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderLineServiceImplTest {

    @Autowired
   private OrderLineServiceImpl service;


    @Test
    public void getAll() {
        OrderLine orderLine = OrderLineFactory.getOrderLine("ORDERLINE",5);
        this.service.create(orderLine);
        System.out.println(service.getAll());
        Assert.assertNotNull(service);
    }

    @Test
    public void create() {
        OrderLine orderLine = OrderLineFactory.getOrderLine("ORDERLINE",5);
        this.service.create(orderLine);
        System.out.println(service.getAll());
        Assert.assertTrue(this.service.getAll().size()>0);
    }

    @Test
    public void update() {
        int newQTy =10;
        OrderLine orderLine = OrderLineFactory.getOrderLine("ORDERLINE",5);
        this.service.create(orderLine);
        OrderLine updatedOrd = OrderLineFactory.getOrderLine(orderLine.getDesc(),newQTy);
        this.service.update(updatedOrd);
        Assert.assertNotNull(updatedOrd.getQty());

    }

    @Test
    public void delete() {
        OrderLine orderLine = OrderLineFactory.getOrderLine("ORDERLINE",5);
        OrderLine orderLine2 = OrderLineFactory.getOrderLine("ORDERLINE",5);
        this.service.create(orderLine);
        this.service.create(orderLine2);
        this.service.delete(orderLine2.getItemID());
        Assert.assertTrue(this.service.getAll().size() >=1);

    }

    @Test
    public void read() {
        OrderLine orderLine = OrderLineFactory.getOrderLine("ORDERLINE",5);
        OrderLine orderLine2 = OrderLineFactory.getOrderLine("ORDERLINE2",10);
        this.service.create(orderLine);
        this.service.create(orderLine2);
        OrderLine readOrderLine = this.service.read(orderLine.getItemID());


           }
}