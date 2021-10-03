package local.tin.tests.crud.service.springboot.daos.interfaces;

import java.util.List;

/**
 *
 * @author benitodarder
 */
public interface IAbstractNamedDAO<BN extends local.tin.tests.crud.model.domain.interfaces.INamed, PN extends local.tin.tests.crud.model.persistence.interfaces.INamed> extends IAbstractDAO<BN, PN> {

    public List<BN> findByName(String name);    
    
}
