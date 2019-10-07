package ac.za.cput.factory.purchasefactory.itemfactory;

import ac.za.cput.domains.purchase.item.Burger;
import ac.za.cput.util.Misc;

public class BurgerFactory {

    public static Burger getBurger(String description,int qty, double price)
    {
        return (Burger) new Burger.Builder().description(description)
                .qty(qty)
                .price(price)
                .itemID(Misc.generateId())
                .build();


    }

}
