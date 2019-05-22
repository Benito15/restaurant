package ac.za.cput.servicetest.employee;

import ac.za.cput.domains.employee.Cheff;
import ac.za.cput.factory.employeefactory.CheffFactory;
import ac.za.cput.repositories.emprepositories.CheffRepository;
import ac.za.cput.service.employee.impl.CheffServiceImpl;
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
public class CheffServiceImplTest {

    @Autowired
    private CheffServiceImpl service;


    @Test
    public void getAll() {
        Cheff cheff = CheffFactory.getCheff("Ben","vdv",2500);
        this.service.create(cheff);
        System.out.println(service.getAll());
        Assert.assertNotNull(service);
    }

    @Test
    public void create() {
        Cheff cheff = CheffFactory.getCheff("Ben","vdv",2500);
        this.service.create(cheff);
        System.out.println(service.getAll());
        Assert.assertTrue(this.service.getAll().size()>0);
    }

    @Test
    public void update() {
        double newSalary = 3000;
        Cheff cheff = CheffFactory.getCheff("Ben","vdv",2500);
        Cheff cheff2 = CheffFactory.getCheff("lorenzo","vdv",5000);
        this.service.create(cheff);
        this.service.create(cheff2);
        Cheff updatedCheff = CheffFactory.getCheff(cheff.getName(),cheff.getSurname(),newSalary);
        this.service.update(updatedCheff);
        Assert.assertTrue(updatedCheff.getSalary() > cheff.getSalary());




    }

    @Test
    public void delete() {
        Cheff cheff = CheffFactory.getCheff("Ben","vdv",2500);
        Cheff cheff2 = CheffFactory.getCheff("lorenzo","vdv",5000);
        this.service.create(cheff);
        this.service.create(cheff2);
        this.service.delete(cheff2.getEmpid());
        Assert.assertTrue(this.service.getAll().size()>=1);


    }

    @Test
    public void read() {

        Cheff cheff = CheffFactory.getCheff("Ben","vdv",2500);
        Cheff cheff2 = CheffFactory.getCheff("lorenzo","vdv",5000);
        this.service.create(cheff);
        this.service.create(cheff2);
        Cheff readCheff = this.service.read(cheff.getEmpid());
        Assert.assertNotEquals(readCheff.getEmpid(), cheff2.getEmpid());

    }
}