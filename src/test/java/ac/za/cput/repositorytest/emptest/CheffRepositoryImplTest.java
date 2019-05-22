package ac.za.cput.repositorytest.emptest;

import ac.za.cput.domains.employee.Cheff;
import ac.za.cput.factory.employeefactory.CheffFactory;
import ac.za.cput.repositories.emprepositories.CheffRepository;
import ac.za.cput.repositories.emprepositories.EmployeeRepository;
import ac.za.cput.repositories.emprepositories.impl.CheffRepositoryImpl;
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
public class CheffRepositoryImplTest {

    @Autowired
    private CheffRepository repository = null;
    private Set<Cheff> cheffs;

    @Before
    public void setUp() throws Exception {
        this.repository = CheffRepositoryImpl.getRepository();
    }



    @Test
    public void getAll() {
        Set<Cheff> getAllCheff = this.repository.getAll();
        System.out.println("Get all Cheffs: " + this.repository.getAll().size());
        Assert.assertNotNull("Cheff Repository: ", repository.getAll());
    }

    @Test
    public void create() {
        Cheff cheff = CheffFactory.getCheff("Bennies ", "Zeno", 200);
        this.repository.create(cheff);
        int size = this.repository.getAll().size();
        System.out.println(size);
        Assert.assertTrue("This repository is not 0", this.repository.getAll().size() >0);

    }

    @Test
    public void update() {
        String newName = "Beeee";
        Cheff cheff = CheffFactory.getCheff("Bennies ", "Zeno", 200);

        repository.create(cheff);
        System.out.println("CHEFF 1: \n" + this.repository.getAll());
        System.out.println("----------------------------------------");
        cheff.setName(newName);

        this.repository.update(cheff);
        System.out.println("After name update---------------------------");
        System.out.println(this.repository.getAll());
        Assert.assertEquals(newName, cheff.getName());
    }

    @Test
    public void delete() {
        System.out.println(this.repository.getAll().size());
        System.out.println("--------------------------------");
        Cheff cheff = CheffFactory.getCheff("Bennies ", "Zeno", 200);
        Cheff cheff1 = CheffFactory.getCheff("Bee", "Kalo", 100);
        this.repository.create(cheff);
        this.repository.create(cheff1);
        System.out.println(this.repository.getAll().size());
        this.repository.delete(cheff.getEmpid());
        System.out.println("After Delete");
        System.out.println(this.repository.getAll().size());
        Assert.assertNotNull(this.repository);

    }

    @Test
    public void read() {

        Cheff cheff = CheffFactory.getCheff("Bennies ", "Zeno", 200);
        Cheff cheff1 = CheffFactory.getCheff("Bee", "Kalo", 100);
        this.repository.create(cheff);
        this.repository.create(cheff1);
        System.out.println("Size after creating Objects->");
        System.out.println(this.repository.getAll().size());
        System.out.println("-------------------------------");
        Cheff readCheff = this.repository.read(cheff.getEmpid());
        System.out.println("Reading Object into new Object of type Cheff");
        System.out.println(readCheff.getEmpid());
        System.out.println("-----------------------------------");

        Assert.assertNotEquals(cheff1.getEmpid(), readCheff.getEmpid());

    }



}