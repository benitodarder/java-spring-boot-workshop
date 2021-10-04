package local.tin.tests.crud.service.springboot.converters;

import local.tin.tests.crud.service.springboot.converters.abstracts.AbstractNamedDomainToPersistence;
import local.tin.tests.crud.model.persistence.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author benitodarder
 */
@Component
public class UnitDomainToPersistence extends AbstractNamedDomainToPersistence<local.tin.tests.crud.model.domain.Unit, local.tin.tests.crud.model.persistence.Unit> {

    @Autowired
    private ComponentDomainToPersistence powerConverter;


    @Override
    protected Unit getConvertedInstance() {
        return new Unit();
    }

    @Override
    protected Unit setDepth0Attributes(Unit p, local.tin.tests.crud.model.domain.Unit b) {
        p.setAbbreviation(b.getAbbreviation());
        return super.setDepth0Attributes(p, b); 
    }
    
    

    @Override
    protected Unit setDeeperAttributes(Unit p, local.tin.tests.crud.model.domain.Unit b, int depth) {
            for (local.tin.tests.crud.model.domain.Component current : b.getComponents()) {
                p.getComponents().add(powerConverter.convert(current, depth - 1));
            }   
            return p;
    }

}
