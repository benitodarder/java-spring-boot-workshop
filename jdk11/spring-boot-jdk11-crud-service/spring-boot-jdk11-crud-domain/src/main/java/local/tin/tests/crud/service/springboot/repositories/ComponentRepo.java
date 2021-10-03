package local.tin.tests.crud.service.springboot.repositories;

import local.tin.tests.crud.model.persistence.Component;
import org.springframework.stereotype.Repository;

/**
 *
 * @author benitodarder
 */
@Repository
public interface ComponentRepo extends INamedRepository<Component> {
    
}
