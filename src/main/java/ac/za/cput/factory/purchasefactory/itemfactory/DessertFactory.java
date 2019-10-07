package ac.za.cput.factory.purchasefactory.itemfactory;

import ac.za.cput.domains.purchase.item.Dessert;
import ac.za.cput.util.Misc;

public class DessertFactory {


    public static Dessert getDessert(String description,int qty, double price)
    {
        return (Dessert) new Dessert.Builder().description(description)
                .qty(qty)
                .price(price)
                .itemID(Misc.generateId())
                .build();


    }
}
