package local.tin.tests.crud.service.springboot.converters;

import local.tin.tests.crud.service.springboot.converters.abstracts.AbstractEnableableDomainToPersistence;
import local.tin.tests.crud.model.persistence.Assembly;
import local.tin.tests.crud.model.persistence.embeddables.AssemblyId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author benitodarder
 */
@Component
public class AssemblyDomainToPersistence extends AbstractEnableableDomainToPersistence<local.tin.tests.crud.model.domain.Assembly, local.tin.tests.crud.model.persistence.Assembly, AssemblyId> {

    @Autowired
    private ComponentDomainToPersistence powerConverter;
    @Autowired
    private ProductDomainToPersistence productConverter;

    @Override
    protected Assembly getConvertedInstance() {
        return new Assembly();
    }

    @Override
    protected Assembly setDepth0Attributes(Assembly p, local.tin.tests.crud.model.domain.Assembly b) {
        p.setQuantity(b.getQuantity());
        return super.setDepth0Attributes(p, b);
    }
    
    
    @Override
    protected local.tin.tests.crud.model.persistence.embeddables.AssemblyId getConvertedId(local.tin.tests.crud.model.domain.Assembly c0) {
        local.tin.tests.crud.model.persistence.embeddables.AssemblyId assemblyId = new local.tin.tests.crud.model.persistence.embeddables.AssemblyId();
        assemblyId.setComponentId(c0.getId().getComponentId());
        assemblyId.setProductId(c0.getId().getProductId());
        return assemblyId;
    }

    @Override
    protected Assembly setDeeperAttributes(Assembly p, local.tin.tests.crud.model.domain.Assembly b, int depth) {
        p.setComponent(powerConverter.convert(b.getComponent(), depth - 1));
        p.setProduct(productConverter.convert(b.getProduct(), depth - 1));
        return p;
    }
}
