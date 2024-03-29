package local.tin.tests.crud.service.springboot.converters.abstracts;

import local.tin.tests.crud.service.springboot.Domain;
import local.tin.tests.crud.service.springboot.Persistence;
import local.tin.tests.crud.service.springboot.converters.abstracts.AbstractIdentifiableDomainToPersistence;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;


/**
 *
 * @author benitodarder
 */
public class AbstractIdentifiableDomainToPersistenceTest {
    
    private static final Integer SAMPLE_ID = 666;
    private Domain business;
    private Persistence persistence;
    private AbstractIdentifiableDomainToPersistence converter;
    
    @Before
    public void setUp() {
        converter = new IdentifiableBusinessToPersistenceConverterWrapper();
        business = new Domain();
    }
    
    @Test
    public void convert_assigns_fields() {
        business.setId(SAMPLE_ID);
        
        persistence = (Persistence) converter.convert(business);
        
        assertEquals(SAMPLE_ID, persistence.getId());
    }

}

class IdentifiableBusinessToPersistenceConverterWrapper extends AbstractIdentifiableDomainToPersistence<Domain, Persistence, Integer> {

    @Override
    protected Persistence getConvertedInstance() {
        return new Persistence();
    }

    @Override
    protected Persistence setDeeperAttributes(Persistence p, Domain b, int depth) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}


