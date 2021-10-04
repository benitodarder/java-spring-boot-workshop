package local.tin.tests.crud.service.springboot.converters;

import local.tin.tests.crud.service.springboot.converters.abstracts.AbstractNamedDomainToPersistence;
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
    protected local.tin.tests.crud.model.persistence.Component setDeeperAttributes(local.tin.tests.crud.model.persistence.Component p, local.tin.tests.crud.model.domain.Component b, int depth) {
        p.setUnit(unitConverter.convert(b.getUnit(), depth - 1));
        for (local.tin.tests.crud.model.domain.Assembly current : b.getAssemblies()) {
            p.getAssemblies().add(assemblyConverter.convert(current, depth - 1));
        }
        return p;
    }

}
