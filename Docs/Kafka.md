# Kafka Integration 🚀
Apache Kafka is a distributed event store and stream-processing platform. In this project we are using it as a message broker for sending (producing) messages and send in a topic `product_topic`

Download kafka from this link : https://kafka.apache.org/downloads

## Steps: 
#### 1. Extract kafka into a directory.
#### 2. Open terminal into that directory and run 
 - To start zookeeper
```
bin/zookeeper-server-start.sh config/zookeeper.properties
```
 - To start kafka server
 ```
 bin/kafka-server-start.sh config/server.properties
 ```
  > For windows run the `.bat` files instead of `.sh`.

#### 3. Once both Zookeeper and Kafka server is started. Open a new terminal instance and run this command to create a topic called `product_topic`
```
bin/kafka-topics.sh --create --topic product_topic --bootstrap-server localhost:9092
```
#### 4. By Default in the source code of product-service, Kafka `send` code is commented so as to run the project without kafka as well.
- Navigate to `ProductServiceImpl.java` and uncomment this line.
```java
productList.forEach(product -> kafkaTemplate.send(TOPIC, product));
```
---
> Now you are all set to run the application and send kafka message's when creating a product 🎉

### To Listen / Consume messages on terminal, run this
```
bin/kafka-console-consumer.sh --topic product_topic --from-beginning --bootstrap-server localhost:9092
```
#### Or use a totally different service for consuming the messages ✨
Demo Application for consuming messages: [Kafka-Consumer](https://github.com/therahulsahu/kafka-consumer)

