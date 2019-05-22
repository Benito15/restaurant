package ac.za.cput.repositorytest.item;

import ac.za.cput.domains.item.Beverage;
import ac.za.cput.factory.itemfactory.BeveragesFactory;
import ac.za.cput.repositories.item.BeverageRepository;
import ac.za.cput.repositories.item.impl.BeverageRepositoryImpl;
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
public class BeverageRepositoryImplTest {

    @Autowired
    private BeverageRepository repository = null;
    private Set<Beverage> beverages;

    @Before
    public void setUp() throws Exception {
        this.repository = BeverageRepositoryImpl.getRepository();

    }

    @Test
    public void getAll() {
        Set<Beverage> getAllBeverages = this.repository.getAll();
        System.out.println("Get all Beverages: " + this.repository.getAll().size());
        Assert.assertNotNull("Beverage Repository: ", repository.getAll());
    }

    @Test
    public void create() {
        Beverage beverages = BeveragesFactory.getBeverage("Coke", 20, 300);
        this.repository.create(beverages);
        int size = this.repository.getAll().size();
        System.out.println(size);
        Assert.assertTrue("This repository is not 0", this.repository.getAll().size() >0);
    }

    @Test
    public void update() {

        String updateDesc = "fanta";
        Beverage beverages = BeveragesFactory.getBeverage("Coke", 20,300);

        repository.create(beverages);
        System.out.println("Beverage 1: \n" + this.repository.getAll());
        System.out.println("----------------------------------------");
        beverages.setDesc(updateDesc);

        this.repository.update(beverages);
        System.out.println("After beverage update---------------------------");
        System.out.println(this.repository.getAll());
        Assert.assertEquals(updateDesc, beverages.getDesc());
    }

    @Test
    public void delete() {
        System.out.println(this.repository.getAll().size());
        System.out.println("--------------------------------");
        Beverage beverages = BeveragesFactory.getBeverage("Coke", 20,300);
        Beverage beverages1 = BeveragesFactory.getBeverage("FaNta", 10,150);
        this.repository.create(beverages);
        this.repository.create(beverages1);
        System.out.println(this.repository.getAll().size());

        this.repository.delete(beverages.getItemID());
        System.out.println("After Delete");
        System.out.println(this.repository.getAll().size());
        Assert.assertNotNull(this.repository);
    }

    @Test
    public void read() {
        Beverage beverages = BeveragesFactory.getBeverage("Coke", 20,300);
        Beverage beverages1 = BeveragesFactory.getBeverage("FaNta", 10,150);
        this.repository.create(beverages);
        this.repository.create(beverages1);
        System.out.println("Size after creating Objects->");
        System.out.println(this.repository.getAll().size());
        System.out.println("-------------------------------");
        Beverage readBeverage= this.repository.read(beverages.getItemID());
        System.out.println("Reading Object into new Object of type beverage");
        System.out.println(readBeverage.getItemID());
        System.out.println("-----------------------------------");

        Assert.assertNotEquals(beverages1.getItemID(), readBeverage.getItemID());

    }
}