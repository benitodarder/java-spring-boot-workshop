package local.tin.tests.spring.boot.simple.crud.repositories;

import local.tin.tests.spring.boot.simple.crud.model.data.embeddables.AssemblyId;
import local.tin.tests.spring.boot.simple.crud.model.data.product.Assembly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author benitodarder
 */
@Repository
public interface AssemblyRepository extends JpaRepository<Assembly, AssemblyId> {

}
