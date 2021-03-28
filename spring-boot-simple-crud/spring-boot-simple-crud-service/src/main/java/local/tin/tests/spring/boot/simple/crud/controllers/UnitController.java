package local.tin.tests.spring.boot.simple.crud.controllers;

import java.util.List;
import local.tin.tests.spring.boot.simple.crud.model.data.product.Unit;
import local.tin.tests.spring.boot.simple.crud.services.UnitService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/units")
public class UnitController {

    @Autowired
    UnitService service;

    @GetMapping
    public ResponseEntity<List<Unit>> getAllUnits() {
        List<Unit> list = service.getAllUnits();

        return new ResponseEntity<List<Unit>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Unit> getUnitById(@PathVariable("id") Integer id) throws Exception {
        Unit entity = service.getUnitById(id);

        return new ResponseEntity<Unit>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Unit> createOrUpdateUnit(Unit employee) throws Exception {
        Unit updated = service.createOrUpdateUnit(employee);
        return new ResponseEntity<Unit>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteUnitById(@PathVariable("id") Integer id) throws Exception {
        service.deleteUnitById(id);
        return HttpStatus.FORBIDDEN;
    }

}
