package ac.za.cput.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {

    @RequestMapping(value = {"/", "/restaurant"})
    public ResponseEntity <String>hello(){

        return new ResponseEntity<>("Welcome to restaurant", HttpStatus.OK);

    }
}
