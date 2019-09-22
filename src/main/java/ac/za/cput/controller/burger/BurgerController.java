package ac.za.cput.controller.burger;

import ac.za.cput.domains.purchase.item.Burger;
import ac.za.cput.service.item.impl.BurgerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/burger")
public class BurgerController {
    @Autowired
    private BurgerServiceImpl burgerService;

    @PostMapping("/new")
    public Burger create(@RequestBody Burger burger){
        return burgerService.create(burger);
    }

    @GetMapping(path = "/find/{id}")
    public Burger findID(@PathVariable String id){
        Burger burger = burgerService.read(id);
        return burger;
    }

    @PutMapping("/update")
    public void update(@RequestBody Burger burger){
        burgerService.update(burger);

    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id){
        burgerService.delete(id);
    }

    @GetMapping("/getall")
    public Set<Burger> getAll(){

        return burgerService.getAll();
    }



}
