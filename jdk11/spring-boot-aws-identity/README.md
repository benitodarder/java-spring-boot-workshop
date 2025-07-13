# Infrastructure / Workshop / Java / spring-boot-aws-identity

Sample Spring Boot *hello world*.

Two services exposed:

* **curl <IP/DNS>:<Port>/HelloAWS/**: Returns available AWS credentials as describe in the default credentials chain.
* **curl <IP/DNS>:<Port>/HelloWorld/**: Returns sample string containing the current timestamp.

Available in *assets* folder:

* Sample Dockerfile, for distroless and openjdk.
* Sample k8s YAML configuration files:
    - *deployment*
    - *service*:
        - *node port*
        - *cluster ip*
        - *load balancer*
    - *ingress*
    
## Quick start:
### Local:
To run this application locally:
* Credentialless:
    ```
    $ java -jar target/spring-boot-aws-identity-1.0.jar
    $ curl localhost:8080/HelloAWS/  
    {"timestamp":"2025-05-29T09:27:21.473+00:00","status":500,"error":"Internal Server Error","path":"/HelloAWS/"}
    $ curl localhost:8080/HelloWorld/
    Hi there! It's Thu May 29 09:28:15 UTC 2025
    ```      
* Credentialfull, see AWS SDK Java default credentials provider chain:
    - From environment variable:
      ```    
      $ export AWS_PROFILE=axis.lab.administrators
      $ java -jar target/spring-boot-aws-identity-1.0.jar
      $ curl localhost:8080/HelloAWS/
      Running as arn:aws:sts::940718188469:assumed-role/AWSReservedSSO_axis.it.administrators_87dee5f6100ae3be/Benito.Darder@axisdata.net, on the Thu May 29 09:31:13 UTC 2025    
      ```   
    - From java properties with default credentials provider chain sample application:
      ```          
      $ echo $AWS_PROFILE
      axis.lab.administrators    
      $ java -Daws.accessKeyId=<IAM user access key id.> -Daws.secretAccessKey=<IAM user secret access key> -Daws.region=<IAM user region> -jar target/spring-boot-aws-identity-1.0.jar
      $ curl localhost:8080/HelloAWS/
      Running as arn:aws:iam::559612291355:user/rundeck, on the Thu May 29 09:34:43 UTC 2025
      ```      
### Docker:
To try this sample application on docker first build the image: *docker build -f assets/Dockerfile.distroless -t distroless-aws-identity:0.0.1 .*
* Credentialless:
    ```
    $ docker run -p 8081:8080 distroless-aws-identity:0.0.1
    $ curl localhost:8081/HelloAWS/
    {"timestamp":"2025-05-29T09:45:31.079+00:00","status":500,"error":"Internal Server Error","path":"/HelloAWS/"}
    $curl localhost:8081/HelloWorld/
    Hi there! It's Thu May 29 09:45:50 GMT 2025
    ```    
* Credentialfull:
    ```
    $ docker run -p 8081:8080 -e AWS_ACCESS_KEY_ID=<IAM user access key id.> -e AWS_SECRET_ACCESS_KEY=<IAM user secret access key> -e AWS_REGION=<IAM user region> distroless-aws-identity:0.0.1
    $ curl localhost:8081/HelloAWS/
    Running as arn:aws:iam::559612291355:user/rundeck, on the Thu May 29 09:49:00 GMT 2025    
    ```    
### K8s:
* Credentialless:
    ```
    $ kubectl create namespace distroless-aws-identity
    namespace/distroless-aws-identity created
    $ kubectl apply -f assets/deployment_credentialsless.yaml
    deployment.apps/distroless-aws-identity created
    $ kubectl apply -f assets/service_node_port.yaml
    service/distroless-aws-identity created
    $ curl localhost:7080/HelloAWS/
    {"timestamp":"2025-05-29T10:44:57.926+00:00","status":500,"error":"Internal Server Error","path":"/HelloAWS/"}
    $ curl localhost:7080/HelloWorld/
    Hi there! It's Thu May 29 10:45:03 GMT 2025
    $ kubectl delete -f assets/service_node_port.yaml
    service "distroless-aws-identity" deleted      
    $ kubectl delete -f assets/deployment_credentialsless.yaml
    deployment.apps "distroless-aws-identity" deleted
    $ kubectl delete -f assets/secret.json
    secret "distroless-aws-identity" deleted    
    ```
* Credentialfull:
    - From k8s secrets:
      ```    
      $ cat assets/secret.json
      {
        "metadata": {
          "annotations": {},
          "name": "distroless-aws-identity",
          "namespace": "distroless-aws-identity"
        },
        "apiVersion": "v1",
        "kind": "Secret",
        "data": {
          "access_key_id": "<IAM user access key id. base64 encoded>",
          "secret_access_key": "<IAM user secret access key base64 encoded>"
        }
      }
      $ kubectl apply -f assets/secret.json
      secret/distroless-aws-identity created    
      $ kubectl get secrets -n distroless-aws-identity
      NAME                      TYPE     DATA   AGE
      distroless-aws-identity   Opaque   2      17s
      $ kubectl apply -f assets/deployment_credentialsfull.yaml
      deployment.apps/distroless-aws-identity created
      $ kubectl apply -f assets/service_node_port.yaml
      service/distroless-aws-identity created
      $ kubectl get services -A
      NAMESPACE                 NAME                                 TYPE           CLUSTER-IP       EXTERNAL-IP   PORT(S)                      AGE
      default                   balanced                             LoadBalancer   10.111.208.118   <pending>     8080:30994/TCP               176m
      default                   kubernetes                           ClusterIP      10.96.0.1        <none>        443/TCP                      3h3m
      distroless-aws-identity   distroless-aws-identity              NodePort       10.101.85.184    <none>        7070:31526/TCP               7s
      ingress-nginx             ingress-nginx-controller             NodePort       10.105.231.143   <none>        80:30784/TCP,443:30216/TCP   143m
      ingress-nginx             ingress-nginx-controller-admission   ClusterIP      10.109.242.154   <none>        443/TCP                      143m
      kube-system               kube-dns                             ClusterIP      10.96.0.10       <none>        53/UDP,53/TCP,9153/TCP       3h3m
      $ kubectl port-forward service/distroless-aws-identity 7080:7070 -n distroless-aws-identity
      Forwarding from 127.0.0.1:7080 -> 8080
      Forwarding from [::1]:7080 -> 8080
      $ curl localhost:7080/HelloAWS/
      Running as arn:aws:iam::559612291355:user/rundeck, on the Thu May 29 11:02:34 GMT 2025
      $ kubectl delete -f assets/service_node_port.yaml
      service "distroless-aws-identity" deleted      
      $ kubectl delete -f assets/deployment_credentialsfull.yaml
      deployment.apps "distroless-aws-identity" deleted
      $ kubectl delete -f assets/secret.json
      secret "distroless-aws-identity" deleted
      ```    