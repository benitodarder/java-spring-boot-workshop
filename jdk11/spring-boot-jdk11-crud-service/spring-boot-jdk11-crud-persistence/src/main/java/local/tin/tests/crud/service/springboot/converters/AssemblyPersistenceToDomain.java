package local.tin.tests.crud.service.springboot.converters;

import local.tin.tests.crud.service.springboot.converters.abstracts.AbstractEnableablePersistenceToDomain;
import local.tin.tests.crud.model.domain.Assembly;
import local.tin.tests.crud.model.persistence.embeddables.AssemblyId;
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
    protected Assembly setDepth0Attributes(Assembly b, local.tin.tests.crud.model.persistence.Assembly p) {
        b.setQuantity(p.getQuantity());
        return super.setDepth0Attributes(b, p); 
    }



    @Override
    protected local.tin.tests.crud.model.domain.composites.AssemblyId getConvertedId(local.tin.tests.crud.model.persistence.Assembly c0) {
        local.tin.tests.crud.model.domain.composites.AssemblyId assemblyId = new local.tin.tests.crud.model.domain.composites.AssemblyId();
        assemblyId.setComponentId(((AssemblyId)c0.getId()).getComponentId());
        assemblyId.setProductId(((AssemblyId)c0.getId()).getProductId());
        return assemblyId;
    }

    @Override
    protected Assembly setDeeperAttributes(Assembly b, local.tin.tests.crud.model.persistence.Assembly p, int depth) {
            b.setComponent(powerConverter.convert(p.getComponent(), depth - 1));
            b.setProduct(productConverter.convert(p.getProduct(), depth - 1));    
            return b;
    }

}
