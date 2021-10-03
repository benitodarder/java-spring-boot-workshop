package local.tin.tests.crud.service.springboot.repositories;

import java.util.List;
import local.tin.tests.crud.model.persistence.abstracts.AbstractNamed;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

/**
 *
 * @author benitodarder
 * @param <N>
 */
@NoRepositoryBean
public interface INamedRepository<N extends AbstractNamed> extends IRepository<N>  {
    
 @Query("SELECT p FROM #{#entityName} p WHERE p.name LIKE %?1%")
    public List<N> findByName(String name);    
    
}
