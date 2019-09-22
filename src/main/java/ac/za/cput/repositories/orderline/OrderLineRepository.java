package ac.za.cput.repositories.orderline;

import ac.za.cput.domains.purchase.orderline.OrderLine;
import ac.za.cput.repositories.IRepository;

import java.util.Set;

public interface OrderLineRepository  {
    OrderLine create(OrderLine orderLine);
    OrderLine read(String orderID, String itemID);
    OrderLine update(OrderLine orderLine);
    void delete(String orderID, String itemID);
    Set<OrderLine> getAll();
}
