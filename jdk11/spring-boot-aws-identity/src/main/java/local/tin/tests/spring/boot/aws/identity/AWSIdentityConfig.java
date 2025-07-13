package local.tin.tests.spring.boot.aws.identity;

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
public class AWSIdentityConfig {

    private String awsRegion;

    public String getAwsRegion() {
        return awsRegion;
    }

    public void setAwsRegion(String awsRegion) {
        this.awsRegion = awsRegion;
    }
    private String template;
    
    
    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }    

}
