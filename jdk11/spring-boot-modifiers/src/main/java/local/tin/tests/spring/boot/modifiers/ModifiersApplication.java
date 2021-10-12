package local.tin.tests.spring.boot.modifiers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication; 
import org.springframework.boot.web.servlet.ServletComponentScan;
 
@ServletComponentScan
@SpringBootApplication
public class ModifiersApplication {
 
    public static void main(String[] args) {
        SpringApplication.run(ModifiersApplication.class, args);
    }
}