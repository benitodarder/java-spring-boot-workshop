package local.tin.tests.crud.service.springboot.daos.abstracts;

import local.tin.tests.crud.service.springboot.daos.abstracts.AbstractDAO;
import java.util.ArrayList;
import java.util.List;
import local.tin.tests.crud.model.domain.exceptions.SuperException;
import local.tin.tests.crud.model.persistence.abstracts.AbstractIdentifiable;
import local.tin.tests.crud.service.springboot.Domain;
import local.tin.tests.crud.service.springboot.Persistence;
import local.tin.tests.crud.service.springboot.converters.abstracts.AbstractIdentifiableDomainToPersistence;
import local.tin.tests.crud.service.springboot.converters.abstracts.AbstractIdentifiablePersistenceToDomain;
import local.tin.tests.crud.service.springboot.repositories.interfaces.IRepository;
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
public class AbstractDAOTest {

    private static final int SAMPLE_ID = 666;
    protected static AbstractIdentifiableDomainToPersistence<Domain, Persistence, Integer> mockedAbstractIdentifiableBusinessToPersistence;
    protected static AbstractIdentifiablePersistenceToDomain<Persistence, Domain, Integer> mockedAbstractIdentifiablePersistenceToBusiness;
    protected static IRepository<Persistence> mockedRespository;
    private Domain mockedBusiness;
    private Persistence mockedPersistence;
    private AbstractDAO dao;

    @BeforeClass
    public static void setUpClass() {
        mockedRespository = mock(IRepository.class);
        mockedAbstractIdentifiableBusinessToPersistence = mock(AbstractIdentifiableDomainToPersistence.class);
        mockedAbstractIdentifiablePersistenceToBusiness = mock(AbstractIdentifiablePersistenceToDomain.class);
    }

    @Before
    public void setUp() {
        reset(mockedAbstractIdentifiableBusinessToPersistence);
        reset(mockedAbstractIdentifiablePersistenceToBusiness);        
        dao = new AbstractDAOWrapper();
        mockedBusiness = mock(Domain.class);
        when(mockedBusiness.getId()).thenReturn(SAMPLE_ID);
        mockedPersistence = mock(Persistence.class);
        when(mockedPersistence.getId()).thenReturn(SAMPLE_ID);
        when(mockedAbstractIdentifiableBusinessToPersistence.convert(mockedBusiness)).thenReturn(mockedPersistence);
        when(mockedAbstractIdentifiablePersistenceToBusiness.convert(mockedPersistence)).thenReturn(mockedBusiness);
    }

    @Test
    public void convert_bi_to_pi_returns_expected_result() {
        when(mockedAbstractIdentifiableBusinessToPersistence.convert(mockedBusiness, AbstractDAO.DEFAULT_DEPTH)).thenReturn(mockedPersistence);

        Persistence result = (Persistence) dao.convert(mockedBusiness);

        assertEquals(mockedPersistence, result);
    }

    @Test
    public void convert_pi_to_bi_returns_expected_result() {
        when(mockedAbstractIdentifiablePersistenceToBusiness.convert(mockedPersistence, AbstractDAO.DEFAULT_DEPTH)).thenReturn(mockedBusiness);

        Domain result = (Domain) dao.convert(mockedPersistence);

        assertEquals(mockedBusiness, result);
    }

    @Test
    public void create_converts_to_persistence_model() throws local.tin.tests.crud.model.domain.exceptions.SuperException {

        dao.create(mockedBusiness);

        verify(mockedAbstractIdentifiableBusinessToPersistence).convert(mockedBusiness);
    }

    @Test
    public void create_stores_persistence_model() throws local.tin.tests.crud.model.domain.exceptions.SuperException {
        when(mockedAbstractIdentifiableBusinessToPersistence.convert(mockedBusiness, AbstractDAO.DEFAULT_DEPTH)).thenReturn(mockedPersistence);

        dao.create(mockedBusiness);

        verify(mockedRespository).save(mockedPersistence);
    }

    @Test
    public void create_returns_converted_persisted_item() throws local.tin.tests.crud.model.domain.exceptions.SuperException {
        when(mockedAbstractIdentifiableBusinessToPersistence.convert(mockedBusiness, AbstractDAO.DEFAULT_DEPTH)).thenReturn(mockedPersistence);
        when(mockedRespository.save(mockedPersistence)).thenReturn(mockedPersistence);

        dao.create(mockedBusiness);

        verify(mockedAbstractIdentifiablePersistenceToBusiness).convert(mockedPersistence);
    }

    @Test
    public void create_converts_peristence_model_to_business() throws local.tin.tests.crud.model.domain.exceptions.SuperException {
        when(mockedAbstractIdentifiableBusinessToPersistence.convert(mockedBusiness, AbstractDAO.DEFAULT_DEPTH)).thenReturn(mockedPersistence);
        when(mockedRespository.save(mockedPersistence)).thenReturn(mockedPersistence);
        when(mockedAbstractIdentifiablePersistenceToBusiness.convert(mockedPersistence, AbstractDAO.DEFAULT_DEPTH)).thenReturn(mockedBusiness);

        local.tin.tests.crud.model.domain.interfaces.IIdentifiable result = dao.create(mockedBusiness);

        assertEquals(result, mockedBusiness);
    }

    @Test
    public void retrieve_converts_persistence_to_business_when_found() throws local.tin.tests.crud.model.domain.exceptions.SuperException {
        when(mockedRespository.getOne(SAMPLE_ID)).thenReturn(mockedPersistence);

        dao.retrieve(mockedBusiness);

        verify(mockedAbstractIdentifiablePersistenceToBusiness).convert(mockedPersistence);
    }

    @Test
    public void retrieve_returns_null_when_not_found() throws local.tin.tests.crud.model.domain.exceptions.SuperException {
        when(mockedRespository.getOne(SAMPLE_ID)).thenReturn(null);

        local.tin.tests.crud.model.domain.interfaces.IIdentifiable result = dao.retrieve(mockedBusiness);

        assertNull(result);
    }

    @Test
    public void update_converts_to_persistence_model() throws local.tin.tests.crud.model.domain.exceptions.SuperException {
        when(mockedRespository.getOne(SAMPLE_ID)).thenReturn(mockedPersistence);
        
        dao.update(mockedBusiness);

        verify(mockedAbstractIdentifiableBusinessToPersistence, times(2)).convert(mockedBusiness);
    }

    @Test
    public void update_stores_persistence_model() throws local.tin.tests.crud.model.domain.exceptions.SuperException {
        when(mockedRespository.getOne(SAMPLE_ID)).thenReturn(mockedPersistence);

        dao.update(mockedBusiness);

        verify(mockedRespository).save(mockedPersistence);
    }

    @Test
    public void update_converts_persistence_to_business() throws local.tin.tests.crud.model.domain.exceptions.SuperException {
        when(mockedRespository.getOne(SAMPLE_ID)).thenReturn(mockedPersistence);
        when(mockedRespository.save(mockedPersistence)).thenReturn(mockedPersistence);

        dao.update(mockedBusiness);

        verify(mockedAbstractIdentifiablePersistenceToBusiness, times(2)).convert(mockedPersistence);

    }

    @Test(expected = local.tin.tests.crud.model.domain.exceptions.SuperException.class)
    public void update_throws_exception_when_not_found() throws local.tin.tests.crud.model.domain.exceptions.SuperException {
        when(mockedRespository.getOne(SAMPLE_ID)).thenReturn(null);

        dao.update(mockedBusiness);

    }

    @Test(expected = local.tin.tests.crud.model.domain.exceptions.SuperException.class)
    public void delete_throws_exception_when_not_found() throws local.tin.tests.crud.model.domain.exceptions.SuperException {
        when(mockedRespository.getOne(SAMPLE_ID)).thenReturn(null);

        dao.delete(mockedBusiness);
    }

    @Test
    public void delete_removes_element() throws local.tin.tests.crud.model.domain.exceptions.SuperException {
        when(mockedRespository.getOne(SAMPLE_ID)).thenReturn(mockedPersistence);
        when(mockedAbstractIdentifiablePersistenceToBusiness.convert(mockedPersistence, AbstractDAO.DEFAULT_DEPTH)).thenReturn(mockedBusiness);

        dao.delete(mockedBusiness);

        verify(mockedRespository).deleteById(SAMPLE_ID);
    }

    @Test
    public void findAll_returns_persistence_elements_converted() throws SuperException {
        Persistence mockedPersistenceAlt = mock(Persistence.class);
        Domain mockedBusinessAlt = mock(Domain.class);
        List<Persistence> persisntenceItems = new ArrayList<>();
        persisntenceItems.add(mockedPersistence);
        persisntenceItems.add(mockedPersistenceAlt);
        when(mockedRespository.findAll()).thenReturn(persisntenceItems);
        when(mockedAbstractIdentifiablePersistenceToBusiness.convert(mockedPersistence)).thenReturn(mockedBusiness);
        when(mockedAbstractIdentifiablePersistenceToBusiness.convert(mockedPersistenceAlt)).thenReturn(mockedBusinessAlt);

        List<local.tin.tests.crud.model.domain.abstracts.AbstractIdentifiable> result = dao.findAll();

        assertEquals(persisntenceItems.size(), result.size());
        assertTrue(result.contains(mockedBusiness));
        assertTrue(result.contains(mockedBusinessAlt));
    }
}

class AbstractDAOWrapper extends AbstractDAO<Domain, Persistence, Integer, Integer> {

    @Override
    protected AbstractIdentifiableDomainToPersistence<Domain, Persistence, Integer> getBusinessToPersistence() {
        return AbstractDAOTest.mockedAbstractIdentifiableBusinessToPersistence;
    }

    @Override
    protected AbstractIdentifiablePersistenceToDomain<Persistence, Domain, Integer> getPersistenceToBusiness() {
        return AbstractDAOTest.mockedAbstractIdentifiablePersistenceToBusiness;
    }

    @Override
    protected IRepository<Persistence> getRepository() {
        return AbstractDAOTest.mockedRespository;
    }

}
