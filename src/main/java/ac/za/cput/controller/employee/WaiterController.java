package ac.za.cput.controller.employee;

import ac.za.cput.domains.employee.Waiter;
import ac.za.cput.service.employee.impl.WaiterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/waiter")
public class WaiterController {

    @Autowired
    //  @Qualifier("GuestServiceImpl")
    private WaiterServiceImpl waiterService;

    @PostMapping(value = "/new", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Waiter create(@RequestBody Waiter waiter){
        return waiterService.create(waiter);
    }

    @GetMapping(path = "/find/{id}")
    public Waiter findID(@PathVariable String id){
        Waiter order= waiterService.read(id);
        return order;
    }

    @PutMapping("/update")
    public void update(@RequestBody Waiter order){
        waiterService.update(order);

    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id){
        waiterService.delete(id);
    }

    @GetMapping("/getall")
    public Set<Waiter> getAll(){

        return waiterService.getAll();
    }





}
