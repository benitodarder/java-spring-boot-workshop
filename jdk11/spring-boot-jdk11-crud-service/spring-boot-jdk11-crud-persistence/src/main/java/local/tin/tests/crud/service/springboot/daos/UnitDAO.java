package local.tin.tests.crud.service.springboot.daos;

import local.tin.tests.crud.service.springboot.daos.abstracts.AbstractNamedDAO;
import local.tin.tests.crud.model.domain.Unit;
import local.tin.tests.crud.service.springboot.converters.abstracts.AbstractIdentifiableDomainToPersistence;
import local.tin.tests.crud.service.springboot.converters.abstracts.AbstractIdentifiablePersistenceToDomain;
import local.tin.tests.crud.service.springboot.converters.UnitDomainToPersistence;
import local.tin.tests.crud.service.springboot.converters.UnitPersistenceToDomain;
import local.tin.tests.crud.service.springboot.repositories.interfaces.IRepository;
import local.tin.tests.crud.service.springboot.repositories.UnitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author benitodarder
 */
@Component
public class UnitDAO extends AbstractNamedDAO<local.tin.tests.crud.model.domain.Unit, local.tin.tests.crud.model.persistence.Unit>{

    @Autowired
    private UnitPersistenceToDomain superHeroPersistenceToBusiness;
    @Autowired
    private UnitDomainToPersistence superHeroBusinessToPersistence;    
    @Autowired
    private UnitRepo superHeroRepo;    
    
    @Override
    protected AbstractIdentifiableDomainToPersistence<Unit, local.tin.tests.crud.model.persistence.Unit> getBusinessToPersistence() {
        return superHeroBusinessToPersistence;
    }

    @Override
    protected AbstractIdentifiablePersistenceToDomain<local.tin.tests.crud.model.persistence.Unit, Unit> getPersistenceToBusiness() {
        return superHeroPersistenceToBusiness;
    }

    @Override
    protected IRepository<local.tin.tests.crud.model.persistence.Unit> getRepository() {
        return superHeroRepo;
    }
    
}
