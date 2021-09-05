package local.tin.tests.spring.boot.web.page.controllers;

import local.tin.tests.spring.boot.web.page.services.UpTimeSrv;
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
@RequestMapping(path = "/upTime")
public class UpTimeCtrl {
    
    @Autowired
    private UpTimeSrv helloWorldService;


    @GetMapping(path = "/greetingsWithUpTime", produces = "text/plain")
    public String greetingsWithUpTime(@RequestParam(value = "name", defaultValue = "World") String name) {
        return helloWorldService.getResponse(name);
    }      

 
}
