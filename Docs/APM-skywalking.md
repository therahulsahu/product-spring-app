# APM skywalking integration

1. Download Java Agent
2. Download Skywalking agent

```
https://skywalking.apache.org/docs/
```

3. execute this step in terminal 
```
java -javaagent:/<skywalkingAgent path>/skywalking-agent/skywalking-agent.jar -jar /<product-service path>/product-service-main/target/product-service-0.0.1-SNAPSHOT.jar
```
4. Open Skywalking agent running in the local host 8080 (Default Port)

5. hit apis in the postman, (for more load use Jmeter)


It is an Application performance monitor tool for distributed systems, especially designed for microservices, cloud native and container-based (Kubernetes) architectures.
