package local.tin.tests.crud.service.springboot.converters;

import local.tin.tests.crud.service.springboot.Domain;
import local.tin.tests.crud.service.springboot.Persistence;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;


/**
 *
 * @author benitodarder
 */
public class AbstractIdentifiablePersistenceToDomainTest {
    
    private static final int SAMPLE_ID = 666;
    private Domain business;
    private Persistence persistence;
    private AbstractIdentifiablePersistenceToDomain converter;
    
    @Before
    public void setUp() {
        converter = new IdentifiablePersistenceToBusinessConverterWrapper();
        business = new Domain();
        persistence = new Persistence();
    }
    
    @Test
    public void convert_assigns_fields() {
        persistence.setId(SAMPLE_ID);
        
        business = (Domain) converter.convert(persistence);
        
        assertEquals(SAMPLE_ID, business.getId());
    }

}

class IdentifiablePersistenceToBusinessConverterWrapper extends AbstractIdentifiablePersistenceToDomain<Persistence, Domain> {

    @Override
    protected Domain getConvertedInstance() {
        return new Domain();
    }

    @Override
    public Domain convert(Persistence c0, int depth) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
