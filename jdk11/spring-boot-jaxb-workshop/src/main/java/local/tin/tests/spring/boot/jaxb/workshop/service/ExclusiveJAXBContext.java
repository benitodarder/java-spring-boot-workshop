package local.tin.tests.spring.boot.jaxb.workshop.service;

import local.tin.tests.spring.boot.jaxb.workshop.jaxb.ExclusiveJAXBContextMarshaller;
import local.tin.tests.spring.boot.jaxb.workshop.model.AnyClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author benitodarder
 */
@Service
public class ExclusiveJAXBContext {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExclusiveJAXBContext.class);
    @Autowired
    private ExclusiveJAXBContextMarshaller marshaller;
    
    public long generateAndMarshall(int items) throws Exception {
        long t0 = System.currentTimeMillis();
        for (int i = 0; i < items; i++) {
            AnyClass anyClass = new AnyClass();
            anyClass.setId(i);
            anyClass.setString("I'm item " + i);
            LOGGER.info(marshaller.toString(anyClass));
        }
        return System.currentTimeMillis() - t0;
    }
}
