package local.tin.tests.crud.service.springboot.controllers;

import local.tin.tests.crud.model.domain.Assembly;
import local.tin.tests.crud.service.springboot.impl.AssemblyImpl;
import local.tin.tests.crud.service.springboot.impl.interfaces.IServiceBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author benitodarder
 */
@RestController
@RequestMapping("/assembly")
public class AssemblyCtrl extends AbstractServiceBusinessController<Assembly> {

    @Autowired
    private AssemblyImpl service;
    
    @Override
    protected IServiceBusiness<Assembly> getService() {
        return service;
    }
   
}
