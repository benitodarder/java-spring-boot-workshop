package local.tin.tests.spring.boot.web.page.controllers;

import local.tin.tests.spring.boot.web.page.model.Pojo;
import local.tin.tests.spring.boot.web.page.services.PojoSrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author benitodarder
 */
@RestController
@RequestMapping(path = "/pojo")
public class PojoCtrl {
    
    @Autowired
    private PojoSrv pojoService;

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping(path = "/toUpperCase", consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Pojo toUpperCase(@RequestBody Pojo pojo) {
        return pojoService.getResponse(pojo);
    }      


}
