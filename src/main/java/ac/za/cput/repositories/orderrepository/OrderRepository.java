package ac.za.cput.repositories.orderrepository;

import ac.za.cput.domains.purchase.order.Order;
import ac.za.cput.repositories.IRepository;

import java.util.Set;

public interface OrderRepository extends IRepository<Order, String> {

    Set<Order> getAll();

}
