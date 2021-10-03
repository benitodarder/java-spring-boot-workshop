package local.tin.tests.crud.service.springboot.controllers;

import local.tin.tests.crud.model.domain.Product;
import local.tin.tests.crud.service.springboot.impl.ProductImpl;
import local.tin.tests.crud.service.springboot.impl.interfaces.IServiceBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author benitodarder
 */
@RestController
@RequestMapping("/product")
public class ProductCtrl extends AbstractNamedServiceBusinessController<Product> {

    @Autowired
    private ProductImpl service;
    
    @Override
    protected IServiceBusiness<Product> getService() {
        return service;
    }
   
}
