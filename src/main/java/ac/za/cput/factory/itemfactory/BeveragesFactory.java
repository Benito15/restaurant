package ac.za.cput.factory.itemfactory;

import ac.za.cput.domains.item.Beverage;
import ac.za.cput.util.Misc;

public class BeveragesFactory {

    public static Beverage getBeverage(String desc, int qty, double price)
    {
        return (Beverage) new Beverage.Builder().desc(desc)
                .qty(qty)
                .price(price)
                .itemID(Misc.generateId())
                .build();


    }

}
