package local.tin.tests.crud.service.springboot.impl;

import local.tin.tests.crud.service.springboot.impl.abstracts.AbstractServiceBusiness;
import local.tin.tests.crud.model.persistence.Assembly;
import local.tin.tests.crud.service.springboot.daos.AssemblyDAO;
import local.tin.tests.crud.service.springboot.daos.interfaces.IAbstractDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author benitodarder
 */
@Service
public class AssemblyImpl extends AbstractServiceBusiness<local.tin.tests.crud.model.domain.Assembly, Assembly> {

    @Autowired
    private AssemblyDAO dao;



    @Override
    protected IAbstractDAO<local.tin.tests.crud.model.domain.Assembly, Assembly> getDAO() {
        return dao;
    }


    
}
