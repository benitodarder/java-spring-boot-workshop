package local.tin.tests.spring.boot.hello.world;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author benitodarder
 */
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class HelloWorldConfig {

    private String template;

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }    
}
