# product-spring-app

This repository contains a collection of Spring boot micro-services and a frontend application made using Angular.

| S/N | Service                    | Tech                                                                                                            | Description                                                                                   |
| :-: | :------------------------- | --------------------------------------------------------------------------------------------------------------- | :-------------------------------------------------------------------------------------------- |
|  1  | product-service            | ![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)    | Product Catalogue backend service with Create Read Update Delete functionalites for Products. |
|  2  | product-portal             | ![Angular](https://img.shields.io/badge/angular-%23DD0031.svg?style=for-the-badge&logo=angular&logoColor=white) | FrontEnd Application made with Angular.                                                       |
|  3  | email-notification-service | ![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)    | Backend service responsible for automatic email and sms notification after product creation.  |
|  4  | report-generation-service  | ![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)    | Backend service responsible for report generation of products. (PDF, Excel, CSV)              |

## Requirements
- Java 11
- Node JS
- Angular
- Maven

## Flow
<img width="729" alt="image" src="https://user-images.githubusercontent.com/55999865/178815246-ff5e4bcb-2de8-4b1b-90fa-0cdee0a53353.png">

BPMN Service Task:
Use Camunda Modeller to model the process. The process model composes of four service tasks:
<img width="995" alt="Screenshot 2022-07-15 at 7 30 06 PM" src="https://user-images.githubusercontent.com/76160571/179254435-907ded9e-d0b8-4f9f-975a-6176f25a52e1.png">


create product: Is a Service Task using Java Class as implementation and com.product.model.CreateProductDelegate as the Java Class.
Get product: Is a Service Task using Delegate Expressions as implementation and value of ${getProduct}.
Save data: Is a Service Task using Expression as implementation and value of ${camundaService.saveData(execution)}.
Deliver data in Console: Is a Service Task using External as implementation and topic value of deliverDataInConsole.

Compile & Run:

1. Compile the application
Use the following command to compile the Spring Boot application making use of maven:

$ mvn clean install

2. Run the application
After you have successfully built the Camunda BPM Spring Boot application, the compiled artifact can be found in the target directory. Use the following command to start the Camunda BPM Spring Boot Application.

$ mvn spring-boot:run

3. Execute the example
After the application has started, run the following command in another terminal:

Run the command: Start Process Instance

The following command instantiates a new instance of the create product process and pass the process variable called product with a value of null to the process engine as part of the request body.

$ ./start_process.sh
The script performs the following commands:

curl --location --silent --output --request POST 'http://localhost:8080/api/productlist/v1/createproduct' --header 'Content-Type: application/json' --data-raw '{
     "variables": {
         "product": {
             "value": "null",
             "type": "String"
        }
    }
}'
