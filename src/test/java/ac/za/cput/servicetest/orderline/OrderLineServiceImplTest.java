package ac.za.cput.servicetest.orderline;

import ac.za.cput.domains.employee.Employee;
import ac.za.cput.domains.guest.Guest;
import ac.za.cput.domains.purchase.item.Item;
import ac.za.cput.domains.purchase.order.Order;
import ac.za.cput.domains.purchase.orderline.OrderLine;
import ac.za.cput.factory.employeefactory.WaiterFactory;
import ac.za.cput.factory.guestfactory.GuestFactory;
import ac.za.cput.factory.purchasefactory.itemfactory.BurgerFactory;
import ac.za.cput.factory.purchasefactory.orderfactory.OrderFactory;
import ac.za.cput.factory.purchasefactory.orderlinefactory.OrderLineFactory;
import ac.za.cput.service.orderline.impl.OrderLineServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderLineServiceImplTest {

    @Autowired
   private OrderLineServiceImpl service;
    OrderLine orderLine;
    Item burgerItem;
    Order order;
    Guest guest;
    Employee waiter;

    @Before
    public void setUp() throws Exception {
        this.service = OrderLineServiceImpl.getService();
        waiter = WaiterFactory.getWaiter("Lela", "Sji", 0);
        guest = GuestFactory.getGuest("Lorenzo", "Kola", 24);
        order = OrderFactory.getOrder(guest.getGuestId(),waiter.getEmpid(),null, 250);
        burgerItem = BurgerFactory.getBurger("This is a burger", 2, 70.00);
        orderLine = OrderLineFactory.getOrderLine(order.getOrderID(), burgerItem.getItemID(), burgerItem.getDesc(), burgerItem.getQty());

    }

    @Test
    public void getAll() {
        Set<OrderLine>orderLineSet =  this.service.getAll();
        Assert.assertNotNull(orderLineSet);
    }

    @Test
    public void create() {
        OrderLine createOrderLine = this.service.create(orderLine);
        Assert.assertNotNull(createOrderLine);


    }

    @Test
    public void update() {
        OrderLine createOrderLine = this.service.create(orderLine);
        OrderLine readOrderLine = this.service.read(createOrderLine.getOrderID(),createOrderLine.getItemID());
        OrderLine updateOrderLine = OrderLineFactory.getOrderLine(readOrderLine.getOrderID(), readOrderLine.getItemID(),orderLine.getDesc(), 2);
        this.service.update(updateOrderLine);
        Assert.assertNotNull(updateOrderLine.getQty());

    }

    @Test
    public void delete() {
        OrderLine createOrderLine = this.service.create(orderLine);
        Assert.assertNotNull(createOrderLine);


    }

    @Test
    public void read() {
        OrderLine createOrderLine = this.service.create(orderLine);
        OrderLine readOrderLine = this.service.read(createOrderLine.getOrderID(),createOrderLine.getItemID());
        Assert.assertNotNull(readOrderLine.getItemID());
    }
}