package local.tin.tests.crud.service.springboot.controllers;

import local.tin.tests.crud.service.springboot.controllers.abstracts.AbstractNamedServiceBusinessController;
import local.tin.tests.crud.model.domain.Unit;
import local.tin.tests.crud.service.springboot.impl.UnitImpl;
import local.tin.tests.crud.service.springboot.impl.interfaces.IServiceBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author benitodarder
 */
@RestController
@RequestMapping("/unit")
public class UnitCtrl extends AbstractNamedServiceBusinessController<Unit> {

    @Autowired
    private UnitImpl service;
    
    @Override
    protected IServiceBusiness<Unit> getService() {
        return service;
    }
   
}
