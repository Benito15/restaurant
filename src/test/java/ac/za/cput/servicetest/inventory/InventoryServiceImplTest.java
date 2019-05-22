package ac.za.cput.servicetest.inventory;

import ac.za.cput.domains.inventory.Inventory;
import ac.za.cput.factory.inventoryfactory.InventoryFactory;
import ac.za.cput.service.inventory.impl.InventoryServiceImpl;
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
public class InventoryServiceImplTest {

    @Autowired
    private InventoryServiceImpl service;



    @Test
    public void getAll() {
        Inventory inventory = InventoryFactory.getInventory("Some inventory",4);
        service.create(inventory);
        System.out.println(service.getAll());
        Assert.assertNotNull(service);

    }

    @Test
    public void create() {
        Inventory inventory = InventoryFactory.getInventory("Some inventory",4);
        service.create(inventory);
        System.out.println(service.getAll());
        Assert.assertTrue(this.service.getAll().size()>0);

    }

    @Test
    public void update() {
        int newQty = 10;
        Inventory inventory = InventoryFactory.getInventory("Some inventory",4);
        service.create(inventory);
        Inventory updateInventory = InventoryFactory.getInventory(inventory.getDesc(), newQty);
        service.update(updateInventory);
        Assert.assertTrue(updateInventory.getQty() > inventory.getQty());


    }

    @Test
    public void delete() {
        Inventory inventory = InventoryFactory.getInventory("Some inventory",4);
        Inventory inventory2 = InventoryFactory.getInventory("Some inventory2",8);
        service.create(inventory);
        service.create(inventory2);
        Assert.assertTrue(this.service.getAll().size()>=1);

    }

    @Test
    public void read() {
        Inventory inventory = InventoryFactory.getInventory("Some inventory",4);
        Inventory inventory2 = InventoryFactory.getInventory("Some inventory2",8);
        service.create(inventory);
        service.create(inventory2);
        Inventory readInventory = this.service.read(inventory.getInvID());
        Assert.assertNotEquals(readInventory.getInvID(), inventory2.getInvID());
    }
}