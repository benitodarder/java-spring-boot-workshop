package local.tin.tests.crud.service.springboot.impl;

import local.tin.tests.crud.service.springboot.impl.AbstractServiceBusiness;
import java.util.ArrayList;
import java.util.List;
import local.tin.tests.crud.model.domain.exceptions.SuperException;
import local.tin.tests.crud.model.persistence.abstracts.AbstractIdentifiable;
import local.tin.tests.crud.model.persistence.abstracts.AbstractNamed;
import local.tin.tests.crud.service.springboot.converters.AbstractIdentifiableDomainToPersistence;
import local.tin.tests.crud.service.springboot.converters.AbstractIdentifiablePersistenceToDomain;
import local.tin.tests.crud.service.springboot.daos.AbstractDAO;
import local.tin.tests.crud.service.springboot.daos.interfaces.IAbstractDAO;
import static local.tin.tests.crud.service.springboot.impl.AbstractNamedServiceBusinessTest.mockedAbstractDAO;
import local.tin.tests.crud.service.springboot.repositories.IRepository;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * @author benitodarder
 */
public class AbstractServiceBusinessTest {

    private static final int SAMPLE_ID = 666;
    protected static AbstractDAO mockedAbstractDAO;
    private AbstractServiceBusiness service;
    private local.tin.tests.crud.model.persistence.abstracts.AbstractIdentifiable mockedPersistence;
    private local.tin.tests.crud.model.domain.abstracts.AbstractIdentifiable mockedBusiness;

    @BeforeClass
    public static void setUpClass() {
        mockedAbstractDAO = mock(AbstractDAO.class);
    }

    @Before
    public void setUp() {
        service = new AbstractServiceBusinessWrapper();
        mockedPersistence = mock(local.tin.tests.crud.model.persistence.abstracts.AbstractIdentifiable.class);
        mockedBusiness = mock(local.tin.tests.crud.model.domain.abstracts.AbstractIdentifiable.class);
    }

    @Test
    public void create_calls_dao() throws local.tin.tests.crud.model.domain.exceptions.SuperException {

        service.create(mockedBusiness);

        verify(mockedAbstractDAO).create(mockedBusiness);
    }



    @Test
    public void retrieve_calls_dao() throws local.tin.tests.crud.model.domain.exceptions.SuperException {

        service.retrieve(SAMPLE_ID);

        verify(mockedAbstractDAO).retrieve(SAMPLE_ID);
    }



    @Test
    public void update_calls_dao() throws local.tin.tests.crud.model.domain.exceptions.SuperException {


        service.update(mockedBusiness);

        verify(mockedAbstractDAO).update(mockedBusiness);
    }



    @Test
    public void delete_removes_element() throws local.tin.tests.crud.model.domain.exceptions.SuperException {
        
        service.delete(SAMPLE_ID);

        verify(mockedAbstractDAO).delete(SAMPLE_ID);
    }

    @Test
    public void findAll_calls_dao() throws SuperException {

        
        List<local.tin.tests.crud.model.domain.abstracts.AbstractIdentifiable> result = service.findAll();
        
        verify(mockedAbstractDAO).findAll();
    }
}

class AbstractServiceBusinessWrapper extends AbstractServiceBusiness<local.tin.tests.crud.model.domain.abstracts.AbstractIdentifiable, local.tin.tests.crud.model.persistence.abstracts.AbstractIdentifiable> {

    @Override
    protected IAbstractDAO<local.tin.tests.crud.model.domain.abstracts.AbstractIdentifiable, AbstractIdentifiable> getDAO() {
        return AbstractServiceBusinessTest.mockedAbstractDAO;
    }    
}
