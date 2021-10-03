package local.tin.tests.crud.service.springboot.controllers.interfaces;

import java.util.List;
import local.tin.tests.crud.model.domain.interfaces.INamed;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author benitodarder
 * @param <N>
 */
public interface INamedServiceBusinessController<N extends INamed> {
    
    @GetMapping("/byName/{name}")
    public ResponseEntity<List<N>> retrieveByName(@PathVariable("name") String name);    
    
}
