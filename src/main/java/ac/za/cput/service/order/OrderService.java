package ac.za.cput.service.order;

import ac.za.cput.domains.purchase.order.Order;
import ac.za.cput.service.IService;

import java.util.Set;

public interface OrderService  extends IService<Order, String> {
//    Order create(Order  order);
//    Order read(Order order);
//    Order update(Order order);
//    void delete(Order order);

    Set<Order> getAll();
}
