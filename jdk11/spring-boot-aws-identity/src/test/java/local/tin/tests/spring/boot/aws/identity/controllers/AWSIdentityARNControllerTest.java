package local.tin.tests.spring.boot.aws.identity.controllers;


import local.tin.tests.spring.boot.aws.identity.services.AWSIdentityARN;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
/**
 *
 * @author Benito.Darder
 */
public class AWSIdentityARNControllerTest {

    public static final String SAMPLE_INPUT = "meh";
    public static final String RESPONSE = "response";

    @Mock
    private AWSIdentityARN mockedHelloAWSService;
    @InjectMocks
    private AWSIdentityARNController controller;
    private ResponseEntity mockedResponse;
    
    @BeforeEach
    public void setUp() {
        controller = new AWSIdentityARNController();
        MockitoAnnotations.openMocks(this);
        when(mockedHelloAWSService.getResponse()).thenReturn(RESPONSE);
    }

    @Test
    public void controller_returns_service_response() {
                
        assertEquals(RESPONSE, controller.getResponse().getBody());
    }

 
}
