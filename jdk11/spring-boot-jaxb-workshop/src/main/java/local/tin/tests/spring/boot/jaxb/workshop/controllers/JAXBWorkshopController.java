package local.tin.tests.spring.boot.jaxb.workshop.controllers;

import java.util.Date;
import local.tin.tests.spring.boot.jaxb.workshop.service.ExclusiveJAXBContext;
import local.tin.tests.spring.boot.jaxb.workshop.service.SharedJAXBContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author benitodarder
 */
@RestController
@RequestMapping(path = "/jaxbWorkshop")
public class JAXBWorkshopController {

    @Autowired
    private SharedJAXBContext sharedJAXBContext;

    @Autowired
    private ExclusiveJAXBContext exclusiveJAXBContext;

    @GetMapping(path = "/sharedContext", produces = "text/plain")
    public String generateAndMarshallWithShared(@RequestParam(value = "items", defaultValue = "1") int items) throws Exception {
        return String.valueOf(sharedJAXBContext.generateAndMarshall(items));
    }

    @GetMapping(path = "/exclusiveContext", produces = "text/plain")
    public String generateAndMarshallWithExclusive(@RequestParam(value = "items", defaultValue = "1") int items) throws Exception {
        return String.valueOf(exclusiveJAXBContext.generateAndMarshall(items));
    }
}
