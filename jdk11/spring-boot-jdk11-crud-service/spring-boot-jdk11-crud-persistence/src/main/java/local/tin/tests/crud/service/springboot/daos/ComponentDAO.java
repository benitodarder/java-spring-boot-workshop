package local.tin.tests.crud.service.springboot.daos;


import local.tin.tests.crud.service.springboot.daos.abstracts.AbstractNamedDAO;
import local.tin.tests.crud.service.springboot.converters.abstracts.AbstractIdentifiableDomainToPersistence;
import local.tin.tests.crud.service.springboot.converters.abstracts.AbstractIdentifiablePersistenceToDomain;
import local.tin.tests.crud.service.springboot.converters.ComponentDomainToPersistence;
import local.tin.tests.crud.service.springboot.converters.ComponentPersistenceToDomain;
import local.tin.tests.crud.service.springboot.repositories.interfaces.IRepository;
import local.tin.tests.crud.service.springboot.repositories.ComponentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author benitodarder
 */
@Component
public class ComponentDAO extends AbstractNamedDAO<local.tin.tests.crud.model.domain.Component, local.tin.tests.crud.model.persistence.Component, Integer, Integer>{

    @Autowired
    private ComponentPersistenceToDomain superHeroPersistenceToBusiness;
    @Autowired
    private ComponentDomainToPersistence superHeroBusinessToPersistence;    
    @Autowired
    private ComponentRepo superHeroRepo;    
    
    @Override
    protected AbstractIdentifiableDomainToPersistence<local.tin.tests.crud.model.domain.Component, local.tin.tests.crud.model.persistence.Component, Integer> getBusinessToPersistence() {
        return superHeroBusinessToPersistence;
    }

    @Override
    protected AbstractIdentifiablePersistenceToDomain<local.tin.tests.crud.model.persistence.Component, local.tin.tests.crud.model.domain.Component, Integer> getPersistenceToBusiness() {
        return superHeroPersistenceToBusiness;
    }

    @Override
    protected IRepository<local.tin.tests.crud.model.persistence.Component> getRepository() {
        return superHeroRepo;
    }
    
}
