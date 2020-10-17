package local.tin.tests.spring.boot.hello.world.controllers;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
 
/**
 *
 * @author benitodarder
 */
@RestController
@RequestMapping(path = "/ping")
public class Ping {

    @GetMapping(path = "/get", produces = "text/plain")
    public String helloWorld() {
        return "Hello being, it's " + new Date();
    }

    @PostMapping(path = "/postWithBody", consumes = "text/Plain", produces = "text/Plain")
    public String helloWorldWithBody(@RequestBody String string) {
        return "Hello " + string + ", it's " + new Date();
    }

}
