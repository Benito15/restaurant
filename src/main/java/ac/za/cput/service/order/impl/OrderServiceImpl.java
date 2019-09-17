package ac.za.cput.service.order.impl;

import ac.za.cput.domains.purchase.order.Order;
import ac.za.cput.repositories.orderrepository.OrderRepository;
import ac.za.cput.repositories.orderrepository.impl.OrderRepositoryImpl;
import ac.za.cput.service.order.OrderService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("OrderService")
public class OrderServiceImpl implements OrderService {

    private OrderServiceImpl service = null;
    private OrderRepository repository;

    private OrderServiceImpl()
    {
        repository = OrderRepositoryImpl.getRepository();

    }

    public OrderServiceImpl getService()
    {
        if(service == null) return new OrderServiceImpl();
        return service;
    }

    @Override
    public Set<Order> getAll() {
        return repository.getAll();
    }

    @Override
    public Order create(Order type) {
        return repository.create(type);
    }

    @Override
    public Order update(Order type) {
        return this.repository.update(type);

    }

    @Override
    public void delete(Order order) {
        this.repository.delete(order);

    }

    @Override
    public Order read(Order order) {
        return this.repository.read(order);
    }
}
