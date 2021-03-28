package local.tin.tests.spring.boot.simple.crud.controllers;

import java.util.List;
import local.tin.tests.spring.boot.simple.crud.model.data.product.Product;
import local.tin.tests.spring.boot.simple.crud.services.ProductService;

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
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> list = service.getAllProducts();

        return new ResponseEntity<List<Product>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Integer id) throws Exception {
        Product entity = service.getProductById(id);

        return new ResponseEntity<Product>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> createOrUpdateProduct(Product employee) throws Exception {
        Product updated = service.createOrUpdateProduct(employee);
        return new ResponseEntity<Product>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteProductById(@PathVariable("id") Integer id) throws Exception {
        service.deleteProductById(id);
        return HttpStatus.FORBIDDEN;
    }

}
