package ac.za.cput.service.order.impl;

import ac.za.cput.domains.order.Order;
import ac.za.cput.repositories.orderrepository.OrderRepository;
import ac.za.cput.repositories.orderrepository.impl.OrderRepositoryImpl;
import ac.za.cput.service.IService;
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
    public void delete(String s) {
        this.repository.delete(s);

    }

    @Override
    public Order read(String s) {
        return this.repository.read(s);
    }
}
