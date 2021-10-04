package local.tin.tests.crud.service.springboot.converters;

import local.tin.tests.crud.service.springboot.converters.abstracts.AbstractNamedPersistenceToDomain;
import local.tin.tests.crud.model.domain.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author benitodarder
 */
@Component
public class UnitPersistenceToDomain extends AbstractNamedPersistenceToDomain<local.tin.tests.crud.model.persistence.Unit, local.tin.tests.crud.model.domain.Unit> {

    @Autowired
    private ComponentPersistenceToDomain powerConverter;

    @Override
    protected Unit getConvertedInstance() {
        return new Unit();
    }

    @Override
    protected Unit setDepth0Attributes(Unit b, local.tin.tests.crud.model.persistence.Unit p) {
        b.setAbbreviation(p.getAbbreviation());
        return super.setDepth0Attributes(b, p); 
    }

    
    
    @Override
    protected Unit setDeeperAttributes(Unit b, local.tin.tests.crud.model.persistence.Unit p, int depth) {
        for (local.tin.tests.crud.model.persistence.Component current : p.getComponents()) {
            b.getComponents().add(powerConverter.convert(current, depth - 1));
        }
        return b;
    }

}
