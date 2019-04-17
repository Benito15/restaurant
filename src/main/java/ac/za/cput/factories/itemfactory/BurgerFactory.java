package ac.za.cput.factories.itemfactory;

import ac.za.cput.domains.item.Burger;

public class BurgerFactory {

    public static Burger getBurger(String desc,int qty, double price)
    {
        return new Burger.Builder().desc(desc)
                .qty(qty)
                .price(price)
                .build();


    }

}
