package local.tin.tests.spring.boot.simple.crud.repositories;

import local.tin.tests.spring.boot.simple.crud.model.data.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author benitodarder
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
