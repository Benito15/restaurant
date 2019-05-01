package ac.za.cput.factory.orderlinefactory;

import ac.za.cput.domains.orderline.OrderLine;
import ac.za.cput.util.Misc;

public class OrderLineFactory {


    public static OrderLine getOrderLine(String orderID, String desc)
    {
        return new OrderLine.Builder().desc(desc)
                .orderID(Misc.generateId())
                .build();




    }

}
