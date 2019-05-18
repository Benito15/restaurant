package repositorytest.ordertest;

import ac.za.cput.domains.order.Order;
import ac.za.cput.factory.orderfactory.OrderFactory;
import ac.za.cput.repositories.orderrepository.OrderRepository;
import ac.za.cput.repositories.orderrepository.impl.OrderRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.Set;

import static org.junit.Assert.*;

public class OrderRepositoryImplTest {

    private OrderRepository repository;
    Date date;

    @Before
    public void setUp() throws Exception {
        repository = OrderRepositoryImpl.getRepository();
        date = new Date();
    }

    @Test
    public void create() {
        Order order = OrderFactory.getOrder(date,200);
        this.repository.create(order);
        int size = this.repository.getAll().size();
        System.out.println(size);
        assertTrue("This repository is not 0: ", this.repository.getAll().size()>0);
    }

    @Test
    public void update() {
        double updateTotal = 400;

        Order order = OrderFactory.getOrder(date,200);
        Order order1 = OrderFactory.getOrder(date,300);

        this.repository.create(order);
        this.repository.create(order1);
        System.out.println("Objects in repository");
        System.out.println("---------------------");
        System.out.println(this.repository.getAll());
        order.setTotal(updateTotal);
        this.repository.update(order);
        System.out.println("Updated Repository");
        System.out.println("---------------------");
        System.out.println(this.repository.getAll());
        System.out.println("Updated to: "+ order.getTotal());
        //this.repository
        Assert.assertNotEquals(updateTotal, order1.getTotal());

    }

    @Test
    public void delete() {
        System.out.println(this.repository.getAll().size());
        System.out.println("------------------------------------");
        Order order = OrderFactory.getOrder(date,200);
        Order order1 = OrderFactory.getOrder(date,400);
        this.repository.create(order);
        this.repository.create(order1);
        System.out.println(this.repository.getAll().size());

        this.repository.delete(order1.getOrderID());
        System.out.println("After Delete");
        System.out.println(this.repository.getAll().size());
        Assert.assertNotNull(this.repository.getAll().size());

    }

    @Test
    public void read() {
        Order order = OrderFactory.getOrder(date,200);
        Order order1 = OrderFactory.getOrder(date,400);

        this.repository.create(order);
        this.repository.create(order1);

        Order readOrder = this.repository.read(order.getOrderID());
        System.out.println(readOrder.getOrderID());
        System.out.println("--------Objects In Repository:------------");
        System.out.println(this.repository.getAll().size());

        Assert.assertNotEquals(readOrder.getOrderID(),order1.getOrderID());

    }

    @Test
    public void getAll() {
        Set<Order> getAllOrders =  this.repository.getAll();
        System.out.println("GetAllOrders: " + this.repository.getAll().size());
        Assert.assertNotNull("Order Repository: ", repository.getAll());
    }
}