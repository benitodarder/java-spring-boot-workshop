# spring-boot-crud-service

A simple CRUD API exposed over REST.

* Sample command line with debug and dev profile
    - java -agentlib:jdwp=transport=dt_socket,server=y,address=8000,suspend=n -Dspring.profiles.active=dev -jar spring-boot-jdk11-crud-domain-1.0.jar 
* Sample HSQLDB server launch command:
    - java -cp <HSQLDB lib path>hsqldb.jar org.hsqldb.Server -database.0 <Database files location> -dbname.0 assemblies
