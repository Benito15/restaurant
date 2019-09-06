package ac.za.cput.factory.purchasefactory.orderfactory;

import ac.za.cput.domains.purchase.order.Order;
import ac.za.cput.util.Misc;

import java.util.Date;

public class OrderFactory {

    public static Order getOrder( Date dte, double tot)

    {
        return new Order.Builder().dte(dte)
                .total(tot)
                .orderID(Misc.generateId())
                .guestID(Misc.generateId())
                .build();



    }

}
