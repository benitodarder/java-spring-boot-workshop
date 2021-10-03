package local.tin.tests.crud.service.springboot.repositories;

import local.tin.tests.crud.model.persistence.interfaces.IEmbeddable;
import local.tin.tests.crud.model.persistence.interfaces.IIdentifiable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 *
 * @author benitodarder
 * @param <I>
 */
@NoRepositoryBean
public interface IRepositoryEmbedded<I extends IIdentifiable, K extends IEmbeddable> extends JpaRepository<I, K> {



}
