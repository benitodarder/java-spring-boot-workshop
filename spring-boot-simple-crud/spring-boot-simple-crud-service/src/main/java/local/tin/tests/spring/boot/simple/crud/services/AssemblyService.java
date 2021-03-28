package local.tin.tests.spring.boot.simple.crud.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import local.tin.tests.spring.boot.simple.crud.model.data.embeddables.AssemblyId;
import local.tin.tests.spring.boot.simple.crud.model.data.product.Assembly;
import local.tin.tests.spring.boot.simple.crud.repositories.AssemblyRepository;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
 
@Service
public class AssemblyService {
     
    @Autowired
    AssemblyRepository repository;
     
    public List<Assembly> getAllAssemblys() {
        List<Assembly> employeeList = repository.findAll();
         
        if(employeeList.size() > 0) {
            return employeeList;
        } else {
            return new ArrayList<Assembly>();
        }
    }
     
    public Assembly getAssemblyById(AssemblyId id) throws Exception {
        Optional<Assembly> employee = repository.findById(id);
         
        if(employee.isPresent()) {
            return employee.get();
        } else {
            throw new Exception("No employee record exist for given id");
        }
    }
     
    public Assembly createOrUpdateAssembly(Assembly entity) throws Exception {
        Optional<Assembly> employee = repository.findById(entity.getId());
         
        if(employee.isPresent()) 
        {
            Assembly newEntity = employee.get();
            newEntity.setComponent(entity.getComponent());
            newEntity.setEnabled(entity.isEnabled());
            newEntity.setProduct(entity.getProduct());
            newEntity.setQuantity(entity.getQuantity());
 
            newEntity = repository.save(newEntity);
             
            return newEntity;
        } else {
            entity = repository.save(entity);
             
            return entity;
        }
    } 
     
    public void deleteAssemblyById(AssemblyId id) throws Exception  {
        Optional<Assembly> employee = repository.findById(id);
         
        if(employee.isPresent()) 
        {
            repository.deleteById(id);
        } else {
            throw new Exception("No employee record exist for given id");
        }
    } 
}