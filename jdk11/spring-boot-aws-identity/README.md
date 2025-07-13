# Infrastructure / Workshop / Java / spring-boot-aws-identity

Sample Spring Boot AWS identity checker.

Two services exposed:

* **curl <IP/DNS>:<Port>/awsIdentity/arn**: Returns available AWS credentials as describe in the default credentials chain.
* **curl <IP/DNS>:<Port>/HelloWorld/**: Returns sample string containing the current timestamp.

