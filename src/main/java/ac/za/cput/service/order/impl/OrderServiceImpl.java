package ac.za.cput.service.order.impl;

import ac.za.cput.domains.purchase.order.Order;
import ac.za.cput.repositories.orderrepository.OrderRepository;
import ac.za.cput.repositories.orderrepository.OrderRepositoryHibernate;
import ac.za.cput.repositories.orderrepository.impl.OrderRepositoryImpl;
import ac.za.cput.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("OrderService")
public class OrderServiceImpl implements OrderService {

    private static OrderServiceImpl service = null;
    @Autowired
    private OrderRepositoryHibernate repository;

    public OrderServiceImpl()
    {

    }

    public static OrderServiceImpl getService()
    {
        if(service == null) return new OrderServiceImpl();
        return service;
    }

    @Override
    public Set<Order> getAll() {
        return new HashSet<Order>((List<Order>) repository.findAll());
    }

    @Override
    public Order create(Order type) {
        return repository.save(type);
    }

    @Override
    public Order update(Order type) {
        return this.repository.save(type);

    }

    @Override
    public void delete(String order) {
        this.repository.deleteById(order);

    }

    @Override
    public Order read(String order) {
        return this.repository.findById(order).orElse(null);
    }
}
