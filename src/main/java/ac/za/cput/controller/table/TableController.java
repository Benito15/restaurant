package ac.za.cput.controller.table;

import ac.za.cput.domains.table.Table;
import ac.za.cput.service.table.impl.TableServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import java.util.Set;

@RestController
@RequestMapping("/table")
public class TableController {
    @Autowired
    //  @Qualifier("GuestServiceImpl")
    private TableServiceImpl tableService;

    @PostMapping(value = "/new", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Table create(@RequestBody Table table){
        return tableService.create(table);
    }

    @GetMapping(path = "/find/{id}")
    public Table findID(@PathVariable String id){
        Table order= tableService.read(id);
        return order;
    }

    @PutMapping("/update")
    public void update(@RequestBody Table table){
        tableService.update(table);

    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id){
        tableService.delete(id);
    }

    @GetMapping("/getall")
    public Set<Table> getAll(){

        return tableService.getAll();
    }



}
