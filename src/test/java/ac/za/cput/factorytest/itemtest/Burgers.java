package ac.za.cput.factorytest.itemtest;

import ac.za.cput.domains.purchase.item.Burger;
import ac.za.cput.factory.purchasefactory.itemfactory.BurgerFactory;
import org.junit.Assert;
import org.junit.Test;

public class Burgers {
    @Test

    public void burgerTest()
    {
        String desc = "cheese-burger";

        int qty = 3;
        double price = 250;

        Burger burger = BurgerFactory.getBurger(desc,qty,price);
        System.out.println(burger);
        Assert.assertNotNull(burger.getQty());

    }

}
