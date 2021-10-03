package local.tin.tests.crud.service.springboot.daos;


import local.tin.tests.crud.service.springboot.converters.AbstractIdentifiableDomainToPersistence;
import local.tin.tests.crud.service.springboot.converters.AbstractIdentifiablePersistenceToDomain;
import local.tin.tests.crud.service.springboot.converters.ComponentDomainToPersistence;
import local.tin.tests.crud.service.springboot.converters.ComponentPersistenceToDomain;
import local.tin.tests.crud.service.springboot.repositories.IRepository;
import local.tin.tests.crud.service.springboot.repositories.ComponentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author benitodarder
 */
@Component
public class ComponentDAO extends AbstractNamedDAO<local.tin.tests.crud.model.domain.Component, local.tin.tests.crud.model.persistence.Component>{

    @Autowired
    private ComponentPersistenceToDomain superHeroPersistenceToBusiness;
    @Autowired
    private ComponentDomainToPersistence superHeroBusinessToPersistence;    
    @Autowired
    private ComponentRepo superHeroRepo;    
    
    @Override
    protected AbstractIdentifiableDomainToPersistence<local.tin.tests.crud.model.domain.Component, local.tin.tests.crud.model.persistence.Component> getBusinessToPersistence() {
        return superHeroBusinessToPersistence;
    }

    @Override
    protected AbstractIdentifiablePersistenceToDomain<local.tin.tests.crud.model.persistence.Component, local.tin.tests.crud.model.domain.Component> getPersistenceToBusiness() {
        return superHeroPersistenceToBusiness;
    }

    @Override
    protected IRepository<local.tin.tests.crud.model.persistence.Component> getRepository() {
        return superHeroRepo;
    }
    
}
