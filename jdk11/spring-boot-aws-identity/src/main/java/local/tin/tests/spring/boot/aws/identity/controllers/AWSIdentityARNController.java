package local.tin.tests.spring.boot.aws.identity.controllers;


import local.tin.tests.spring.boot.aws.identity.services.AWSIdentityARN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author benitodarder
 */
@RestController
@RequestMapping(path = "/awsIdentity")
public class AWSIdentityARNController {
    
    @Autowired
    private AWSIdentityARN awsIdentityARN;    

    @GetMapping(path = "/arn", produces = "text/plain")
    public ResponseEntity<String> getResponse() {
        return  new ResponseEntity<>(awsIdentityARN.getResponse(), HttpStatus.OK); 
    }
    

}
