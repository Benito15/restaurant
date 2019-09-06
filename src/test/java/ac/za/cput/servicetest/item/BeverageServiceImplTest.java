package ac.za.cput.servicetest.item;

import ac.za.cput.domains.purchase.item.Beverage;
import ac.za.cput.factory.purchasefactory.itemfactory.BeveragesFactory;
import ac.za.cput.service.item.impl.BeverageServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BeverageServiceImplTest {


    @Autowired
    private BeverageServiceImpl service;


    @Test
    public void getAll() {
        Beverage beverage = BeveragesFactory.getBeverage("Drink",5,50);
        this.service.create(beverage);
        System.out.println(service.getAll());
        Assert.assertNotNull(service);

    }

    @Test
    public void create() {
        Beverage beverage = BeveragesFactory.getBeverage("Drink",5,50);
        this.service.create(beverage);
        System.out.println(service.getAll());
        Assert.assertTrue(this.service.getAll().size()>0);
    }

    @Test
    public void update() {
        int newQTy =10;
        Beverage beverage = BeveragesFactory.getBeverage("Drink",5,50);
        this.service.create(beverage);
        Beverage updateBeverage = BeveragesFactory.getBeverage(beverage.getDesc(),newQTy, beverage.getPrice());
        this.service.update(updateBeverage);
        Assert.assertTrue(updateBeverage.getQty() > beverage.getQty());

    }

    @Test
    public void delete() {
        Beverage beverage = BeveragesFactory.getBeverage("Drink",5,50);
        Beverage beverage2 = BeveragesFactory.getBeverage("Milkshake",10,100);
        this.service.create(beverage);
        this.service.create(beverage2);
        this.service.delete(beverage2.getItemID());
        Assert.assertTrue(this.service.getAll().size()>=1 );

    }

    @Test
    public void read() {
        Beverage beverage = BeveragesFactory.getBeverage("Drink",5,50);
        Beverage beverage2 = BeveragesFactory.getBeverage("Milkshake",10,100);
        this.service.create(beverage);
        this.service.create(beverage2);
        Beverage readBeverage = this.service.read(beverage.getItemID());
        Assert.assertNotEquals(readBeverage.getItemID(), beverage2.getItemID());
    }
}