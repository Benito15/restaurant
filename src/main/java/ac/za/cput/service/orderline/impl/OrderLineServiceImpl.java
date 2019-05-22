package ac.za.cput.service.orderline.impl;

import ac.za.cput.domains.orderline.OrderLine;
import ac.za.cput.repositories.orderline.OrderLineRepository;
import ac.za.cput.repositories.orderline.impl.OrderLineRepositoryImpl;
import ac.za.cput.service.orderline.OrderLineService;
import org.nustaq.serialization.annotations.Serialize;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("OrderLineService")
public class OrderLineServiceImpl implements OrderLineService {

    private OrderLineServiceImpl service = null;
    private OrderLineRepository repository;

    private OrderLineServiceImpl()
    {
        repository = OrderLineRepositoryImpl.getRepository();
    }

    public OrderLineServiceImpl getService()
    {
        if(service ==null) return new OrderLineServiceImpl();
        return service;
    }


    @Override
    public Set<OrderLine> getAll() {
        return repository.getAll();

    }

    @Override
    public OrderLine create(OrderLine type) {
        return repository.create(type);

    }

    @Override
    public OrderLine update(OrderLine type) {
        return this.repository.update(type);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);

    }

    @Override
    public OrderLine read(String s) {
        return this.repository.read(s);
    }
}
