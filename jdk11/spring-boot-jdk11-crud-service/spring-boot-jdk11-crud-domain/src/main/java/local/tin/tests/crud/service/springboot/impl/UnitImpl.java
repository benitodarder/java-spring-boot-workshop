package local.tin.tests.crud.service.springboot.impl;

import local.tin.tests.crud.model.persistence.Unit;
import local.tin.tests.crud.service.springboot.daos.UnitDAO;
import local.tin.tests.crud.service.springboot.daos.interfaces.IAbstractDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author benitodarder
 */
@Service
public class UnitImpl extends AbstractNamedServiceBusiness<local.tin.tests.crud.model.domain.Unit, Unit> {

    @Autowired
    private UnitDAO dao;



    @Override
    protected IAbstractDAO<local.tin.tests.crud.model.domain.Unit, Unit> getDAO() {
        return dao;
    }


    
}
