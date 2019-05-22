package ac.za.cput.repositorytest.item;

import ac.za.cput.domains.item.Burger;
import ac.za.cput.factory.itemfactory.BurgerFactory;
import ac.za.cput.repositories.item.BurgerRepository;
import ac.za.cput.repositories.item.impl.BurgerRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BurgerRepositoryImplTest {

    @Autowired
    private BurgerRepository repository = null;
    private Set< Burger> burgers;

    @Before
    public void setUp() throws Exception {
        this.repository = BurgerRepositoryImpl.getRepository();
    }

    @Test
    public void getAll() {
        Set<Burger> getAllBurgers  = this.repository.getAll();
        System.out.println("Get all Burgers: " + this.repository.getAll().size());
        Assert.assertNotNull("Burger Repository: ", repository.getAll());
    }

    @Test
    public void create() {
        Burger burger= BurgerFactory.getBurger("Cheese Burger", 10,120);
        this.repository.create(burger);
        int size = this.repository.getAll().size();
        System.out.println(size);
        Assert.assertTrue("This repository is not 0", this.repository.getAll().size() >0);
    }

    @Test
    public void update() {
        String newDescription = "Double Cheese Burger";
        Burger burger= BurgerFactory.getBurger("Cheese Burger", 10,120);
        this.repository.create(burger);
        System.out.println("Burger 1: \n" + this.repository.getAll());
        System.out.println("----------------------------------------");
        burger.setDesc(newDescription);

        this.repository.update(burger);
        System.out.println("After Description update---------------------------");
        System.out.println(this.repository.getAll());
        Assert.assertEquals(newDescription, burger.getDesc());



    }

    @Test
    public void delete() {
        System.out.println(this.repository.getAll().size());
        System.out.println("--------------------------------");
        Burger burger= BurgerFactory.getBurger("Cheese Burger", 10,120);
        Burger burger1= BurgerFactory.getBurger("Chicken Burger", 5,80);
        this.repository.create(burger);
        this.repository.create(burger1);
        System.out.println(this.repository.getAll().size());
        this.repository.delete(burger.getItemID());
        System.out.println("After Delete");
    }

    @Test
    public void read() {

        Burger burger= BurgerFactory.getBurger("Cheese Burger", 10,120);
        Burger burger1= BurgerFactory.getBurger("Chicken Burger", 5,80);
        this.repository.create(burger);
        this.repository.create(burger1);
        System.out.println("Size after creating Objects->");
        System.out.println(this.repository.getAll().size());
        System.out.println("-------------------------------");
        Burger readBurger = this.repository.read(burger.getItemID());
        System.out.println("Reading Object into new Object of type Burger");
        System.out.println(readBurger.getItemID());
        System.out.println("-----------------------------------");

        Assert.assertNotEquals(burger1.getItemID(), readBurger.getItemID());



    }
}