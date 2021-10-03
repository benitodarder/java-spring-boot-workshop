package local.tin.tests.crud.service.springboot.converters;

import local.tin.tests.crud.model.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author benitodarder
 */
@Component
public class ProductPersistenceToDomain extends AbstractNamedPersistenceToDomain<local.tin.tests.crud.model.persistence.Product, local.tin.tests.crud.model.domain.Product> {

    @Autowired
    private AssemblyPersistenceToDomain powerConverter;

    @Override
    protected Product getConvertedInstance() {
        return new Product();
    }

    @Override
    public Product convert(local.tin.tests.crud.model.persistence.Product c0, int depth) {
        Product superHero = super.convert(c0);
        superHero.setDescription(c0.getDescription());
        if (depth > 0) {
            c0.getAssemblies().forEach((current) -> {
                superHero.getAssemblies().add(powerConverter.convert(current, depth - 1));
            });
        }
        return superHero;
    }

}
