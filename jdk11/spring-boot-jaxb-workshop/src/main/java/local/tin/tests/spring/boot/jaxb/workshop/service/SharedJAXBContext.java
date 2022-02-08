package local.tin.tests.spring.boot.jaxb.workshop.service;

import local.tin.tests.spring.boot.jaxb.workshop.model.AnyClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *
 * @author benitodarder
 */
@Service
public class SharedJAXBContext {

    private static final Logger LOGGER = LoggerFactory.getLogger(SharedJAXBContext.class);

    public long generateAndMarshall(int items) throws Exception {
        long t0 = System.currentTimeMillis();
        for (int i = 0; i < items; i++) {
            AnyClass anyClass = new AnyClass();
            anyClass.setId(i);
            anyClass.setString("I'm item " + i);
            LOGGER.info(local.tin.tests.spring.boot.jaxb.workshop.jaxb.SharedJAXBContextMarshaller.getInstance().toString(anyClass));
        }
        return System.currentTimeMillis() - t0;
    }
}
