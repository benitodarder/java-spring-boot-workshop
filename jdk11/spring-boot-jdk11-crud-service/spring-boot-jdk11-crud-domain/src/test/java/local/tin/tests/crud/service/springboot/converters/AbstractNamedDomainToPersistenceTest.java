package local.tin.tests.crud.service.springboot.converters;

import local.tin.tests.crud.service.springboot.converters.AbstractNamedDomainToPersistence;
import local.tin.tests.crud.service.springboot.Domain;
import local.tin.tests.crud.service.springboot.Persistence;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author benitodarder
 */
public class AbstractNamedDomainToPersistenceTest {

    private static final String NAME = "Name";
    private Domain business;
    private Persistence persistence;
    private AbstractNamedDomainToPersistence converter;

    @Before
    public void setUp() {
        converter = new NamedBusinessToPersistenceConverterWrapper();
        business = new Domain();
    }

    @Test
    public void convert_assigns_fields() {
        business.setName(NAME);

        persistence = (Persistence) converter.convert(business);

        assertEquals(NAME, persistence.getName());
    }

}

class NamedBusinessToPersistenceConverterWrapper extends AbstractNamedDomainToPersistence<Domain, Persistence> {

    @Override
    protected Persistence getConvertedInstance() {
        return new Persistence();
    }

    @Override
    public Persistence convert(Domain c0, int depth) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
