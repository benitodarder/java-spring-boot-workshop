package local.tin.tests.crud.service.springboot.impl;

import local.tin.tests.crud.model.persistence.Component;
import local.tin.tests.crud.service.springboot.daos.ComponentDAO;
import local.tin.tests.crud.service.springboot.daos.interfaces.IAbstractDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author benitodarder
 */
@Service
public class ComponentImpl extends AbstractNamedServiceBusiness<local.tin.tests.crud.model.domain.Component, Component> {

    @Autowired
    private ComponentDAO dao;



    @Override
    protected IAbstractDAO<local.tin.tests.crud.model.domain.Component, Component> getDAO() {
        return dao;
    }


    
}
