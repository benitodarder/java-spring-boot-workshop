package local.tin.tests.crud.service.springboot.impl;

import local.tin.tests.crud.model.domain.exceptions.SuperException;
import java.util.List;
import local.tin.tests.crud.service.springboot.daos.interfaces.IAbstractDAO;
import local.tin.tests.crud.service.springboot.impl.interfaces.IServiceBusiness;

/**
 *
 * @author benitodarder
 * @param <BI>
 * @param <PI>
 */
public abstract class AbstractServiceBusiness<BI extends local.tin.tests.crud.model.domain.abstracts.AbstractIdentifiable, PI extends local.tin.tests.crud.model.persistence.abstracts.AbstractIdentifiable> implements IServiceBusiness<BI> {


    protected abstract IAbstractDAO<BI, PI> getDAO();

    @Override
    public BI create(BI item) throws SuperException {
        return getDAO().create(item);
    }

    @Override
    public BI retrieve(Object id) throws SuperException {
        return getDAO().retrieve(id);
    }

    @Override
    public BI update(BI item) throws SuperException {
        return getDAO().update(item);
    }
 
    @Override
    public void delete(Object id) throws SuperException {
        getDAO().delete((Integer) id);
    }

    @Override
    public List<BI> findAll() throws SuperException {
        return getDAO().findAll();
    }

}
