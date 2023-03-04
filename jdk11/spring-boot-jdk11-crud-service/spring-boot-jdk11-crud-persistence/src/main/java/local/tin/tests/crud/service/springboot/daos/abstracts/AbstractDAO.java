package local.tin.tests.crud.service.springboot.daos.abstracts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import local.tin.tests.crud.model.domain.exceptions.SuperException;
import local.tin.tests.crud.service.springboot.converters.abstracts.AbstractIdentifiableDomainToPersistence;
import local.tin.tests.crud.service.springboot.converters.abstracts.AbstractIdentifiablePersistenceToDomain;
import local.tin.tests.crud.service.springboot.daos.interfaces.IAbstractDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author benitodarder
 * @param <BI>
 * @param <PI>
 */
public abstract class AbstractDAO<BI extends local.tin.tests.crud.model.domain.interfaces.IIdentifiable, PI extends local.tin.tests.crud.model.persistence.interfaces.IIdentifiable, KB extends Serializable, KP extends Serializable>  implements IAbstractDAO<BI, PI> {
  
    public static final int DEFAULT_DEPTH = 1;
    
    protected abstract JpaRepository<PI, KP> getRepository();
    
    protected abstract AbstractIdentifiableDomainToPersistence<BI, PI, KP> getBusinessToPersistence();

    protected abstract AbstractIdentifiablePersistenceToDomain<PI, BI, KB> getPersistenceToBusiness();

    protected BI convert(PI pi) {
        return getPersistenceToBusiness().convert(pi);
    }

    protected PI convert(BI bi) {
        return getBusinessToPersistence().convert(bi);
    }
    
   @Transactional
    @Override
    public BI create(BI item) throws SuperException {
        PI pi = convert(item);
        pi = getRepository().save(pi);
        return convert(pi);
    }

    @Transactional    
    @Override
    public BI retrieve(BI item) throws SuperException {
        PI pi = getRepository().getOne((KP) convert(item).getId());
        if (pi == null) {
            return null;
        }
        return convert(pi);
    }

    @Transactional    
    @Override
    public BI update(BI item) throws SuperException {
        if (retrieve(item) == null) {
            throw new SuperException(item.getClass().getName() + " not found for id: " + item.getId());
        }
        PI pi = convert(item);
        pi = getRepository().save(pi);
        return convert(pi);
    }

    @Transactional    
    @Override
    public void delete(BI item) throws SuperException {
        if (retrieve(item) == null) {
            throw new SuperException("Element not found for id: " + item.getId());
        }
        getRepository().deleteById((KP) convert(item).getId());
    }

    @Transactional    
    @Override
    public List<BI> findAll() throws SuperException {
        List<PI> persistenceItems = getRepository().findAll();
        List<BI> businessItems = new ArrayList<>();
        persistenceItems.forEach((current) -> {
            businessItems.add(convert(current));
        });
        return businessItems;
    }
        
    
}
