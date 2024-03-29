package ac.za.cput.controller.order;

import ac.za.cput.domains.purchase.order.Order;
import ac.za.cput.service.order.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;

    @PostMapping(value = "/new")
    public Order create(@RequestBody Order order){
        return orderService.create(order);
    }

    @GetMapping (path = "/find/{id}")
    public Order findID(@PathVariable String id){
        return orderService.read(id);
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
