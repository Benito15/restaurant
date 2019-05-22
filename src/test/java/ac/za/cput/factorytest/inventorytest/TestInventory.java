package ac.za.cput.factorytest.inventorytest;

import ac.za.cput.domains.inventory.Inventory;
import ac.za.cput.factory.inventoryfactory.InventoryFactory;
import org.junit.Assert;
import org.junit.Test;

public class TestInventory {

    @Test
    public void inventoryTest()
    {
        String desc = "Goodies";

        int qty = 25;

        Inventory inventory = InventoryFactory.getInventory(desc,qty);
        System.out.println(inventory);
        Assert.assertNotNull(inventory.getInvID());

    }


}
