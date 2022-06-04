package local.tin.tests.spring.boot.hello.world.controllers;

import java.text.MessageFormat;
import java.util.Date;
import local.tin.tests.spring.boot.hello.world.HelloWorldConfig;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    @Autowired
    private HelloWorldConfig helloWorldConfig;

    @GetMapping(path = "/", produces = "text/plain")
    public String helloWorld() {
        return getMessage("");
    }

    @PostMapping(path = "/postWithBody", consumes = {MediaType.TEXT_PLAIN_VALUE}, produces = "text/Plain")
    public String helloWorldWithBody(@RequestBody String string) {
        return getMessage(string);
    }

    @GetMapping(path = "/getWithArguments", produces = "text/plain")
    public String helloWorldWithParameter(@RequestParam(value = "name", defaultValue = "World") String name) {
        return getMessage(name);
    }
    
    @PostMapping(path = "/postURLEncoded", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE}, produces = "text/Plain")
    public String helloWorldWithURLEncoded(String name) {
        return getMessage(name);
    }    
    
    private String getMessage(String infix) {
        Object[] parameters = {infix, new Date().toString()};
        MessageFormat messageFormat = new MessageFormat(helloWorldConfig.getTemplate());
        return messageFormat.format(parameters);
    }
}
