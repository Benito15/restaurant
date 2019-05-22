package ac.za.cput.servicetest.employee;

import ac.za.cput.domains.employee.Manager;
import ac.za.cput.factory.employeefactory.CheffFactory;
import ac.za.cput.factory.employeefactory.ManagerFactory;
import ac.za.cput.service.employee.impl.ManagerServiceImpl;
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
public class ManagerServiceImplTest {

    @Autowired
    private ManagerServiceImpl service;


    @Test
    public void create(){
        Manager manager = ManagerFactory.getManager("ZINNG", "ZONG", 10000);
        this.service.create(manager);
        System.out.println(service.getAll());
        Assert.assertTrue(this.service.getAll().size()>0);
    }

    @Test
    public void update() {
        double newSalary = 15550;
        Manager manager = ManagerFactory.getManager("ZINNG", "ZONG", 10000);
        Manager manager2 = ManagerFactory.getManager("XHos", "OHahx", 15000);
        this.service.create(manager);
        this.service.create(manager2);
        Manager updatedManager = ManagerFactory.getManager(manager.getName(),manager.getSurname(), newSalary);
        this.service.update(updatedManager);
        Assert.assertTrue(updatedManager.getSalary()> manager2.getSalary());


    }

    @Test
    public void delete() {
        Manager manager = ManagerFactory.getManager("ZINNG", "ZONG", 10000);
        Manager manager2 = ManagerFactory.getManager("XHos", "OHahx", 15000);
        this.service.create(manager);
        this.service.create(manager2);
        Assert.assertTrue(this.service.getAll().size()>=1);



    }

    @Test
    public void read() {
        Manager manager = ManagerFactory.getManager("ZINNG", "ZONG", 10000);
        Manager manager2 = ManagerFactory.getManager("XHos", "OHahx", 15000);
        this.service.create(manager);
        this.service.create(manager2);
        Manager readManager = this.service.read(manager.getEmpid());
        Assert.assertNotEquals(readManager.getEmpid(), manager2.getEmpid());
    }
}