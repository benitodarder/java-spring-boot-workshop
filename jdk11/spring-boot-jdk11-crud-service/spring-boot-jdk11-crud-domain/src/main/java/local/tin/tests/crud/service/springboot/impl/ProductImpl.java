package local.tin.tests.crud.service.springboot.impl;

import local.tin.tests.crud.model.persistence.Product;
import local.tin.tests.crud.service.springboot.daos.ProductDAO;
import local.tin.tests.crud.service.springboot.daos.interfaces.IAbstractDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author benitodarder
 */
@Service
public class ProductImpl extends AbstractNamedServiceBusiness<local.tin.tests.crud.model.domain.Product, Product> {

    @Autowired
    private ProductDAO dao;



    @Override
    protected IAbstractDAO<local.tin.tests.crud.model.domain.Product, Product> getDAO() {
        return dao;
    }


    
}
