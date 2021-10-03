package local.tin.tests.spring.boot.simple.crud.repositories;

import local.tin.tests.spring.boot.simple.crud.model.data.product.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author benitodarder
 */
@Repository
public interface UnitRepository extends JpaRepository<Unit, Integer> {

}
