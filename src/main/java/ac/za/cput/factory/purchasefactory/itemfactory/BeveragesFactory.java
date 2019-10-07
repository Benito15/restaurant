package ac.za.cput.factory.purchasefactory.itemfactory;

import ac.za.cput.domains.purchase.item.Beverage;
import ac.za.cput.util.Misc;

public class BeveragesFactory {

    public static Beverage getBeverage(String description, int qty, double price)
    {
        return (Beverage) new Beverage.Builder().description(description)
                .qty(qty)
                .price(price)
                .itemID(Misc.generateId())
                .build();


    }

}
