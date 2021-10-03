package local.tin.tests.crud.service.springboot.converters;

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
    public Unit convert(local.tin.tests.crud.model.persistence.Unit c0, int depth) {
        Unit superHero = super.convert(c0);
        superHero.setAbbreviation(c0.getAbbreviation());
        if (depth > 0) {
            for (local.tin.tests.crud.model.persistence.Component current : c0.getComponents()) {
                superHero.getComponents().add(powerConverter.convert(current, depth - 1));
            }
        }
        return superHero;
    }

}