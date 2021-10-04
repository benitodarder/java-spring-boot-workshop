package local.tin.tests.crud.service.springboot.repositories.interfaces;

import local.tin.tests.crud.model.persistence.abstracts.AbstractEnableable;
import local.tin.tests.crud.model.persistence.interfaces.IEmbeddable;
import org.springframework.data.repository.NoRepositoryBean;

/**
 *
 * @author benitodarder
 * @param <N>
 */
@NoRepositoryBean
public interface IEnableableRepositoryEmbedded<N extends AbstractEnableable, K extends IEmbeddable> extends IRepositoryEmbedded<N, K>  {
    

    
}
