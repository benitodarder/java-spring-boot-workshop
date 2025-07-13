package local.tin.tests.spring.boot.aws.identity.controllers;

import java.util.Date;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author benitodarder
 */
@RestController
@RequestMapping(path = "/HelloWorld")
public class HelloWorldController {
    
    @GetMapping(path = "/", produces = "text/plain")
    public String getResponse() {
        return "Hi there! It's " + new Date().toString();
    }
    

}
