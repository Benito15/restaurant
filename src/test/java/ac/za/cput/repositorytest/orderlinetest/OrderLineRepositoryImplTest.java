package ac.za.cput.repositorytest.orderlinetest;

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
import ac.za.cput.repositories.orderline.OrderLineRepository;
import ac.za.cput.repositories.orderline.impl.OrderLineRepositoryImpl;
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
public class OrderLineRepositoryImplTest {

    @Autowired
    private OrderLineRepository repository;
    OrderLine orderLine;
    Item burgerItem;
    Order order;
    Guest guest;
    Employee waiter;
    @Before
    public void setUp() throws Exception {
        this.repository = OrderLineRepositoryImpl.getRepository();
        waiter = WaiterFactory.getWaiter("Lela", "Sji", 0);
        guest = GuestFactory.getGuest("Lorenzo", "Kola", 24);
        order = OrderFactory.getOrder(guest.getGuestId(),waiter.getEmpid(),null, 250);
        burgerItem = BurgerFactory.getBurger("This is a burger", 2, 70.00);
        orderLine = OrderLineFactory.getOrderLine(order.getOrderID(), burgerItem.getItemID(), burgerItem.getDesc(), burgerItem.getQty());

    }

    @Test
    public void create() {
        OrderLine createOrderLine = this.repository.create(orderLine);
        this.repository.create(orderLine);
        int size = this.repository.getAll().size();
        System.out.println(size);
        Assert.assertTrue("This repository is not 0: ", this.repository.getAll().size() >0);
    }

    @Test
    public void update() {
        OrderLine createOrderLine = this.repository.create(orderLine);
        OrderLine readOrderLine = this.repository.read(createOrderLine.getOrderID(), createOrderLine.getItemID());
        Assert.assertNotNull(readOrderLine);

    }

    @Test
    public void delete() {
        OrderLine createOrderLine = this.repository.create(orderLine);
        OrderLine readOrderLine = this.repository.read(createOrderLine.getOrderID(), createOrderLine.getItemID());
        this.repository.delete(createOrderLine.getOrderID(),createOrderLine.getItemID());

        OrderLine deleteOrderLine = this.repository.read(createOrderLine.getOrderID(), createOrderLine.getItemID());
        Assert.assertNull(deleteOrderLine);
    }


    @Test
    public void read() {

        OrderLine createOrderLine = this.repository.create(orderLine);
        OrderLine readOrderLine = this.repository.read(createOrderLine.getOrderID(), createOrderLine.getItemID());
        Assert.assertNotNull(readOrderLine);


    }

    @Test
    public void getAll() {
        Set<OrderLine> getAllOrderLine = this.repository.getAll();
        System.out.println("In getAll Orders: " + this.repository.getAll().size());
        Assert.assertNotNull(repository.getAll());

    }
}