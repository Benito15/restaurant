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
        OrderLine readBill = repository.read(orderLine.getOrderID(), orderLine.getItemID());
        if (this.orderLines.contains(readBill)){
            this.orderLines.remove(readBill);
            this.orderLines.add(orderLine);
            return orderLine;

        }
        return null;
    }

    @Override
    public void delete(String orderID, String itemID) {

        OrderLine deleteOrderLine = read(orderID, itemID);
        this.orderLines.remove(deleteOrderLine);
    }

    @Override
    public OrderLine read(String orderID, String itemID) {
        return this.orderLines.stream()
                .filter(thisOrderLines-> thisOrderLines.getOrderID().equalsIgnoreCase(orderID)
                        && thisOrderLines.getItemID().equalsIgnoreCase(itemID))
                .findAny().orElse(null);

    }
}
