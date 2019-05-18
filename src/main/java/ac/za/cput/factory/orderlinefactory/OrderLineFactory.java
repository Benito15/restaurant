package ac.za.cput.factory.orderlinefactory;

import ac.za.cput.domains.orderline.OrderLine;
import ac.za.cput.util.Misc;

public class OrderLineFactory {


    public static OrderLine getOrderLine(String desc, int qty)
    {
        return new OrderLine.Builder().desc(desc)
                .qty(qty)
                .itemID(Misc.generateId())
                .orderID(Misc.generateId())
                .build();




    }

}
