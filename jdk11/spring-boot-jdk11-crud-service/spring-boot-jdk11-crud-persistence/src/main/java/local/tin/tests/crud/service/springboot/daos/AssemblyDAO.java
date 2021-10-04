package local.tin.tests.crud.service.springboot.daos;

import local.tin.tests.crud.service.springboot.daos.abstracts.AbstractDAO;
import local.tin.tests.crud.model.domain.Assembly;
import local.tin.tests.crud.model.persistence.embeddables.AssemblyId;
import local.tin.tests.crud.service.springboot.converters.abstracts.AbstractIdentifiableDomainToPersistence;
import local.tin.tests.crud.service.springboot.converters.abstracts.AbstractIdentifiablePersistenceToDomain;
import local.tin.tests.crud.service.springboot.converters.AssemblyDomainToPersistence;
import local.tin.tests.crud.service.springboot.converters.AssemblyPersistenceToDomain;
import local.tin.tests.crud.service.springboot.repositories.interfaces.IRepository;
import local.tin.tests.crud.service.springboot.repositories.AssemblyRepo;
import local.tin.tests.crud.service.springboot.repositories.interfaces.IEnableableRepositoryEmbedded;
import local.tin.tests.crud.service.springboot.repositories.interfaces.IRepositoryEmbedded;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author benitodarder
 */
@Component
public class AssemblyDAO extends AbstractDAO<local.tin.tests.crud.model.domain.Assembly, local.tin.tests.crud.model.persistence.Assembly, AssemblyId>{

    @Autowired
    private AssemblyPersistenceToDomain superHeroPersistenceToBusiness;
    @Autowired
    private AssemblyDomainToPersistence superHeroBusinessToPersistence;    
    @Autowired
    private AssemblyRepo superHeroRepo;    
    
    @Override
    protected AbstractIdentifiableDomainToPersistence<Assembly, local.tin.tests.crud.model.persistence.Assembly> getBusinessToPersistence() {
        return superHeroBusinessToPersistence;
    }

    @Override
    protected AbstractIdentifiablePersistenceToDomain<local.tin.tests.crud.model.persistence.Assembly, Assembly> getPersistenceToBusiness() {
        return superHeroPersistenceToBusiness;
    }

    @Override
    protected IEnableableRepositoryEmbedded<local.tin.tests.crud.model.persistence.Assembly, AssemblyId> getRepository() {
        return superHeroRepo;
    }
    
}
