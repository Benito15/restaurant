package ac.za.cput.service.orderline;

import ac.za.cput.domains.purchase.orderline.OrderLine;
import ac.za.cput.service.IService;

import java.util.Set;

public interface OrderLineService extends IService<OrderLine,String>
{
    Set<OrderLine> getAll();
}
