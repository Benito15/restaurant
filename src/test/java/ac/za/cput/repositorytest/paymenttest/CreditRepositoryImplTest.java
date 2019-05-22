package ac.za.cput.repositorytest.paymenttest;

import ac.za.cput.domains.payment.Credit;
import ac.za.cput.factory.paymentfactory.CreditFactory;
import ac.za.cput.repositories.paymentrepositories.CreditRepository;
import ac.za.cput.repositories.paymentrepositories.impl.CreditRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CreditRepositoryImplTest {

    private CreditRepository repository;

    @Before
    public void setUp() throws Exception {
        this.repository = CreditRepositoryImpl.getRepository();

    }




    @Test
    public void getAll() {
        Set<Credit> getAllCredit= this.repository.getAll();
        System.out.println("GetAll Credit: \n"+repository.getAll().size());
        Assert.assertNotNull(getAllCredit);

    }

    @Test
    public void create() {
        Credit credit = CreditFactory.getCredit("this is the Credit","2011585456");
        this.repository.create(credit);
        int size = this.repository.getAll().size();
        System.out.println(size);
        assertTrue("This repository is not 0: ", this.repository.getAll().size()>0);
    }

    @Test
    public void update() {
        String updateID= "256153311";
        Credit credit = CreditFactory.getCredit("this is the Credit","2011585456");
        Credit credit2 = CreditFactory.getCredit("this is the Credit2","2011585456");

        this.repository.create(credit);
        this.repository.create(credit2);
        System.out.println("Objects in repository");
        System.out.println("---------------------");
        System.out.println(this.repository.getAll());
        credit.setCardID(updateID);
        this.repository.update(credit);
        System.out.println("Updated Repository");
        System.out.println("---------------------");
        System.out.println(this.repository.getAll());
        System.out.println("Updated to: " + credit.getCardID());
        Assert.assertNotNull(credit.getCardID());
    }

    @Test
    public void delete() {
        Credit credit = CreditFactory.getCredit("this is the Credit","2011585456");
        Credit credit2 = CreditFactory.getCredit("this is the Credit2","2011585456");

        this.repository.create(credit);
        this.repository.create(credit2);
        System.out.println(this.repository.getAll().size());
        this.repository.delete(credit2.getCardID());
        System.out.println(this.repository.getAll().size());
        Assert.assertNotNull(this.repository.getAll().size());


    }

    @Test
    public void read() {

        Credit credit = CreditFactory.getCredit("this is the Credit","2011585456");
        Credit credit2 = CreditFactory.getCredit("this is the Credit2","2011585456");

        this.repository.create(credit);
        this.repository.create(credit2);

        Credit readCredit = this.repository.read(credit.getCardID());
        System.out.println(readCredit.getCardID());
        System.out.println("Objects in Repository");
        System.out.println(this.repository.getAll().size());
        Assert.assertNotEquals(readCredit.getCardID(), credit2.getCardID());



    }



}