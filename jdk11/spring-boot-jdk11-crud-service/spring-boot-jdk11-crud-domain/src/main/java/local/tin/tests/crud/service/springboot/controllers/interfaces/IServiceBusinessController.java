package local.tin.tests.crud.service.springboot.controllers.interfaces;

import local.tin.tests.crud.model.domain.interfaces.IIdentifiable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
/**
 *
 * @author benitodarder
 * @param <I>
 */
public interface IServiceBusinessController<I extends IIdentifiable> {
    
    @PostMapping("create")
    public ResponseEntity<I> create(@RequestBody I parameter);
    
    @GetMapping("/{id}")
    public ResponseEntity<I> retrieve(@PathVariable("id") Integer id);
    
    @PostMapping("/update")
    public ResponseEntity<I> update(@RequestBody I parameter);
    
    @DeleteMapping("/{id}")
    public ResponseEntity<I> delete(@PathVariable("id") Integer id);
    
    @GetMapping("/all")
    public ResponseEntity<List<I>> retrieveAll();  
}
