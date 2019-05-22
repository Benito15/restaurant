package ac.za.cput.servicetest.item;

import ac.za.cput.domains.item.Dessert;
import ac.za.cput.factory.itemfactory.DessertFactory;
import ac.za.cput.service.item.impl.DessertServiceImpl;
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
public class DessertServiceImplTest {

    @Autowired
    private DessertServiceImpl service;

    @Test
    public void getAll() {
        Dessert dessert = DessertFactory.getDessert("Custard", 2,50);
        this.service.create(dessert);
        System.out.println(service.getAll());
        Assert.assertNotNull(service);
    }

    @Test
    public void create() {
        Dessert dessert = DessertFactory.getDessert("Custard", 2,50);
        this.service.create(dessert);
        System.out.println(service.getAll());
        Assert.assertTrue(this.service.getAll().size()>0);


    }

    @Test
    public void update() {
        int newQTy =10;
        Dessert dessert = DessertFactory.getDessert("Custard", 2,50);
        this.service.create(dessert);
        Dessert updateDessert = DessertFactory.getDessert(dessert.getDesc(), newQTy,dessert.getPrice());
        this.service.update(updateDessert);
        Assert.assertTrue(updateDessert.getQty() > dessert.getQty());

    }

    @Test
    public void delete() {
        Dessert dessert = DessertFactory.getDessert("Custard", 2,50);
        Dessert dessert2 = DessertFactory.getDessert("Trifle", 2,150);
        this.service.create(dessert);
        this.service.create(dessert2);
        this.service.delete(dessert2.getItemID());
        Assert.assertTrue(this.service.getAll().size()>=1 );


    }

    @Test
    public void read() {
        Dessert dessert = DessertFactory.getDessert("Custard", 2,50);
        Dessert dessert2 = DessertFactory.getDessert("Trifle", 2,150);
        this.service.create(dessert);
        this.service.create(dessert2);
        Dessert readDessert = this.service.read(dessert.getItemID());
        Assert.assertNotEquals(readDessert.getItemID(), dessert2.getItemID());

    }
}