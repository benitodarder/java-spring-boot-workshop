package local.tin.tests.crud.service.springboot.converters;

import local.tin.tests.crud.service.springboot.converters.abstracts.AbstractNamedPersistenceToDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author benitodarder
 */
@Component
public class ComponentPersistenceToDomain extends AbstractNamedPersistenceToDomain<local.tin.tests.crud.model.persistence.Component, local.tin.tests.crud.model.domain.Component> {

    @Autowired
    private UnitPersistenceToDomain unitConverter;
    @Autowired
    private AssemblyPersistenceToDomain assemblyConverter;

    @Override
    protected local.tin.tests.crud.model.domain.Component getConvertedInstance() {
        return new local.tin.tests.crud.model.domain.Component();
    }

    @Override
    protected local.tin.tests.crud.model.domain.Component setDeeperAttributes(local.tin.tests.crud.model.domain.Component b, local.tin.tests.crud.model.persistence.Component p, int depth) {
        b.setUnit(unitConverter.convert(p.getUnit(), depth - 1));
        for (local.tin.tests.crud.model.persistence.Assembly current : p.getAssemblies()) {
            b.getAssemblies().add(assemblyConverter.convert(current, depth - 1));
        }
        return b;
    }

}
