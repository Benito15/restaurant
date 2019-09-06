package ac.za.cput.repositories.orderline.impl;

import ac.za.cput.domains.purchase.orderline.OrderLine;
import ac.za.cput.repositories.orderline.OrderLineRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("OrderLineInMemory")
public class OrderLineRepositoryImpl implements  OrderLineRepository {

    private static OrderLineRepositoryImpl repository = null;
    private Map<String,OrderLine> orderLines;

    private OrderLineRepositoryImpl()
    {
        this.orderLines = new HashMap<>();
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
        Collection<OrderLine> orderLines = this.orderLines.values();
        Set<OrderLine> set = new HashSet<>();
        set.addAll(orderLines);
        return set;    }

    @Override
    public OrderLine create(OrderLine orderLine) {
        orderLines.put(orderLine.getOrderID(),orderLine);
        return orderLine;
    }

    @Override
    public OrderLine update(OrderLine orderLine) {
        this.orderLines.replace(orderLine.getOrderID(), orderLine);
        return this.orderLines.get(orderLine.getOrderID());
    }

    @Override
    public void delete(String s) {

        this.orderLines.remove(s);
    }

    @Override
    public OrderLine read(String s) {
        return this.orderLines.get(s);

    }
}
