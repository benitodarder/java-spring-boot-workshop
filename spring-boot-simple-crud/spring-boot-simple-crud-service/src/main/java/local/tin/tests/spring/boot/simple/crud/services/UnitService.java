package local.tin.tests.spring.boot.simple.crud.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import local.tin.tests.spring.boot.simple.crud.model.data.product.Unit;
import local.tin.tests.spring.boot.simple.crud.repositories.UnitRepository;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
 
@Service
public class UnitService {
     
    @Autowired
    UnitRepository repository;
     
    public List<Unit> getAllUnits() {
        List<Unit> employeeList = repository.findAll();
         
        if(employeeList.size() > 0) {
            return employeeList;
        } else {
            return new ArrayList<Unit>();
        }
    }
     
    public Unit getUnitById(Integer id) throws Exception {
        Optional<Unit> employee = repository.findById(id);
         
        if(employee.isPresent()) {
            return employee.get();
        } else {
            throw new Exception("No employee record exist for given id");
        }
    }
     
    public Unit createOrUpdateUnit(Unit entity) throws Exception {
        Optional<Unit> employee = repository.findById(entity.getId());
         
        if(employee.isPresent()) 
        {
            Unit newEntity = employee.get();
            newEntity.setEnabled(entity.isEnabled());
            newEntity.setName(entity.getName());
            newEntity.setAbbreviation(entity.getAbbreviation());
            newEntity = repository.save(newEntity);
             
            return newEntity;
        } else {
            entity = repository.save(entity);
             
            return entity;
        }
    } 
     
    public void deleteUnitById(Integer id) throws Exception  {
        Optional<Unit> employee = repository.findById(id);
         
        if(employee.isPresent()) 
        {
            repository.deleteById(id);
        } else {
            throw new Exception("No employee record exist for given id");
        }
    } 
}