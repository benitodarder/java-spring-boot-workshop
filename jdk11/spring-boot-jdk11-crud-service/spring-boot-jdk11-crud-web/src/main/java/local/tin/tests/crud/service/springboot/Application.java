package local.tin.tests.crud.service.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan("local.tin.tests.crud.model.persistence")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
