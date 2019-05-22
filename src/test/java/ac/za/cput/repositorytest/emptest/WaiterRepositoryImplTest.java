package ac.za.cput.repositorytest.emptest;

import ac.za.cput.domains.employee.Waiter;
import ac.za.cput.factory.employeefactory.WaiterFactory;
import ac.za.cput.repositories.emprepositories.WaiterRepository;
import ac.za.cput.repositories.emprepositories.impl.WaiterRepositoryImpl;
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
public class WaiterRepositoryImplTest {

    @Autowired
    private WaiterRepository repository = null;
    private Set<Waiter> waiters;

    @Before
    public void setUp() throws Exception {
        this.repository = WaiterRepositoryImpl.getRepository();
    }



    @Test
    public void getAll() {
        Set<Waiter> getAllWaiters= this.repository.getAll();
        System.out.println("Get all WAITERS: " + this.repository.getAll().size());
        Assert.assertNotNull("WAITER Repository: ", repository.getAll());
    }

    @Test
    public void create() {
        Waiter waiter= WaiterFactory.getWaiter("Bennies ", "Zeno", 200);
        this.repository.create(waiter);
        int size = this.repository.getAll().size();
        System.out.println(size);
        Assert.assertTrue("This repository is not 0", this.repository.getAll().size() >0);

    }

    @Test
    public void update() {
        String newName = "Beeee";
        Waiter waiter= WaiterFactory.getWaiter("Bennies ", "Zeno", 200);


        repository.create(waiter);
        System.out.println("WAITER 1: \n" + this.repository.getAll());
        System.out.println("----------------------------------------");
        waiter.setName(newName);

        this.repository.update(waiter);
        System.out.println("After name update---------------------------");
        System.out.println(this.repository.getAll());
        Assert.assertEquals(newName, waiter.getName());
    }

    @Test
    public void delete() {
        System.out.println(this.repository.getAll().size());
        System.out.println("--------------------------------");
        Waiter waiter= WaiterFactory.getWaiter("Bennies ", "Zeno", 200);
        Waiter waiter1 = WaiterFactory.getWaiter("Bee", "Kalo", 100);
        this.repository.create(waiter);
        this.repository.create(waiter1);
        System.out.println(this.repository.getAll().size());
        this.repository.delete(waiter.getEmpid());
        System.out.println("After Delete");
        System.out.println(this.repository.getAll().size());
        Assert.assertNotNull(this.repository);

    }

    @Test
    public void read() {

        Waiter waiter= WaiterFactory.getWaiter("Bennies ", "Zeno", 200);
        Waiter waiter1 = WaiterFactory.getWaiter("Bee", "Kalo", 100);
        this.repository.create(waiter);
        this.repository.create(waiter1);
        System.out.println("Size after creating Objects->");
        System.out.println(this.repository.getAll().size());
        System.out.println("-------------------------------");
        Waiter readWaiter = this.repository.read(waiter.getEmpid());
        System.out.println("Reading Object into new Object of type WAITER: ");
        System.out.println(readWaiter.getEmpid());
        System.out.println("-----------------------------------");

        Assert.assertNotEquals(waiter1.getEmpid(), readWaiter.getEmpid());

    }


}