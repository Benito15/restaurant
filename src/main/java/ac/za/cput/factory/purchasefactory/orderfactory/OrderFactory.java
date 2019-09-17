package ac.za.cput.factory.purchasefactory.orderfactory;

import ac.za.cput.domains.purchase.order.Order;
import ac.za.cput.util.Misc;

import java.util.Date;

public class OrderFactory {

    public static Order getOrder(String guestID, String empID, Date dte, double tot)

    {
        return new Order.Builder().dte(dte)
                .total(tot)
                .orderID(Misc.generateId())
                .guestID(guestID)
                .empID(empID)
                .build();



    }

}
