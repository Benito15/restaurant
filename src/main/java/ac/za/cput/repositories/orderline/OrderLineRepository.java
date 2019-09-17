package ac.za.cput.repositories.orderline;

import ac.za.cput.domains.purchase.orderline.OrderLine;
import ac.za.cput.repositories.IRepository;

import java.util.Set;

public interface OrderLineRepository  {
    OrderLine create(OrderLine orderLine);
    OrderLine read(OrderLine orderLine);
    OrderLine update(OrderLine orderLine);
    void delete(OrderLine orderLine);
    Set<OrderLine> getAll();
}
