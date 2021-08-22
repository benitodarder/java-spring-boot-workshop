package local.tin.tests.spring.boot.hello.world.controllers;

import java.util.Date;
import java.util.Map.Entry;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping(path = "/ping")
public class Ping {

    @GetMapping(path = "/", produces = "text/plain")
    public String ping() {
        return "Pinged at " + new Date();
    }

    @PostMapping(path = "/postWithBody", consumes = {MediaType.TEXT_PLAIN_VALUE}, produces = "text/Plain")
    public String pingWithBody(@RequestBody String string) {
        return "Pinged by " + string + ", at " + new Date();
    }

    @GetMapping(path = "/getWithArguments", produces = "text/plain")
    public String pingWithParameter(@RequestParam(value = "name", defaultValue = "World") String name) {
        return "Pinged by " + name + ", at " + new Date();
    }
    
    @PostMapping(path = "/postURLEncoded", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE}, produces = "text/Plain")
    public String pingWithURLEncoded(String name) {
        return "Pinged by " + name + ", at " + new Date();
    }    
}
