package ac.za.cput.repositorytest.paymenttest;

import ac.za.cput.domains.proofofpayment.payment.Check;
import ac.za.cput.factory.proofofpayment.paymentfactory.CheckFactory;
import ac.za.cput.repositories.paymentrepositories.CheckRepository;
import ac.za.cput.repositories.paymentrepositories.impl.CheckRepositoryImpl;
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
public class CheckRepositoryImplTest {

    @Autowired
    private CheckRepository repository;


    @Before
    public void setUp() throws Exception {
        this.repository = CheckRepositoryImpl.getRepository();
    }

    @Test
    public void getAll() {
        Set<Check> getAllCheck= this.repository.getAll();
        System.out.println("GetAll Credit: \n"+repository.getAll().size());
        Assert.assertNotNull(getAllCheck);

    }

    @Test
    public void create() {
        Check check = CheckFactory.getCheck("this is the Check", "2011585456");
        this.repository.create(check);
        int size = this.repository.getAll().size();
        System.out.println(size);
        assertTrue("This repository is not 0: ", this.repository.getAll().size()>0);
    }

    @Test
    public void update() {
        String updateID= "256153311";
        Check check = CheckFactory.getCheck("this is the Check", "2011585456");
        Check check2 = CheckFactory.getCheck("this is the Check2", "5251522");

        this.repository.create(check);
        this.repository.create(check2);
        System.out.println("Objects in repository");
        System.out.println("---------------------");
        System.out.println(this.repository.getAll());
        check.setBankID(updateID);
        this.repository.update(check);
        System.out.println("Updated Repository");
        System.out.println("---------------------");
        System.out.println(this.repository.getAll());
        System.out.println("Updated to: " + check.getBankID());
        Assert.assertNotNull(check.getBankID());
    }

    @Test
    public void delete() {
        Check check = CheckFactory.getCheck("this is the Check", "2011585456");
        Check check2 = CheckFactory.getCheck("this is the Check2", "5251522");

        this.repository.create(check);
        this.repository.create(check2);
        System.out.println(this.repository.getAll().size());
        this.repository.delete(check.getBankID());
        System.out.println(this.repository.getAll().size());
        Assert.assertNotNull(this.repository.getAll().size());


    }

    @Test
    public void read() {
        Check check = CheckFactory.getCheck("this is the Check", "2011585456");
        Check check2 = CheckFactory.getCheck("this is the Check2", "5251522");

        this.repository.create(check);
        this.repository.create(check2);

        Check readCheck = this.repository.read(check.getBankID());
        System.out.println(readCheck.getBankID());
        System.out.println("Objects in repoitory");
        System.out.println(this.repository.getAll().size());
        Assert.assertNotEquals(readCheck.getBankID(), check2.getBankID());

    }



}