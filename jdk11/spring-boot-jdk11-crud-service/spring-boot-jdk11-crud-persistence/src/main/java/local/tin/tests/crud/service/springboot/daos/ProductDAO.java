package local.tin.tests.crud.service.springboot.daos;

import local.tin.tests.crud.service.springboot.daos.abstracts.AbstractNamedDAO;
import local.tin.tests.crud.model.domain.Product;
import local.tin.tests.crud.service.springboot.converters.abstracts.AbstractIdentifiableDomainToPersistence;
import local.tin.tests.crud.service.springboot.converters.abstracts.AbstractIdentifiablePersistenceToDomain;
import local.tin.tests.crud.service.springboot.converters.ProductDomainToPersistence;
import local.tin.tests.crud.service.springboot.converters.ProductPersistenceToDomain;
import local.tin.tests.crud.service.springboot.repositories.interfaces.IRepository;
import local.tin.tests.crud.service.springboot.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author benitodarder
 */
@Component
public class ProductDAO extends AbstractNamedDAO<local.tin.tests.crud.model.domain.Product, local.tin.tests.crud.model.persistence.Product, Integer, Integer>{

    @Autowired
    private ProductPersistenceToDomain superHeroPersistenceToBusiness;
    @Autowired
    private ProductDomainToPersistence superHeroBusinessToPersistence;    
    @Autowired
    private ProductRepo superHeroRepo;    
    
    @Override
    protected AbstractIdentifiableDomainToPersistence<Product, local.tin.tests.crud.model.persistence.Product, Integer> getBusinessToPersistence() {
        return superHeroBusinessToPersistence;
    }

    @Override
    protected AbstractIdentifiablePersistenceToDomain<local.tin.tests.crud.model.persistence.Product, Product, Integer> getPersistenceToBusiness() {
        return superHeroPersistenceToBusiness;
    }

    @Override
    protected IRepository<local.tin.tests.crud.model.persistence.Product> getRepository() {
        return superHeroRepo;
    }
    
}
