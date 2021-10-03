package local.tin.tests.crud.service.springboot.daos;

import java.util.ArrayList;
import java.util.List;
import local.tin.tests.crud.model.domain.exceptions.SuperException;
import local.tin.tests.crud.service.springboot.converters.AbstractIdentifiableDomainToPersistence;
import local.tin.tests.crud.service.springboot.converters.AbstractIdentifiablePersistenceToDomain;
import local.tin.tests.crud.service.springboot.daos.interfaces.IAbstractDAO;
import local.tin.tests.crud.service.springboot.repositories.IRepository;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author benitodarder
 * @param <BI>
 * @param <PI>
 */
public abstract class AbstractDAO<BI extends local.tin.tests.crud.model.domain.interfaces.IIdentifiable, PI extends local.tin.tests.crud.model.persistence.interfaces.IIdentifiable>  implements IAbstractDAO<BI, PI> {
  
    public static final int DEFAULT_DEPTH = 1;
    
    protected abstract IRepository<PI> getRepository();
    
    protected abstract AbstractIdentifiableDomainToPersistence<BI, PI> getBusinessToPersistence();

    protected abstract AbstractIdentifiablePersistenceToDomain<PI, BI> getPersistenceToBusiness();

    protected BI convert(PI pi) {
        return getPersistenceToBusiness().convert(pi, DEFAULT_DEPTH);
    }

    protected PI convert(BI bi) {
        return getBusinessToPersistence().convert(bi,DEFAULT_DEPTH);
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
    public BI retrieve(Object id) throws SuperException {
        PI pi = getRepository().getOne((Integer) id);
        if (pi == null) {
            return null;
        }
        return convert(pi);
    }

    @Transactional    
    @Override
    public BI update(BI item) throws SuperException {
        if (retrieve(item.getId()) == null) {
            throw new SuperException(item.getClass().getName() + " not found for id: " + item.getId());
        }
        PI pi = convert(item);
        pi = getRepository().save(pi);
        return convert(pi);
    }

    @Transactional    
    @Override
    public void delete(Object id) throws SuperException {
        if (retrieve(id) == null) {
            throw new SuperException("Element not found for id: " + id);
        }
        getRepository().deleteById((Integer) id);
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
