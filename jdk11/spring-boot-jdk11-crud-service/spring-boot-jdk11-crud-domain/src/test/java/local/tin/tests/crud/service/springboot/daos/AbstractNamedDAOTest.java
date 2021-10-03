package local.tin.tests.crud.service.springboot.daos;

import local.tin.tests.crud.service.springboot.daos.AbstractDAO;
import local.tin.tests.crud.service.springboot.daos.AbstractNamedDAO;
import java.util.ArrayList;
import java.util.List;
import local.tin.tests.crud.model.domain.exceptions.SuperException;
import local.tin.tests.crud.model.persistence.abstracts.AbstractNamed;
import local.tin.tests.crud.service.springboot.Domain;
import local.tin.tests.crud.service.springboot.Persistence;
import local.tin.tests.crud.service.springboot.converters.AbstractIdentifiableDomainToPersistence;
import local.tin.tests.crud.service.springboot.converters.AbstractIdentifiablePersistenceToDomain;
import static local.tin.tests.crud.service.springboot.daos.AbstractDAOTest.mockedAbstractIdentifiableBusinessToPersistence;
import static local.tin.tests.crud.service.springboot.daos.AbstractDAOTest.mockedAbstractIdentifiablePersistenceToBusiness;
import static local.tin.tests.crud.service.springboot.daos.AbstractDAOTest.mockedRespository;
import local.tin.tests.crud.service.springboot.daos.interfaces.IAbstractDAO;
import local.tin.tests.crud.service.springboot.impl.AbstractNamedServiceBusiness;
import local.tin.tests.crud.service.springboot.repositories.INamedRepository;
import local.tin.tests.crud.service.springboot.repositories.IRepository;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author benitodarder
 */
public class AbstractNamedDAOTest {
    private static final int SAMPLE_ID = 666;
    private static final String SAMPLE_NAME = "Name";
    protected static AbstractIdentifiableDomainToPersistence<Domain, Persistence> mockedAbstractIdentifiableBusinessToPersistence;
    protected static AbstractIdentifiablePersistenceToDomain<Persistence, Domain> mockedAbstractIdentifiablePersistenceToBusiness;
    protected static INamedRepository<Persistence> mockedRespository;
    private AbstractNamedDAO dao;
    private Persistence mockedPersistence;
    private Domain mockedBusiness;

    @BeforeClass
    public static void setUpClass() {
        mockedRespository = mock(INamedRepository.class);
        mockedAbstractIdentifiableBusinessToPersistence = mock(AbstractIdentifiableDomainToPersistence.class);
        mockedAbstractIdentifiablePersistenceToBusiness = mock(AbstractIdentifiablePersistenceToDomain.class);
    }


    @Before
    public void setUp() {
        dao = new AbstractNamedDAOWrapper();
        mockedPersistence = mock(Persistence.class);
        mockedBusiness = mock(Domain.class);
    }

    
   @Test
    public void findAll_returns_persistence_elements_converted() throws SuperException {
        Persistence mockedPersistenceAlt = mock(Persistence.class);
        Domain mockedBusinessAlt = mock(Domain.class);
        when(mockedAbstractIdentifiablePersistenceToBusiness.convert(mockedPersistence, AbstractDAO.DEFAULT_DEPTH)).thenReturn(mockedBusiness);        
        when(mockedAbstractIdentifiablePersistenceToBusiness.convert(mockedPersistenceAlt, AbstractDAO.DEFAULT_DEPTH)).thenReturn(mockedBusinessAlt);                
        List<Persistence> persisntenceItems = new ArrayList<>();
        persisntenceItems.add(mockedPersistence);
        persisntenceItems.add(mockedPersistenceAlt);
        when(mockedRespository.findByName(SAMPLE_NAME)).thenReturn(persisntenceItems);

        
        List<Domain> result = dao.findByName(SAMPLE_NAME);
        
        assertEquals(persisntenceItems.size(), result.size());
        assertTrue(result.contains(mockedBusiness));
        assertTrue(result.contains(mockedBusinessAlt));
    }
}

class AbstractNamedDAOWrapper extends AbstractNamedDAO<Domain, Persistence> {

    @Override
    protected IRepository<Persistence> getRepository() {
        return AbstractNamedDAOTest.mockedRespository;
    }

    @Override
    protected AbstractIdentifiableDomainToPersistence<Domain, Persistence> getBusinessToPersistence() {
        return AbstractNamedDAOTest.mockedAbstractIdentifiableBusinessToPersistence;
    }

    @Override
    protected AbstractIdentifiablePersistenceToDomain<Persistence, Domain> getPersistenceToBusiness() {
        return AbstractNamedDAOTest.mockedAbstractIdentifiablePersistenceToBusiness;
    }





}

