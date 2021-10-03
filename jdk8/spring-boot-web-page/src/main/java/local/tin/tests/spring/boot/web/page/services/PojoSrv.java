package local.tin.tests.spring.boot.web.page.services;

import local.tin.tests.spring.boot.web.page.model.Pojo;
import org.springframework.stereotype.Service;

/**
 *
 * @author benitodarder
 */
@Service
public class PojoSrv {

    public Pojo getResponse(Pojo pojo) {
        pojo.setString(pojo.getString().toUpperCase());
        return pojo;
    }

}
