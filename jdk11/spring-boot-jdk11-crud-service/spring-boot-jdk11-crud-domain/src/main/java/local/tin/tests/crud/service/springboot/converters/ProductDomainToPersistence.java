package local.tin.tests.crud.service.springboot.converters;

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
    public Product convert(local.tin.tests.crud.model.domain.Product c0, int depth) {
        local.tin.tests.crud.model.persistence.Product superHero = super.convert(c0);
        superHero.setDescription(c0.getDescription());
        if (depth > 0) {
            for (local.tin.tests.crud.model.domain.Assembly current : c0.getAssemblies()) {
                superHero.getAssemblies().add(powerConverter.convert(current, depth -1));
            }
        }
        return superHero;
    }

}
