package local.tin.tests.crud.service.springboot.repositories;

import local.tin.tests.crud.model.persistence.Assembly;
import local.tin.tests.crud.model.persistence.embeddables.AssemblyId;
import org.springframework.stereotype.Repository;

/**
 *
 * @author benitodarder
 */
@Repository
public interface AssemblyRepo extends IEnableableRepositoryEmbedded<Assembly, AssemblyId> {
    
}
