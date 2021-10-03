package local.tin.tests.crud.service.springboot.controllers;


import local.tin.tests.crud.service.springboot.controllers.Ping;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author benitodarder
 */
public class PingTest {
    
    private Ping ping;
    
    @Before
    public void setUp() {
        ping = new Ping();
    }
    
    @Test
    public void ping_returns_expected_message() {
        
        ResponseEntity<String> responseEntity = ping.ping();
        
        assertTrue(responseEntity.getBody().startsWith("Hello "));
    }
    
    @Test
    public void ping_returns_http_200() {
        
        ResponseEntity<String> responseEntity = ping.ping();
        
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }    
    
}
