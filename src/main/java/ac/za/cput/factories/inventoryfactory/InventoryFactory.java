package ac.za.cput.factories.inventoryfactory;

import ac.za.cput.domains.inventory.Inventory;
import ac.za.cput.util.Misc;

public class InventoryFactory {



    public static Inventory getInventory(String desc,  int qty)
    {
        return new Inventory.Builder().desc(desc)
                .qty(qty)
                .invID(Misc.generateId())
                .build();


    }

}
