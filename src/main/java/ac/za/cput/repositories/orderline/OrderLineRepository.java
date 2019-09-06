package ac.za.cput.repositories.orderline;

import ac.za.cput.domains.purchase.orderline.OrderLine;
import ac.za.cput.repositories.IRepository;

import java.util.Set;

public interface OrderLineRepository extends IRepository<OrderLine, String> {
    Set<OrderLine> getAll();
}
