package ac.za.cput.repositories.orderrepository.impl;

import ac.za.cput.domains.purchase.order.Order;
import ac.za.cput.repositories.orderrepository.OrderRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("OrderInMemory")
public class OrderRepositoryImpl implements OrderRepository {

    private static OrderRepositoryImpl repository = null;
    private Set<Order> orders;

    private OrderRepositoryImpl()
    {
        this.orders = new HashSet<>();
    }

    public static OrderRepositoryImpl getRepository()
    {
        if(repository == null) repository = new OrderRepositoryImpl();
        return repository;
    }

    @Override
    public Order create(Order order) {
        this.orders.add(order);
        return order;
    }

    @Override
    public Order update(Order order)
    {
        Order readOrder= repository.read(order);
        if (this.orders.contains(readOrder)){
            this.orders.remove(readOrder);
            this.orders.add(order);
            return order;

        }
        return null;
    }


    @Override
    public void delete(Order order) {
        Order deleteOrder= read(order);
        this.orders.remove(deleteOrder);
    }

    @Override
    public Order read(Order order) {
        return this.orders.stream()
                .filter(thisOrder -> thisOrder.getOrderID().equalsIgnoreCase(order.getOrderID()))
                        .findAny().orElse(null);
    }

    @Override
    public Set<Order> getAll() {

        return orders;
    }



}
