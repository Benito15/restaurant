package ac.za.cput.servicetest.employee;

import ac.za.cput.domains.employee.Waiter;
import ac.za.cput.factory.employeefactory.WaiterFactory;
import ac.za.cput.service.employee.impl.WaiterServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WaiterServiceImplTest {

    @Autowired
    private WaiterServiceImpl service;




    @Test
    public void getAll() {
        Waiter waiter = WaiterFactory.getWaiter("Berenice", "Kriel", 2000);
        this.service.create(waiter);
        System.out.println(service.getAll());
        Assert.assertNotNull(service);
    }

    @Test
    public void create() {
        Waiter waiter = WaiterFactory.getWaiter("Berenice", "Kriel", 2000);
        this.service.create(waiter);
        System.out.println(service.getAll());
        Assert.assertTrue(this.service.getAll().size()>0);

    }

    @Test
    public void update() {
        double newSalary = 3000;

        Waiter waiter = WaiterFactory.getWaiter("Berenice", "Kriel", 2000);
        Waiter waiter2 = WaiterFactory.getWaiter("Connie", "Frantz", 1000);
        this.service.create(waiter);
        this.service.create(waiter2);
        Waiter updatedWaiter = WaiterFactory.getWaiter(waiter.getName(),waiter.getSurname(),newSalary);
        this.service.update(updatedWaiter);
        Assert.assertTrue(updatedWaiter.getSalary() > waiter.getSalary());
    }

    @Test
    public void delete() {
        Waiter waiter = WaiterFactory.getWaiter("Berenice", "Kriel", 2000);
        Waiter waiter2 = WaiterFactory.getWaiter("Connie", "Frantz", 1000);
        this.service.create(waiter);
        this.service.create(waiter2);
        this.service.delete(waiter2.getEmpid());
        Assert.assertTrue(this.service.getAll().size()>=1);


    }

    @Test
    public void read() {
        Waiter waiter = WaiterFactory.getWaiter("Berenice", "Kriel", 2000);
        Waiter waiter2 = WaiterFactory.getWaiter("Connie", "Frantz", 1000);
        this.service.create(waiter);
        this.service.create(waiter2);
        Waiter readWaiter = this.service.read(waiter.getEmpid());
        Assert.assertNotEquals(readWaiter.getEmpid(), waiter2.getEmpid());
    }
}