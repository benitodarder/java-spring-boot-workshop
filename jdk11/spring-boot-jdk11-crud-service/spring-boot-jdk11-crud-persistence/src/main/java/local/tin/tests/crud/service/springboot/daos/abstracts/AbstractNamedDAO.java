package local.tin.tests.crud.service.springboot.daos.abstracts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import local.tin.tests.crud.service.springboot.daos.interfaces.IAbstractNamedDAO;
import local.tin.tests.crud.service.springboot.repositories.interfaces.INamedRepository;

/**
 *
 * @author benitodarder
 * @param <BN>
 * @param <PN>
 */
public abstract class AbstractNamedDAO<BN extends local.tin.tests.crud.model.domain.interfaces.INamed, PN extends local.tin.tests.crud.model.persistence.interfaces.INamed, KB extends Serializable, KP extends Serializable> extends AbstractDAO<BN, PN, KB, KP> implements IAbstractNamedDAO<BN, PN>{

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
