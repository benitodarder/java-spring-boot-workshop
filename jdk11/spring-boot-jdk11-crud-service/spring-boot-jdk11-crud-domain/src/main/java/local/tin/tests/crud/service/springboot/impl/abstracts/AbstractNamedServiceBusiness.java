package local.tin.tests.crud.service.springboot.impl.abstracts;

import java.util.List;
import local.tin.tests.crud.model.persistence.abstracts.AbstractNamed;
import local.tin.tests.crud.service.springboot.daos.interfaces.IAbstractNamedDAO;
import local.tin.tests.crud.service.springboot.impl.interfaces.INamedServiceBusiness;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author benitodarder
 * @param <BN>
 * @param <PN>
 */
public abstract class AbstractNamedServiceBusiness<BN extends local.tin.tests.crud.model.domain.abstracts.AbstractNamed, PN extends AbstractNamed> extends AbstractServiceBusiness<BN, PN> implements INamedServiceBusiness<BN> {

    @Transactional    
    @Override
    public List<BN> findByName(String name) {
        return ((IAbstractNamedDAO)getDAO()).findByName(name);
    }



}
