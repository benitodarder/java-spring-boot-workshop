package local.tin.tests.spring.boot.hello.world.controllers;

import local.tin.tests.spring.boot.hello.world.services.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author benitodarder
 */
@RestController
@RequestMapping(path = "/helloWorldToo")
public class HelloWorldControllerToo {
    
    @Autowired
    private HelloWorldService helloWorldService;

    @GetMapping(path = "/greetingsWithCreationInstant", produces = "text/plain")
    public String greetingsWithCreationInstant(@RequestParam(value = "name", defaultValue = "World") String name) {
        return helloWorldService.getGreeting(name);
    }    
        
}
