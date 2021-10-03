package local.tin.tests.crud.service.springboot.repositories;

import local.tin.tests.crud.model.persistence.Assembly;
import org.springframework.stereotype.Repository;

/**
 *
 * @author benitodarder
 */
@Repository
public interface AssemblyRepo extends IEnableableRepository<Assembly> {
    
}
