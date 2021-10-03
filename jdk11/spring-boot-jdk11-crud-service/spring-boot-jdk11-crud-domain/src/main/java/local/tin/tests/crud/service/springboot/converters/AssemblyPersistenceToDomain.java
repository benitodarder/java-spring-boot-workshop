package local.tin.tests.crud.service.springboot.converters;

import local.tin.tests.crud.model.domain.Assembly;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author benitodarder
 */
@Component
public class AssemblyPersistenceToDomain extends AbstractEnableablePersistenceToDomain<local.tin.tests.crud.model.persistence.Assembly, local.tin.tests.crud.model.domain.Assembly> {

    @Autowired
    private ComponentPersistenceToDomain powerConverter;
    @Autowired
    private ProductPersistenceToDomain productConverter;

    @Override
    protected Assembly getConvertedInstance() {
        return new Assembly();
    }

    @Override
    public Assembly convert(local.tin.tests.crud.model.persistence.Assembly c0, int depth) {
        Assembly superHero = super.convert(c0);
        superHero.setQuantity(c0.getQuantity());
        if (depth > 0) {
            superHero.setComponent(powerConverter.convert(c0.getComponent(), depth - 1));
            superHero.setProduct(productConverter.convert(c0.getProduct(), depth - 1));
        }
        return superHero;
    }

    @Override
    protected local.tin.tests.crud.model.domain.composites.AssemblyId getConvertedId(local.tin.tests.crud.model.persistence.Assembly c0) {
        local.tin.tests.crud.model.domain.composites.AssemblyId assemblyId = new local.tin.tests.crud.model.domain.composites.AssemblyId();
        assemblyId.setComponentId(c0.getId().getComponentId());
        assemblyId.setProductId(c0.getId().getProductId());
        return assemblyId;
    }

}
