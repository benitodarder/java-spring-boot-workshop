package local.tin.tests.spring.boot.hello.world.health;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

/**
 *
 * @author benitodarder
 */
@Component
public class HelloWorldHealth extends AbstractHealthIndicator {

    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        try {

            builder.up().withDetail("Hello World", "is healthy");

        } catch (final Exception e) {
            builder.down().withException(e);
        }
    }

}
