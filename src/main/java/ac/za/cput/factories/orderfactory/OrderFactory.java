package ac.za.cput.factories.orderfactory;

import ac.za.cput.domains.domainorder.Order;
import ac.za.cput.util.Misc;

public class OrderFactory {

    public static Order getOrder(String orderID, String dte, double tot)

    {
        return new Order.Builder().dte(dte)
                .total(tot)
                .orderID(Misc.generateId())
                .build();



    }

}
