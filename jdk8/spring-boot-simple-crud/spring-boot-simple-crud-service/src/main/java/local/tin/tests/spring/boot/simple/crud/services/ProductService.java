package local.tin.tests.spring.boot.simple.crud.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import local.tin.tests.spring.boot.simple.crud.model.data.product.Product;
import local.tin.tests.spring.boot.simple.crud.repositories.ProductRepository;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
 
@Service
public class ProductService {
     
    @Autowired
    ProductRepository repository;
     
    public List<Product> getAllProducts() {
        List<Product> employeeList = repository.findAll();
         
        if(employeeList.size() > 0) {
            return employeeList;
        } else {
            return new ArrayList<Product>();
        }
    }
     
    public Product getProductById(Integer id) throws Exception {
        Optional<Product> employee = repository.findById(id);
         
        if(employee.isPresent()) {
            return employee.get();
        } else {
            throw new Exception("No employee record exist for given id");
        }
    }
     
    public Product createOrUpdateProduct(Product entity) throws Exception {
        Optional<Product> employee = repository.findById(entity.getId());
         
        if(employee.isPresent()) 
        {
            Product newEntity = employee.get();
            newEntity.setEnabled(entity.isEnabled());
            newEntity.setName(entity.getName());
            newEntity.setDescription(entity.getDescription());
            newEntity = repository.save(newEntity);
             
            return newEntity;
        } else {
            entity = repository.save(entity);
             
            return entity;
        }
    } 
     
    public void deleteProductById(Integer id) throws Exception  {
        Optional<Product> employee = repository.findById(id);
         
        if(employee.isPresent()) 
        {
            repository.deleteById(id);
        } else {
            throw new Exception("No employee record exist for given id");
        }
    } 
}