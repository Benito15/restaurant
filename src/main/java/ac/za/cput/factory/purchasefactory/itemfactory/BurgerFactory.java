package ac.za.cput.factory.purchasefactory.itemfactory;

import ac.za.cput.domains.purchase.item.Burger;
import ac.za.cput.util.Misc;

public class BurgerFactory {

    public static Burger getBurger(String desc,int qty, double price)
    {
        return (Burger) new Burger.Builder().desc(desc)
                .qty(qty)
                .price(price)
                .itemID(Misc.generateId())
                .build();


    }

}
