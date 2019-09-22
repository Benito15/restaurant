package ac.za.cput.controller.catalog;

import ac.za.cput.domains.catalog.Catalog;
import ac.za.cput.service.catalog.impl.CatalogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

    @Autowired
    //  @Qualifier("GuestServiceImpl")
    private CatalogServiceImpl catalogService;

    @PostMapping("/new")
    public Catalog create(@RequestBody Catalog catalog){
        return catalogService.create(catalog);
    }

    @GetMapping(path = "/find/{id}")
    public Catalog findID(@PathVariable String id,@PathVariable String id2 ){
        Catalog catalog = catalogService.read(id,id2);
        return catalog;
    }

    @PutMapping("/update")
    public void update(@RequestBody Catalog catalog){
        catalogService.update(catalog);

    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id, @PathVariable String id2 ){
        catalogService.delete(id, id2);
    }

    @GetMapping("/getall")
    public Set<Catalog> getAll(){
        return catalogService.getAll();
    }

}
