package ac.za.cput.factories.itemfactory;

import ac.za.cput.domains.item.Beverage;

public class BeveragesFactory {

    public static Beverage getBeverage(String desc, int qty, double price)
    {
        return new Beverage.Builder().desc(desc)
                .qty(qty)
                .price(price)
                .build();


    }

}
