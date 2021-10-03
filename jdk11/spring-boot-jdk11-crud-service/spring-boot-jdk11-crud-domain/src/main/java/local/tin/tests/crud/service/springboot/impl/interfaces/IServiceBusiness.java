package local.tin.tests.crud.service.springboot.impl.interfaces;

import local.tin.tests.crud.model.domain.abstracts.AbstractIdentifiable;
import local.tin.tests.crud.model.domain.exceptions.SuperException;
import java.util.List;
/**
 *
 * @author benitodarder
 * @param <BI>
 */
public interface IServiceBusiness<BI extends AbstractIdentifiable> {

    public BI create(BI item) throws SuperException;

    public BI retrieve(Object id) throws SuperException;

    public BI update(BI item) throws SuperException;

    public void delete(Object id) throws SuperException;

    public List<BI> findAll() throws SuperException;

}
