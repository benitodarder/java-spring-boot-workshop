package local.tin.tests.crud.service.springboot.repositories;

import local.tin.tests.crud.model.persistence.Product;
import org.springframework.stereotype.Repository;

/**
 *
 * @author benitodarder
 */
@Repository
public interface ProductRepo extends INamedRepository<Product> {
    
}
