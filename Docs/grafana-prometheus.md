GRAFANA AND PROMETHEUS INTEGRATION INTO SPRINGBOOT APPLICATION

 
 STEP -1 : Installation of Grafana And Prometheus 

You can download these application by using the below link and follow along the installation guide for your particular type of OS and complete the installation:

https://grafana.com/grafana/download?platform

STEP -2 : Setup inside the Spring Boot Project

•	Now add the Spring Boot  Actuator and Prometheus dependencies in the pom.xml file or you can just copy paste the below dependencies:

SPRING BOOT ACTUATOR DEPENDENCY

<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter actuator </artifactId>
</dependency>

PROMETHEUS DEPENDENCY

<dependency>
			<groupId>io.micrometer</groupId>
			<artifactId>micrometer-registry-prometheus</artifactId>
			<scope>runtime</scope>
</dependency>

•	After the installation is successfully completed, you can check http://localhost:3000/ this is the page for Grafana.

<img width="317" alt="image" src="https://user-images.githubusercontent.com/76655727/178793085-60132b96-6b1d-48e3-9368-61d8e2ef07a8.png">

•	Create the username and password to sign in.

•	http://localhost:9090/ this is the page for Prometheus.

<img width="356" alt="image" src="https://user-images.githubusercontent.com/76655727/178793187-175f7a0d-cd15-49c0-9ee7-29135713fc77.png">

•	After the page is loaded add the following into the applications.properties file :

management.endpoints.web.exposure.include=*

management.endpoint.health.show-details=always

•	After  you are able to see this page, click on the globe icon on the left hand side of the execute button you will get a list of the available metrices as shown below.

<img width="359" alt="image" src="https://user-images.githubusercontent.com/76655727/178793282-21ee9ac2-1ea3-4323-83d8-0b385dc9fc4d.png">

•	You can choose the one that you want to check the result of. 

•	Once you are able to see the result of the selected metrices then it means you prometheus is successfully integrated with your Spring Boot Application.

STEP -3 : Adding Prometheus into Grafana

•	After you can logged into the Grafana server you need to head into “Configuration -> Data Source” option as shown in the below figure.

<img width="357" alt="image" src="https://user-images.githubusercontent.com/76655727/178793419-453dec6c-e447-45c7-886d-1721728ba098.png">

•	Now add Prometheus. 

<img width="359" alt="image" src="https://user-images.githubusercontent.com/76655727/178793480-8b6fa610-07bf-49ce-9294-28ae2240be6c.png">

<img width="360" alt="image" src="https://user-images.githubusercontent.com/76655727/178793508-a3887f51-a021-4529-a967-62c4d715eb2d.png">

•	Now finish the above setup window And you have successfully completed Grafana and Prometheus into your project.

STEP -4 : Final

•	After step-3 click on the “+” button as shown below and click on the “create new panel”.

<img width="346" alt="image" src="https://user-images.githubusercontent.com/76655727/178793591-bd0194da-30d7-41bc-8a47-406edbafa78e.png">

•	Add the desired panel by giving the metric in the “Metrics browser” field that’s it Hurray ! you have completed the final step.

<img width="360" alt="image" src="https://user-images.githubusercontent.com/76655727/178793701-6b6123aa-848b-4029-815e-49f1933e48a4.png">

STEP -5 : Additional tips

•	Instead of adding new panel Manually there are already built Dashboard Online search the most relevant one and add that dashboard into your project.

•	For more detailed information on Integration and Alert creation go through the below video.

REFERENCE VIDEO : https://www.youtube.com/watch?v=gJZhdEJvZmc
