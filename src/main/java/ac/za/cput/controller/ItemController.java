package ac.za.cput.controller;

import ac.za.cput.domains.Item;
import ac.za.cput.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/item")
@CrossOrigin(origins = "http://localhost:4200")
public class ItemController {

    @Autowired
    private ItemService orderService;

    @PostMapping(value = "/new")
    public Item create(@RequestBody Item order){
        return orderService.create(order);
    }

    @GetMapping(path = "/find/{id}")
    public Item findID(@PathVariable String id){
        return orderService.read(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody Item order){
        orderService.update(order);

    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id){
        orderService.delete(id);
    }

    @GetMapping("/getall")
    public Set<Item> getAll(){

        return orderService.getAll();
    }

}
