package local.tin.tests.spring.boot.aws.identity.services;

import local.tin.tests.spring.boot.aws.identity.AWSIdentityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sts.StsClient;
import software.amazon.awssdk.services.sts.model.GetCallerIdentityRequest;
import software.amazon.awssdk.services.sts.model.GetCallerIdentityResponse;

/**
 *
 * @author Benito.Darder
 */
@Service
public class AWSIdentityARN {
    
    @Autowired
    private AWSIdentityConfig helloAWSConfig;    
    
    public String getResponse() {
        StsClient iam = StsClient.builder()
                .region(Region.of(helloAWSConfig.getAwsRegion()))
                .build();
        
        GetCallerIdentityResponse response = iam.getCallerIdentity( GetCallerIdentityRequest.builder().build());
        return response.arn();
    }
    
}
