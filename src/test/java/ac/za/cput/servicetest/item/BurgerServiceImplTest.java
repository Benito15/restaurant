package ac.za.cput.servicetest.item;

import ac.za.cput.domains.purchase.item.Burger;
import ac.za.cput.factory.purchasefactory.itemfactory.BurgerFactory;
import ac.za.cput.service.item.impl.BurgerServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BurgerServiceImplTest {

    @Autowired
    private BurgerServiceImpl service;




    @Test
    public void getAll() {
        Burger burger =BurgerFactory.getBurger("CheeseBurg", 5, 100);
        this.service.create(burger);
        System.out.println(service.getAll());
        Assert.assertNotNull(service);
    }

    @Test
    public void create() {
        Burger burger =BurgerFactory.getBurger("CheeseBurg", 5, 100);
        this.service.create(burger);
        System.out.println(service.getAll());
        Assert.assertTrue(this.service.getAll().size()>0);

    }

    @Test
    public void update() {
        int newQTy =10;
        Burger burger =BurgerFactory.getBurger("CheeseBurg", 5, 100);
        this.service.create(burger);
        Burger updateBurger = BurgerFactory.getBurger(burger.getDesc(), newQTy, burger.getPrice());
        this.service.update(updateBurger);
        Assert.assertTrue(updateBurger.getQty() > burger.getQty());
    }

    @Test
    public void delete() {
        Burger burger =BurgerFactory.getBurger("CheeseBurg", 5, 100);
        Burger burger2 =BurgerFactory.getBurger("STeak", 10, 250);
        this.service.create(burger);
        this.service.create(burger2);
        this.service.delete(burger2.getItemID());
        Assert.assertTrue(this.service.getAll().size()>=1 );

    }

    @Test
    public void read() {
        Burger burger =BurgerFactory.getBurger("CheeseBurg", 5, 100);
        Burger burger2 =BurgerFactory.getBurger("STeak", 10, 250);
        this.service.create(burger);
        this.service.create(burger2);
        Burger readBurger = this.service.read(burger.getItemID());
        Assert.assertNotEquals(readBurger.getItemID(), burger2.getItemID());
    }
}