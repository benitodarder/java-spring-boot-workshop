package local.tin.tests.spring.boot.hello.world.controllers;

import java.util.Date;
import org.springframework.http.MediaType;
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
@RequestMapping(path = "/HelloWorld")
public class HelloWorld {

    @GetMapping(path = "/", produces = "text/plain")
    public String helloWorld() {
        return "Hello World, it's " + new Date();
    }

    @PostMapping(path = "/postWithBody", consumes = {MediaType.TEXT_PLAIN_VALUE}, produces = "text/Plain")
    public String helloWorldWithBody(@RequestBody String string) {
        return "Hello " + string + ", it's " + new Date();
    }

    @GetMapping(path = "/getWithArguments", produces = "text/plain")
    public String helloWorldWithParameter(@RequestParam(value = "name", defaultValue = "World") String name) {
        return "Hello " + name + ", it's " + new Date();
    }
    
    @PostMapping(path = "/postURLEncoded", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE}, produces = "text/Plain")
    public String helloWorldWithURLEncoded(String name) {
        return "Hello " + name + ", it's " + new Date();
    }    
}
