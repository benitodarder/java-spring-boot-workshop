package local.tin.tests.crud.service.springboot.controllers;

import java.util.List;
import local.tin.tests.crud.model.domain.abstracts.AbstractNamed;
import local.tin.tests.crud.service.springboot.controllers.interfaces.INamedServiceBusinessController;
import local.tin.tests.crud.service.springboot.impl.AbstractNamedServiceBusiness;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author benitodarder
 * @param <N>
 */
public abstract class AbstractNamedServiceBusinessController<N extends AbstractNamed> extends AbstractServiceBusinessController<N> implements INamedServiceBusinessController<N> {
    

    @Override
    public ResponseEntity<N> create(N parameter) {
        return super.create(parameter);
    }

    @Override
    public ResponseEntity<N> retrieve(Integer id) {
        return super.retrieve(id);
    }

    @Override
    public ResponseEntity<N> update(N parameter) {
        return super.update(parameter);
    }

    @Override
    public ResponseEntity<N> delete(Integer id) {
        return super.delete(id);
    }
        

   @GetMapping("/byName/{name}")
   @Override
    public ResponseEntity<List<N>> retrieveByName(@PathVariable("name") String name) {
        List<N> items = ((AbstractNamedServiceBusiness) getService()).findByName(name);
        return new ResponseEntity<>(items, HttpStatus.OK);
    } 

}
