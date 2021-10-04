package local.tin.tests.crud.service.springboot.converters;

import local.tin.tests.crud.service.springboot.converters.abstracts.AbstractNamedDomainToPersistence;
import local.tin.tests.crud.model.persistence.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author benitodarder
 */
@Component
public class ProductDomainToPersistence extends AbstractNamedDomainToPersistence<local.tin.tests.crud.model.domain.Product, local.tin.tests.crud.model.persistence.Product> {

    @Autowired
    private AssemblyDomainToPersistence powerConverter;

    @Override
    protected Product getConvertedInstance() {
        return new Product();
    }

    @Override
    protected Product setDepth0Attributes(Product p, local.tin.tests.crud.model.domain.Product b) {
        p.setDescription(b.getDescription());
        return super.setDepth0Attributes(p, b); 
    }
  
    
    @Override
    protected Product setDeeperAttributes(Product p, local.tin.tests.crud.model.domain.Product b, int depth) {
        for (local.tin.tests.crud.model.domain.Assembly current : b.getAssemblies()) {
            p.getAssemblies().add(powerConverter.convert(current, depth - 1));
        }
        return p;
    }

}
