package ac.za.cput.repositorytest.ordertest;

import ac.za.cput.domains.employee.Employee;
import ac.za.cput.domains.guest.Guest;
import ac.za.cput.domains.purchase.order.Order;
import ac.za.cput.factory.employeefactory.WaiterFactory;
import ac.za.cput.factory.guestfactory.GuestFactory;
import ac.za.cput.factory.purchasefactory.orderfactory.OrderFactory;
import ac.za.cput.repositories.orderrepository.OrderRepository;
import ac.za.cput.repositories.orderrepository.impl.OrderRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderRepositoryImplTest {

    @Autowired
    private OrderRepository repository;
    Date date;
    Order order;
    Employee waiter;
    Guest guest;

    @Before
    public void setUp() throws Exception {
        repository = OrderRepositoryImpl.getRepository();
        guest = GuestFactory.getGuest("Hi","Bye", 25);
        waiter = WaiterFactory.getWaiter("Waiter", "employee", 0);
        order = OrderFactory.getOrder(guest.getGuestId(),waiter.getEmpid(), null, 250);
        date = new Date();
    }

    @Test
    public void create() {
        Order createOrder = this.repository.create(order);
        Assert.assertNotNull(createOrder);
    }

    @Test
    public void update() {
        Order createOrder= this.repository.create(order);
        Order readOrder = this.repository.read(createOrder);
        Order updateOrder= new Order.Builder().copy(readOrder).total(300).build();
        this.repository.update(updateOrder);
        Assert.assertNotEquals(updateOrder.getTotal(), createOrder.getTotal());


    }

    @Test
    public void delete() {

        Order createOrder= this.repository.create(order);
        this.repository.delete(createOrder);
        Order deleteOrder = this.repository.read(createOrder);
        Assert.assertNull(deleteOrder);


    }

    @Test
    public void read() {
        Order createOrder= this.repository.create(order);
        Order readOrder = this.repository.read(createOrder);
        Assert.assertNotNull(readOrder);

    }

    @Test
    public void getAll() {
        Set<Order> getAllOrders =  this.repository.getAll();
        System.out.println("GetAllOrders: " + this.repository.getAll().size());
        Assert.assertNotNull("Order Repository: ", repository.getAll());
    }
}