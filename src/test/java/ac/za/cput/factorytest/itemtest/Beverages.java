package ac.za.cput.factorytest.itemtest;

import ac.za.cput.domains.purchase.item.Beverage;
import ac.za.cput.domains.purchase.item.Item;
import ac.za.cput.factory.purchasefactory.itemfactory.BeveragesFactory;
import org.junit.Assert;
import org.junit.Test;

public class Beverages {


            @Test
    public void beveragesTest()
    {
        String desc = "Coke";

        int qty = 3;
        double price = 250;

        Item beverages = BeveragesFactory.getBeverage(desc,qty,price);
        System.out.println(beverages);
        Assert.assertNotNull(beverages.getQty());

    }


}
