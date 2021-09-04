package local.tin.tests.spring.boot.web.page.services;

import java.util.Date;
import org.springframework.stereotype.Service;

/**
 *
 * @author benitodarder
 */
@Service
public class GreetingSrv {
    
    public String getResponse(String name) {
        return "Hi " + name + ", nice to meet you at " + new Date();
    }
 
}
