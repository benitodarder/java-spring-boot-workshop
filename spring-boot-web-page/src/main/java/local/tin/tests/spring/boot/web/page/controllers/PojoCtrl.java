package local.tin.tests.spring.boot.web.page.controllers;

import local.tin.tests.spring.boot.web.page.model.Pojo;
import local.tin.tests.spring.boot.web.page.services.PojoSrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(path = "/pojo")
public class PojoCtrl {

    @Autowired
    private PojoSrv pojoService;

    @PostMapping(path = "/toUpperCase", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pojo> toUpperCase(@RequestBody Pojo pojo) {
        return new ResponseEntity<>(pojoService.getResponse(pojo), HttpStatus.OK);
    }

    @PostMapping(path = "/toUpperCaseFromForm", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pojo> toUpperCaseFromForm(Integer pojoId02, String pojoString02) {
        Pojo pojo = new Pojo();
        pojo.setId(pojoId02);
        pojo.setString(pojoString02);
        return new ResponseEntity<>(pojoService.getResponse(pojo), HttpStatus.OK);
    }

}
