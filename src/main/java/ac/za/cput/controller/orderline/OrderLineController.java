package ac.za.cput.controller.orderline;

import ac.za.cput.domains.purchase.orderline.OrderLine;
import ac.za.cput.service.orderline.impl.OrderLineServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/orderLine")
public class OrderLineController {
    @Autowired
    //  @Qualifier("GuestServiceImpl")
    private OrderLineServiceImpl orderLineService;

    @PostMapping("/new")
    public OrderLine create(@RequestBody OrderLine orderLine){
        return orderLineService.create(orderLine);
    }

    @GetMapping(path = "/find/{id}")
    public OrderLine findID(@PathVariable String id,@PathVariable String id2 ){
        OrderLine orderLine = orderLineService.read(id,id2);
        return orderLine;
    }

    @PutMapping("/update")
    public void update(@RequestBody OrderLine orderLine){
        orderLineService.update(orderLine);

    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id, @PathVariable String id2 ){
        orderLineService.delete(id, id2);
    }

    @GetMapping("/getall")
    public Set<OrderLine> getAll(){
        return orderLineService.getAll();
    }


}
