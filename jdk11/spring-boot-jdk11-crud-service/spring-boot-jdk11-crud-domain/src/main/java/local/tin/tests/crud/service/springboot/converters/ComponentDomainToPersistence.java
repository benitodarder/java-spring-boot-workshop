package local.tin.tests.crud.service.springboot.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author benitodarder
 */
@Component
public class ComponentDomainToPersistence extends AbstractNamedDomainToPersistence<local.tin.tests.crud.model.domain.Component, local.tin.tests.crud.model.persistence.Component> {

    @Autowired
    private UnitDomainToPersistence unitConverter;
    @Autowired
    private AssemblyDomainToPersistence assemblyConverter;

    @Override
    protected local.tin.tests.crud.model.persistence.Component getConvertedInstance() {
        return new local.tin.tests.crud.model.persistence.Component();
    }

    @Override
    public local.tin.tests.crud.model.persistence.Component convert(local.tin.tests.crud.model.domain.Component c0, int depth) {
        local.tin.tests.crud.model.persistence.Component superHero = super.convert(c0);
        if (depth > 0) {
            superHero.setUnit(unitConverter.convert(c0.getUnit(), depth - 1));
            for (local.tin.tests.crud.model.domain.Assembly current : c0.getAssemblies()) {
                superHero.getAssemblies().add(assemblyConverter.convert(current, depth - 1));
            }
        }
        return superHero;
    }

}
