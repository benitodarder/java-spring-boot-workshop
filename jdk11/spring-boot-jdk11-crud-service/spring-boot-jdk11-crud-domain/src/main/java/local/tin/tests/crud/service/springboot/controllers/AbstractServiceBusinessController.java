package local.tin.tests.crud.service.springboot.controllers;

import local.tin.tests.crud.model.domain.abstracts.AbstractIdentifiable;
import local.tin.tests.crud.model.domain.exceptions.SuperException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import local.tin.tests.crud.service.springboot.controllers.interfaces.IServiceBusinessController;
import local.tin.tests.crud.service.springboot.impl.interfaces.IServiceBusiness;
/**
 *
 * @author benitodarder
 * @param <BI>
 */
public abstract class AbstractServiceBusinessController<BI extends AbstractIdentifiable> implements IServiceBusinessController<BI>{
    
    protected abstract IServiceBusiness<BI> getService();

    @Override
    public ResponseEntity<BI> create(BI parameter) {
        try {
            parameter = getService().create(parameter);
            return new ResponseEntity<>(parameter, HttpStatus.OK);
        } catch (SuperException ex) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @Override
    public ResponseEntity<BI> retrieve(Integer id) {
        try {
            BI item = getService().retrieve(id);
            if (item == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(item, HttpStatus.OK);
        } catch (SuperException ex) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @Override
    public ResponseEntity<BI> update(BI parameter) {
        try {
            getService().update(parameter);
            return new ResponseEntity<>(parameter, HttpStatus.OK);
        } catch (SuperException ex) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @Override
    public ResponseEntity<BI> delete(Integer id) {
        try {
            BI item = getService().retrieve(id);
            if (item == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }            
            getService().delete(id);
            return new ResponseEntity<>(item, HttpStatus.OK);
        } catch (SuperException ex) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
    
    @Override
    public ResponseEntity<List<BI>> retrieveAll() {
        try {
            List<BI> items = getService().findAll();
            return new ResponseEntity<>(items, HttpStatus.OK);
        } catch (SuperException ex) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }        
    }  
}
