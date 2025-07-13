package local.tin.tests.spring.boot.aws.identity.controllers;


import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

/**
 *
 * @author Benito.Darder
 */
public class HelloWorldControllerTest {

    public static final String RESPONSE = "Hi there! It's ";

    @InjectMocks
    private HelloWorldController controller;

    @BeforeEach
    public void setUp() {
        controller = new HelloWorldController();
    }

    @Test
    public void controller_returns_service_response() {

        assertTrue(controller.getResponse().startsWith(RESPONSE));
    }

}
