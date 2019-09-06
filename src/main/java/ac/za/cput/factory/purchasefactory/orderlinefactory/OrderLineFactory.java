package ac.za.cput.factory.purchasefactory.orderlinefactory;

import ac.za.cput.domains.purchase.orderline.OrderLine;

public class OrderLineFactory {


    public static OrderLine getOrderLine(String orderID, String itemID, String desc, int qty)
    {

        return new OrderLine(orderID, itemID, desc, qty);

    }

}
