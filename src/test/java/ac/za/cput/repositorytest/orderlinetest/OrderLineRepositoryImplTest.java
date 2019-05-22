package ac.za.cput.repositorytest.orderlinetest;

import ac.za.cput.domains.orderline.OrderLine;
import ac.za.cput.factory.orderlinefactory.OrderLineFactory;
import ac.za.cput.repositories.orderline.OrderLineRepository;
import ac.za.cput.repositories.orderline.impl.OrderLineRepositoryImpl;
import ac.za.cput.repositories.orderrepository.OrderRepository;
import ac.za.cput.repositories.tablerepository.impl.TableRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderLineRepositoryImplTest {

    @Autowired
    private OrderLineRepository repository;

    @Before
    public void setUp() throws Exception {
        this.repository = OrderLineRepositoryImpl.getRepository();

    }

    @Test
    public void create() {
        OrderLine orderLine = OrderLineFactory.getOrderLine("OrderLine Description", 2);
        this.repository.create(orderLine);
        int size = this.repository.getAll().size();
        System.out.println(size);
        Assert.assertTrue("This repository is not 0: ", this.repository.getAll().size() >0);
    }

    @Test
    public void update() {
        int updateQTY = 4;
        OrderLine orderLine = OrderLineFactory.getOrderLine("OrderLine Description1", 2);
        OrderLine orderLine2 = OrderLineFactory.getOrderLine("OrderLine Description2", 8);


        this.repository.create(orderLine);
        this.repository.create(orderLine2);
        System.out.println("Objects in repository");
        System.out.println("---------------------");
        System.out.println(this.repository.getAll());
        orderLine.setQty(updateQTY);
        this.repository.update(orderLine);
        System.out.println("Updated Repository");
        System.out.println("---------------------");
        System.out.println("Updated to: "+ orderLine.getQty());
        Assert.assertNotEquals(orderLine, orderLine2.getQty());
    }

    @Test
    public void delete() {
        System.out.println(this.repository.getAll().size());
        System.out.println("------------------------------------");
        OrderLine orderLine = OrderLineFactory.getOrderLine("OrderLine Description", 2);
        OrderLine orderLine2 = OrderLineFactory.getOrderLine("OrderLine Description2", 4);
        this.repository.create(orderLine);
        this.repository.create(orderLine2);
        System.out.println(this.repository.getAll().size());

        this.repository.delete(orderLine.getOrderID());
        System.out.println("After Delete");
        System.out.println(this.repository.getAll().size());
        Assert.assertNotNull(this.repository.getAll().size());
    }


    @Test
    public void read() {

        OrderLine orderLine = OrderLineFactory.getOrderLine("OrderLine Description", 2);
        OrderLine orderLine2 = OrderLineFactory.getOrderLine("OrderLine Description2", 4);

        this.repository.create(orderLine);
        this.repository.create(orderLine2);

        OrderLine readOrderLine = this.repository.read(orderLine.getOrderID());
        System.out.println(readOrderLine.getOrderID());
        System.out.println("--------Objects In Repository:------------");
        System.out.println(this.repository.getAll().size());
        Assert.assertNotEquals(readOrderLine.getOrderID(), orderLine2.getOrderID());
    }

    @Test
    public void getAll() {
        Set<OrderLine> getAllOrderLine = this.repository.getAll();
        System.out.println("In getAll Orders: " + this.repository.getAll().size());
        Assert.assertNotNull(repository.getAll());

    }
}