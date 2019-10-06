package ac.za.cput.controller.order;

import ac.za.cput.domains.purchase.order.Order;
import ac.za.cput.service.order.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderServiceImpl orderService;

    @PostMapping(value = "/new", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Order create(@RequestBody Order order){
        return orderService.create(order);
    }

    @GetMapping (path = "/find/{id}")
    public Order findID(@PathVariable String id){
        Order order= orderService.read(id);
        return order;
    }

    @PutMapping("/update")
    public void update(@RequestBody Order order){
        orderService.update(order);

    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id){
        orderService.delete(id);
    }

    @GetMapping("/getall")
    public Set<Order> getAll(){

        return orderService.getAll();
    }


}
