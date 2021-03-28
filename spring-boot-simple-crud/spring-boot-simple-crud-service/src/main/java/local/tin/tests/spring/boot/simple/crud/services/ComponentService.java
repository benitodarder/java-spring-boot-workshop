package local.tin.tests.spring.boot.simple.crud.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import local.tin.tests.spring.boot.simple.crud.model.data.product.Component;
import local.tin.tests.spring.boot.simple.crud.repositories.ComponentRepository;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
 
@Service
public class ComponentService {
     
    @Autowired
    ComponentRepository repository;
     
    public List<Component> getAllComponents() {
        List<Component> employeeList = repository.findAll();
         
        if(employeeList.size() > 0) {
            return employeeList;
        } else {
            return new ArrayList<Component>();
        }
    }
     
    public Component getComponentById(Integer id) throws Exception {
        Optional<Component> employee = repository.findById(id);
         
        if(employee.isPresent()) {
            return employee.get();
        } else {
            throw new Exception("No employee record exist for given id");
        }
    }
     
    public Component createOrUpdateComponent(Component entity) throws Exception {
        Optional<Component> employee = repository.findById(entity.getId());
         
        if(employee.isPresent()) 
        {
            Component newEntity = employee.get();
            newEntity.setEnabled(entity.isEnabled());
            newEntity.setName(entity.getName());
            newEntity.setUnit(entity.getUnit());
 
            newEntity = repository.save(newEntity);
             
            return newEntity;
        } else {
            entity = repository.save(entity);
             
            return entity;
        }
    } 
     
    public void deleteComponentById(Integer id) throws Exception  {
        Optional<Component> employee = repository.findById(id);
         
        if(employee.isPresent()) 
        {
            repository.deleteById(id);
        } else {
            throw new Exception("No employee record exist for given id");
        }
    } 
}