package ac.za.cput.factories.itemfactory;

import ac.za.cput.domains.item.Dessert;

public class DessertFactory {


    public static Dessert getDessert(String desc,int qty, double price)
    {
        return new Dessert.Builder().desc(desc)
                .qty(qty)
                .price(price)
                .build();


    }
}
