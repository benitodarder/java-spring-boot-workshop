package local.tin.tests.spring.boot.web.page.controllers;

import local.tin.tests.spring.boot.web.page.services.GreetingSrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author benitodarder
 */
@RestController
@RequestMapping(path = "/greetings")
public class GreetingsCtlr {
    
    @Autowired
    private GreetingSrv helloWorldService;


    @GetMapping(path = "/{name}", produces = "text/plain")
    public String greetingsByName(@PathVariable(value = "name") String name) {
        return helloWorldService.getResponse(name);
    }      

 
}
