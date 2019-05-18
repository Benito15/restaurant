package factorytest.itemtest;

import ac.za.cput.domains.item.Beverage;
import ac.za.cput.factory.itemfactory.BeveragesFactory;
import org.junit.Assert;
import org.junit.Test;

public class Beverages {


            @Test
    public void beveragesTest()
    {
        String desc = "Coke";

        int qty = 3;
        double price = 250;

        Beverage beverages = BeveragesFactory.getBeverage(desc,qty,price);
        System.out.println(beverages);
        Assert.assertNotNull(beverages.getQty());

    }


}
