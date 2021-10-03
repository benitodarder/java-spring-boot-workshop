package local.tin.tests.crud.service.springboot.repositories;

import local.tin.tests.crud.model.persistence.abstracts.AbstractEnableable;
import org.springframework.data.repository.NoRepositoryBean;

/**
 *
 * @author benitodarder
 * @param <N>
 */
@NoRepositoryBean
public interface IEnableableRepository<N extends AbstractEnableable> extends IRepository<N>  {
    

    
}
