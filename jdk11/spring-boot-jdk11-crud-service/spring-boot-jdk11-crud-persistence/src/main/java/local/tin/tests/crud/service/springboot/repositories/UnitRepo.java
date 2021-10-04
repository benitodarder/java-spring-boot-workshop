package local.tin.tests.crud.service.springboot.repositories;

import local.tin.tests.crud.service.springboot.repositories.interfaces.INamedRepository;
import local.tin.tests.crud.model.persistence.Unit;
import org.springframework.stereotype.Repository;

/**
 *
 * @author benitodarder
 */
@Repository
public interface UnitRepo extends INamedRepository<Unit> {
    
}
