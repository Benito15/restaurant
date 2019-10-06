package ac.za.cput.controller.guest;

import ac.za.cput.domains.guest.Guest;
import ac.za.cput.service.guest.impl.GuestServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/guest")
public class GuestController {

   //auto wire your service

   //crud methods, annotated with appropriate mappings
   @Autowired
    private GuestServiceImpl guestService;

   @PostMapping(value = "/new", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Guest create(@RequestBody Guest guest){
       return guestService.create(guest);
   }

    @GetMapping (path = "/find/{id}")
    public Guest findID(@PathVariable String id){
       return guestService.read(id);
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


