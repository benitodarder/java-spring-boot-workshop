package local.tin.tests.spring.boot.simple.crud.controllers;

import java.util.List;
import local.tin.tests.spring.boot.simple.crud.model.data.embeddables.AssemblyId;
import local.tin.tests.spring.boot.simple.crud.model.data.product.Assembly;
import local.tin.tests.spring.boot.simple.crud.services.AssemblyService;

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
@RequestMapping("/assemblies")
public class AssemblyController {

    @Autowired
    AssemblyService service;

    @GetMapping
    public ResponseEntity<List<Assembly>> getAllAssemblys() {
        List<Assembly> list = service.getAllAssemblys();

        return new ResponseEntity<List<Assembly>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Assembly> getAssemblyById(@PathVariable("compoenentId") Integer compoenentId, @PathVariable("productId") Integer productId)
            throws Exception {
        AssemblyId assemblyId = new AssemblyId();
        assemblyId.setComponentId(compoenentId);
        assemblyId.setProductId(productId);

        Assembly entity = service.getAssemblyById(assemblyId);

        return new ResponseEntity<Assembly>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Assembly> createOrUpdateAssembly(Assembly employee)
            throws Exception {
        Assembly updated = service.createOrUpdateAssembly(employee);
        return new ResponseEntity<Assembly>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/")
    public HttpStatus deleteAssemblyById(@PathVariable("compoenentId") Integer compoenentId, @PathVariable("productId") Integer productId)
            throws Exception {
        AssemblyId assemblyId = new AssemblyId();
        assemblyId.setComponentId(compoenentId);
        assemblyId.setProductId(productId);
        service.deleteAssemblyById(assemblyId);
        return HttpStatus.FORBIDDEN;
    }

}
