package ac.za.cput.repositories.orderrepository.impl;

import ac.za.cput.domains.order.Order;
import ac.za.cput.repositories.orderrepository.OrderRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("OrderInMemory")
public class OrderRepositoryImpl implements OrderRepository {

    private static OrderRepositoryImpl repository = null;
    private Map<String, Order> orders;

    private OrderRepositoryImpl()
    {
        this.orders = new HashMap<>();
    }

    public static OrderRepositoryImpl getRepository()
    {
        if(repository == null) repository = new OrderRepositoryImpl();
        return repository;
    }

    @Override
    public Order create(Order order) {
        this.orders.put(order.getOrderID(), order);
        return order;
    }

    @Override
    public Order update(Order order)
    {
        this.orders.replace(order.getOrderID(), order);
        return this.orders.get(order.getOrderID());
    }

    @Override
    public void delete(String s) {

        this.orders.remove(s);
    }

    @Override
    public Order read(String s) {
        return this.orders.get(s);

    }

    @Override
    public Set<Order> getAll() {
        Collection<Order> orders = this.orders.values();
        Set<Order> set = new HashSet<>();
        set.addAll(orders);
        return set;
    }

//    public Order findID(String o)
//    {
//        return orders.stream().filter(p -> p.getOrderID().equals(o))
//                .findAny().orElse(null);
//
//
//    }

}
