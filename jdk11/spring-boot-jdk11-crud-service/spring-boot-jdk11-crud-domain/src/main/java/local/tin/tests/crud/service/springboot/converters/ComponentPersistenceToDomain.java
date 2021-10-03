package local.tin.tests.crud.service.springboot.converters;

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
    public local.tin.tests.crud.model.domain.Component convert(local.tin.tests.crud.model.persistence.Component c0, int depth) {
        local.tin.tests.crud.model.domain.Component superHero = super.convert(c0);
        if (depth > 0) {
            superHero.setUnit(unitConverter.convert(c0.getUnit(), depth - 1));
            for (local.tin.tests.crud.model.persistence.Assembly current : c0.getAssemblies()) {
                superHero.getAssemblies().add(assemblyConverter.convert(current, depth - 1));
            }
        }
        return superHero;
    }

}
