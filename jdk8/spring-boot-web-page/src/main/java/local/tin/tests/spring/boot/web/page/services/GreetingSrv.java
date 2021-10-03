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
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Hi ").append(name).append(", nice to meet you at ").append(new Date());
        return stringBuilder.toString();
    }
 
}
