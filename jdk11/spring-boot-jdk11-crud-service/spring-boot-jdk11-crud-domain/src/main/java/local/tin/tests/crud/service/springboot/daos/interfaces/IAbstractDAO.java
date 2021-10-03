package local.tin.tests.crud.service.springboot.daos.interfaces;

import java.util.List;
import local.tin.tests.crud.model.domain.exceptions.SuperException;

/**
 *
 * @author benitodarder
 * @param <BI>
 * @param <PI>
 */
public interface IAbstractDAO<BI extends local.tin.tests.crud.model.domain.interfaces.IIdentifiable, PI extends local.tin.tests.crud.model.persistence.interfaces.IIdentifiable> {
        
    public BI create(BI bi) throws SuperException;
    
    public BI retrieve(Object id) throws SuperException;
    
    public BI update(BI bi) throws SuperException;
    
    public void delete(Object id) throws SuperException;
    
    public List<BI> findAll() throws SuperException;
    
}
