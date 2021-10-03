package local.tin.tests.crud.service.springboot.impl;

import local.tin.tests.crud.service.springboot.impl.AbstractNamedServiceBusiness;
import java.util.ArrayList;
import java.util.List;
import local.tin.tests.crud.model.domain.exceptions.SuperException;
import local.tin.tests.crud.model.persistence.abstracts.AbstractNamed;
import local.tin.tests.crud.service.springboot.converters.AbstractIdentifiablePersistenceToDomain;
import local.tin.tests.crud.service.springboot.converters.AbstractNamedDomainToPersistence;
import local.tin.tests.crud.service.springboot.converters.AbstractNamedPersistenceToDomain;
import local.tin.tests.crud.service.springboot.daos.AbstractDAO;
import local.tin.tests.crud.service.springboot.daos.AbstractNamedDAO;
import local.tin.tests.crud.service.springboot.daos.interfaces.IAbstractDAO;
import local.tin.tests.crud.service.springboot.repositories.INamedRepository;
import local.tin.tests.crud.service.springboot.repositories.IRepository;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * @author benitodarder
 */
public class AbstractNamedServiceBusinessTest {

    private static final int SAMPLE_ID = 666;
    private static final String SAMPLE_NAME = "Name";
    protected static AbstractNamedDAO mockedAbstractDAO;
    private AbstractNamedServiceBusiness service;
    private local.tin.tests.crud.model.persistence.abstracts.AbstractNamed mockedPersistence;
    private local.tin.tests.crud.model.domain.abstracts.AbstractNamed mockedBusiness;

    @BeforeClass
    public static void setUpClass() {
        mockedAbstractDAO = mock(AbstractNamedDAO.class);
    }

    @Before
    public void setUp() {
        service = new AbstractNamedServiceBusinessWrapper();
        mockedPersistence = mock(local.tin.tests.crud.model.persistence.abstracts.AbstractNamed.class);
        mockedBusiness = mock(local.tin.tests.crud.model.domain.abstracts.AbstractNamed.class);
    }

    
   @Test
    public void findAll_calls_dao() throws SuperException {
        
        List<local.tin.tests.crud.model.domain.abstracts.AbstractNamed> result = service.findByName(SAMPLE_NAME);
        
        verify(mockedAbstractDAO).findByName(SAMPLE_NAME);
    }
}

class AbstractNamedServiceBusinessWrapper extends AbstractNamedServiceBusiness<local.tin.tests.crud.model.domain.abstracts.AbstractNamed, local.tin.tests.crud.model.persistence.abstracts.AbstractNamed> {



    @Override
    protected IAbstractDAO<local.tin.tests.crud.model.domain.abstracts.AbstractNamed, AbstractNamed> getDAO() {
        return AbstractNamedServiceBusinessTest.mockedAbstractDAO;
    }

}
