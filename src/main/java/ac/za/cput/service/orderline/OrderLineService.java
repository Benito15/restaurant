package ac.za.cput.service.orderline;

import ac.za.cput.domains.purchase.orderline.OrderLine;
import ac.za.cput.service.IService;

import java.util.Set;

public interface OrderLineService
{
    OrderLine create(OrderLine orderLine);
    OrderLine read(OrderLine orderLine);
    OrderLine update(OrderLine orderLine);
    void delete(OrderLine orderLine);
    Set<OrderLine> getAll();
}
