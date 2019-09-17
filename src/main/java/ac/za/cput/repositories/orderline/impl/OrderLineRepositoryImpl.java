package ac.za.cput.repositories.orderline.impl;

import ac.za.cput.domains.purchase.orderline.OrderLine;
import ac.za.cput.repositories.orderline.OrderLineRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("OrderLineInMemory")
public class OrderLineRepositoryImpl implements  OrderLineRepository {

    private static OrderLineRepositoryImpl repository = null;
    private Set<OrderLine> orderLines;

    private OrderLineRepositoryImpl()
    {
        this.orderLines = new HashSet<>();
    }

    public static OrderLineRepositoryImpl getRepository()
    {
        if(repository == null) repository = new OrderLineRepositoryImpl();
        return repository;

    }
//
//    public OrderLine findID(String s)
//    {
//        return orderLines.stream().filter(orderLine-> orderLine.getOrderID().trim()
//                .equals(s)).findAny().orElse(null);
//    }

    @Override
    public Set<OrderLine> getAll() {

        return orderLines;
    }

    @Override
    public OrderLine create(OrderLine orderLine) {
        this.orderLines.add(orderLine);
        return orderLine;
    }

    @Override
    public OrderLine update(OrderLine orderLine) {
        OrderLine readBill = repository.read(orderLine);
        if (this.orderLines.contains(readBill)){
            this.orderLines.remove(readBill);
            this.orderLines.add(orderLine);
            return orderLine;

        }
        return null;
    }

    @Override
    public void delete(OrderLine orderLine) {

        OrderLine deleteOrderLine = read(orderLine);
        this.orderLines.remove(deleteOrderLine);
    }

    @Override
    public OrderLine read(OrderLine orderLine) {
        return this.orderLines.stream()
                .filter(thisOrderLines-> thisOrderLines.getOrderID().equalsIgnoreCase(orderLine.getOrderID())
                        && thisOrderLines.getItemID().equalsIgnoreCase(orderLine.getItemID()))
                .findAny().orElse(null);

    }
}
