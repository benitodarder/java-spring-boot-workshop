package local.tin.tests.spring.boot.web.page.controllers;

import local.tin.tests.spring.boot.web.page.services.GreetingSrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author benitodarder
 */
@RestController
@RequestMapping(path = "/greetings")
public class GreetingsCtrl {
    
    @Autowired
    private GreetingSrv helloWorldService;


    @GetMapping(path = "/{name}", produces = "text/plain")
    public String greetingsByPathVariable(@PathVariable(value = "name") String name) {
        return helloWorldService.getResponse(name);
    }      

     @GetMapping(path = "/byParameter", produces = "text/plain")
    public String greetingsByRequestParam(@RequestParam(value = "name") String name) {
        return helloWorldService.getResponse(name);
    }
}
