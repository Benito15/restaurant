package ac.za.cput.service.orderline.impl;

import ac.za.cput.domains.purchase.orderline.OrderLine;
import ac.za.cput.repositories.orderline.OrderLineRepository;
import ac.za.cput.repositories.orderline.OrderLineRepositoryHibernate;
import ac.za.cput.repositories.orderline.impl.OrderLineRepositoryImpl;
import ac.za.cput.service.orderline.OrderLineService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("OrderLineService")
public class OrderLineServiceImpl implements OrderLineService {

    private static OrderLineServiceImpl service = null;
    @Autowired
    private OrderLineRepositoryHibernate repository;

    public OrderLineServiceImpl()
    {

    }

    public static OrderLineServiceImpl getService()
    {
        if(service ==null) return new OrderLineServiceImpl();
        return service;
    }


    @Override
    public Set<OrderLine> getAll() {
        return new HashSet<OrderLine>((List<OrderLine>)repository.findAll());

    }

    @Override
    public OrderLine create(OrderLine type) {
        return repository.save(type);

    }

    @Override
    public OrderLine update(OrderLine type) {
        return this.repository.save(type);
    }

    @Override
    public void delete(String orderID, String itemID) {

        OrderLine deleteOrderLine = read(orderID, itemID);
        this.repository.delete(deleteOrderLine);
    }


    @Override
    public OrderLine read(String orderID, String itemID) {
        return getAll().stream()
                .filter(thisOrderLines-> thisOrderLines.getOrderID().equalsIgnoreCase(orderID)
                        && thisOrderLines.getItemID().equalsIgnoreCase(itemID))
                .findAny().orElse(null);

    }

}
