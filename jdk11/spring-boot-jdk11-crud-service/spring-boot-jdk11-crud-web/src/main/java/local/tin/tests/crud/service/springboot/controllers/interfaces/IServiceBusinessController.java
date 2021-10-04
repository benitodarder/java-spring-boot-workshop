package local.tin.tests.crud.service.springboot.controllers.interfaces;

import local.tin.tests.crud.model.domain.interfaces.IIdentifiable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
    
    @PostMapping("/retrieve")
    public ResponseEntity<I> retrieve(@RequestBody I parameter);
    
    @PostMapping("/update")
    public ResponseEntity<I> update(@RequestBody I parameter);
    
    @PostMapping("/delete")
    public ResponseEntity<I> delete(@RequestBody I parameter);
    
    @GetMapping("/all")
    public ResponseEntity<List<I>> retrieveAll();  
}
