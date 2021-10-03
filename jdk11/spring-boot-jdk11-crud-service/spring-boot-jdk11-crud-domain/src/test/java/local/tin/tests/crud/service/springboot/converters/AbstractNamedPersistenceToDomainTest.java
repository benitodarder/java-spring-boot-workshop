package local.tin.tests.crud.service.springboot.converters;

import local.tin.tests.crud.service.springboot.converters.AbstractNamedPersistenceToDomain;
import local.tin.tests.crud.service.springboot.Domain;
import local.tin.tests.crud.service.springboot.Persistence;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;


/**
 *
 * @author benitodarder
 */
public class AbstractNamedPersistenceToDomainTest {
    
    private static final String NAME = "Name";
    private Domain business;
    private Persistence persistence;
    private AbstractNamedPersistenceToDomain converter;
    
    @Before
    public void setUp() {
        converter = new NamedPersistenceToBusinessConverterWrapper();
        business = new Domain();
        persistence = new Persistence();
    }
    
    @Test
    public void convert_assigns_fields() {
        persistence.setName(NAME);
        
        business = (Domain) converter.convert(persistence);
        
        assertEquals(NAME, business.getName());
    }

}

class NamedPersistenceToBusinessConverterWrapper extends AbstractNamedPersistenceToDomain<Persistence, Domain> {

    @Override
    protected Domain getConvertedInstance() {
        return new Domain();
    }

    @Override
    public Domain convert(Persistence c0, int depth) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
