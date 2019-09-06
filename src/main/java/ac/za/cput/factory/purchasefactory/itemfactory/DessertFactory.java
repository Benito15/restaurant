package ac.za.cput.factory.purchasefactory.itemfactory;

import ac.za.cput.domains.purchase.item.Dessert;
import ac.za.cput.util.Misc;

public class DessertFactory {


    public static Dessert getDessert(String desc,int qty, double price)
    {
        return (Dessert) new Dessert.Builder().desc(desc)
                .qty(qty)
                .price(price)
                .itemID(Misc.generateId())
                .build();


    }
}
