package local.tin.tests.crud.service.springboot.repositories.interfaces;

import local.tin.tests.crud.model.persistence.interfaces.IIdentifiable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 *
 * @author benitodarder
 * @param <I>
 */
@NoRepositoryBean
public interface IRepository<I extends IIdentifiable> extends JpaRepository<I, Integer> {



}
