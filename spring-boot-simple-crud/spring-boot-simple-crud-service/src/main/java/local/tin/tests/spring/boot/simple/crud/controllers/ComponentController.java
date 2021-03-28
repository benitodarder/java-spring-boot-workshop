package local.tin.tests.spring.boot.simple.crud.controllers;

import java.util.List;
import local.tin.tests.spring.boot.simple.crud.model.data.product.Component;
import local.tin.tests.spring.boot.simple.crud.services.ComponentService;

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
@RequestMapping("/components")
public class ComponentController {

    @Autowired
    ComponentService service;

    @GetMapping
    public ResponseEntity<List<Component>> getAllComponents() {
        List<Component> list = service.getAllComponents();

        return new ResponseEntity<List<Component>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Component> getComponentById(@PathVariable("id") Integer id) throws Exception {
        Component entity = service.getComponentById(id);

        return new ResponseEntity<Component>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Component> createOrUpdateComponent(Component employee) throws Exception {
        Component updated = service.createOrUpdateComponent(employee);
        return new ResponseEntity<Component>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteComponentById(@PathVariable("id") Integer id) throws Exception {
        service.deleteComponentById(id);
        return HttpStatus.FORBIDDEN;
    }

}
