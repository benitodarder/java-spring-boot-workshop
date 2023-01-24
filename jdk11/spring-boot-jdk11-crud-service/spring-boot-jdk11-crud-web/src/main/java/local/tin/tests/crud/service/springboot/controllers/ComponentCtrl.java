package local.tin.tests.crud.service.springboot.controllers;

import local.tin.tests.crud.service.springboot.controllers.abstracts.AbstractNamedServiceBusinessController;
import local.tin.tests.crud.model.domain.Component;
import local.tin.tests.crud.service.springboot.impl.ComponentImpl;
import local.tin.tests.crud.service.springboot.impl.interfaces.IServiceBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author benitodarder
 */
@RestController
@RequestMapping("/component")
public class ComponentCtrl extends AbstractNamedServiceBusinessController<Component> {

    @Autowired
    private ComponentImpl service;
    
    @Override
    protected IServiceBusiness<Component> getService() {
        return service;
    }
   
}
