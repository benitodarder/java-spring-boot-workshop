package local.tin.tests.crud.service.springboot.daos;

import java.util.ArrayList;
import java.util.List;
import local.tin.tests.crud.service.springboot.daos.interfaces.IAbstractNamedDAO;
import local.tin.tests.crud.service.springboot.repositories.INamedRepository;

/**
 *
 * @author benitodarder
 * @param <BN>
 * @param <PN>
 */
public abstract class AbstractNamedDAO<BN extends local.tin.tests.crud.model.domain.interfaces.INamed, PN extends local.tin.tests.crud.model.persistence.interfaces.INamed> extends AbstractDAO<BN, PN> implements IAbstractNamedDAO<BN, PN>{

    @Override
    public List<BN> findByName(String name) {
        List<PN> persistenceItems = ((INamedRepository) getRepository()).findByName(name);
        List<BN> businessItems = new ArrayList<>();
        persistenceItems.forEach((current) -> {
            businessItems.add(convert(current));
        });
        return businessItems;
    }

    
    
}
