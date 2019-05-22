package ac.za.cput.repositorytest.emptest;

import ac.za.cput.domains.employee.Cheff;
import ac.za.cput.domains.employee.Manager;
import ac.za.cput.factory.employeefactory.ManagerFactory;
import ac.za.cput.repositories.emprepositories.ManagerRepository;
import ac.za.cput.repositories.emprepositories.impl.ManagerRepositoryImpl;
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
public class ManagerRepositoryImplTest {


    @Autowired
    private ManagerRepository repository = null;
    private Set<Manager> managers;

    @Before
    public void setUp() throws Exception {
        this.repository = ManagerRepositoryImpl.getRepository();
    }



    @Test
    public void getAll() {
        Set<Manager> getAllManagers= this.repository.getAll();
        System.out.println("Get all Managers: " + this.repository.getAll().size());
        Assert.assertNotNull("Manager Repository: ", repository.getAll());
    }

    @Test
    public void create() {
        Manager manager= ManagerFactory.getManager("Bennies ", "Zeno", 200);
        this.repository.create(manager);
        int size = this.repository.getAll().size();
        System.out.println(size);
        Assert.assertTrue("This repository is not 0", this.repository.getAll().size() >0);

    }

    @Test
    public void update() {
        String newName = "Beeee";
        Manager manager= ManagerFactory.getManager("Bennies ", "Zeno", 200);


        repository.create(manager);
        System.out.println("MANAGER 1: \n" + this.repository.getAll());
        System.out.println("----------------------------------------");
        manager.setName(newName);

        this.repository.update(manager);
        System.out.println("After name update---------------------------");
        System.out.println(this.repository.getAll());
        Assert.assertEquals(newName, manager.getName());
    }

    @Test
    public void delete() {
        System.out.println(this.repository.getAll().size());
        System.out.println("--------------------------------");
        Manager manager= ManagerFactory.getManager("Bennies ", "Zeno", 200);
        Manager manager1 = ManagerFactory.getManager("Bee", "Kalo", 100);
        this.repository.create(manager);
        this.repository.create(manager1);
        System.out.println(this.repository.getAll().size());
        this.repository.delete(manager.getEmpid());
        System.out.println("After Delete");
        System.out.println(this.repository.getAll().size());
        Assert.assertNotNull(this.repository);

    }

    @Test
    public void read() {

        Manager manager= ManagerFactory.getManager("Bennies ", "Zeno", 200);
        Manager manager1 = ManagerFactory.getManager("Bee", "Kalo", 100);
        this.repository.create(manager);
        this.repository.create(manager1);
        System.out.println("Size after creating Objects->");
        System.out.println(this.repository.getAll().size());
        System.out.println("-------------------------------");
        Manager readManager = this.repository.read(manager.getEmpid());
        System.out.println("Reading Object into new Object of type Manager");
        System.out.println(readManager.getEmpid());
        System.out.println("-----------------------------------");

        Assert.assertNotEquals(manager1.getEmpid(), readManager.getEmpid());

    }



}