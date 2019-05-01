package ac.za.cput.repositories.orderrepository.impl;

import ac.za.cput.domains.domainorder.Order;
import ac.za.cput.repositories.orderrepository.OrderRepository;

import java.util.HashSet;
import java.util.Set;

public class OrderRepositoryImpl implements OrderRepository {

    private static OrderRepositoryImpl repository = null;
    private Set<Order> orders;

    private OrderRepositoryImpl()
    {
        this.orders = new HashSet<>();
    }


    @Override
    public Order create(Order order) {
        this.orders.add(order);
        return order;
    }

    @Override
    public Order update(Order order) {
        return null;
    }

    @Override
    public void delete(String s) {
        Order order = findID(s);
        this.orders.remove(order);
    }

    @Override
    public Order read(String s) {
        Order order = findID(s);
        if(orders.equals(s))
            return order;
        return null;
    }

    @Override
    public Set<Order> getAll() {
        return this.orders;
    }

    public Order findID(String o)
    {
        return orders.stream().filter(p -> p.getOrderID().equals(o))
                .findFirst().orElse(null);


    }

}
