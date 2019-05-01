package ac.za.cput.factory.itemfactory;

import ac.za.cput.domains.item.Item;
import ac.za.cput.util.Misc;

public class ItemFactory {

    public static Item getItem(String desc, int qty, double total)
    {
        return new Item.Builder().desc(desc)
                .qty(qty)
                .price(total)
                .itemID(Misc.generateId()).build();

    }

}


