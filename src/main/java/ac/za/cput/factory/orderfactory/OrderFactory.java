package ac.za.cput.factory.orderfactory;

import ac.za.cput.domains.domainorder.Order;
import ac.za.cput.util.Misc;

import java.util.Date;

public class OrderFactory {

    public static Order getOrder(String orderID, Date dte, double tot)

    {
        return new Order.Builder().dte(dte)
                .total(tot)
                .orderID(Misc.generateId())
                .build();



    }

}
