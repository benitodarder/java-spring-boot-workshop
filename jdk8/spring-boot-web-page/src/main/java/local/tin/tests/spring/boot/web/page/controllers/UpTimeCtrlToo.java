package local.tin.tests.spring.boot.web.page.controllers;


import javax.xml.ws.Response;
import local.tin.tests.spring.boot.web.page.services.UpTimeSrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author benitodarder
 */
@RestController
@RequestMapping(path = "/upTimeToo")
public class UpTimeCtrlToo {
    
    @Autowired
    private UpTimeSrv helloWorldService;

    @GetMapping(path = "/greetingsWithUpTime", produces = "text/plain")
    public ResponseEntity<String> greetingsWithUpTime(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new ResponseEntity<>(helloWorldService.getResponse(name), HttpStatus.OK);
    }    
        
}
