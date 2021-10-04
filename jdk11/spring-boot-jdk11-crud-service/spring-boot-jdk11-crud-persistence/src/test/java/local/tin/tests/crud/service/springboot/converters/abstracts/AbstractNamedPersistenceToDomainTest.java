package local.tin.tests.crud.service.springboot.converters.abstracts;

import local.tin.tests.crud.service.springboot.converters.abstracts.AbstractNamedPersistenceToDomain;
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
    protected Domain setDeeperAttributes(Domain b, Persistence p, int depth) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
