package local.tin.tests.crud.service.springboot.controllers;

import java.util.Date;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author benitodarder
 */
@RestController
@RequestMapping("/ping")
public class Ping {
    
    @GetMapping("/")
    public ResponseEntity<String> ping() {
        return new ResponseEntity<>(getMessage(""), new HttpHeaders(), HttpStatus.OK);
    }    
    
    @GetMapping("withParameter")
    public ResponseEntity<String>  pingWithParamater(@RequestParam(name = "parameter") String parameter) {
        return new ResponseEntity<>(getMessage(parameter), new HttpHeaders(), HttpStatus.OK);
    }    
    

    @PostMapping("withFormParameter")
    public ResponseEntity<String> greetingsFromForm(@RequestParam(name = "parameter") String parameter) {
        return new ResponseEntity<>(getMessage(parameter), new HttpHeaders(), HttpStatus.OK);
    }   

    private String getMessage(String parameter) {
        return "Hello " + parameter + ", it's " + new Date();
    }
    
    @PostMapping("withBody")
    public ResponseEntity<String> pingFromPayload(@RequestBody String parameter) {
        return new ResponseEntity<>(getMessage(parameter), new HttpHeaders(), HttpStatus.OK);
    }          
    
}
