package ac.za.cput.controller.guest;

import ac.za.cput.domains.guest.Guest;
import ac.za.cput.service.guest.impl.GuestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/guest")
public class GuestController {

   //auto wire your service

   //crud methods, annotated with appropriate mappings
   @Autowired
 //  @Qualifier("GuestServiceImpl")
    private GuestServiceImpl guestService;

   @PostMapping("/new")
    public Guest create(@RequestBody Guest guest){
       return guestService.create(guest);
   }

    @GetMapping (path = "/find/{id}")
    public Guest findID(@PathVariable String id){
       Guest guest = guestService.read(id);
       return guest;
    }

    @PutMapping("/update")
    public void update(@RequestBody Guest guest){
       guestService.update(guest);

    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id){
       guestService.delete(id);
    }

    @GetMapping("/getall")
    public Set<Guest> getAll(){
       return guestService.getAll();
    }


}
