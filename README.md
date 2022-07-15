# product-spring-app

This repository contains a collection of Spring boot micro-services and a frontend application made using Angular.

| S/N | Service                    | Tech                                                                                                            | Description                                                                                   |
| :-: | :------------------------- | --------------------------------------------------------------------------------------------------------------- | :-------------------------------------------------------------------------------------------- |
|  1  | product-service            | ![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)    | Product Catalogue backend service with Create Read Update Delete functionalites for Products. |
|  2  | product-portal             | ![Angular](https://img.shields.io/badge/angular-%23DD0031.svg?style=for-the-badge&logo=angular&logoColor=white) | FrontEnd Application made with Angular.                                                       |
|  3  | email-notification-service | ![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)    | Backend service responsible for automatic email and sms notification after product creation.  |
|  4  | report-generation-service  | ![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)    | Backend service responsible for report generation of products. (PDF, Excel, CSV)              |

## Requirements (Prerequisite's)
- Java 11
- Node JS
- Angular
- Maven

## Flow
<img width="729" alt="image" src="https://user-images.githubusercontent.com/55999865/178815246-ff5e4bcb-2de8-4b1b-90fa-0cdee0a53353.png">

## Docs
- [Grafana Prometheus](https://github.com/therahulsahu/product-spring-app/blob/main/Docs/grafana-prometheus.md)
- [Kafka-integration](https://github.com/therahulsahu/product-spring-app/blob/main/Docs/Kafka.md)
- [ELK](https://github.com/therahulsahu/product-spring-app/blob/main/Docs/ELK.md)
- [Camunda](https://github.com/therahulsahu/product-spring-app/blob/main/Docs/Camunda.md)
- [APM-skywalking](https://github.com/therahulsahu/product-spring-app/blob/main/Docs/APM-skywalking.md)

## How to Run:
1. Start the couchbase db and make a bucket named `products`.
2. Start the Frontend application (Product Portal) using `npm install` and then `ng serve --open` in root directory of the application. It will automatically open your default browser with `localhost:4200`.
3. Put your couchbase credentials in the `application.property/yml` file in the backend services.
4. Start Product service using either command `mvn spring-boot:run` or using your favourite IDE. It will be running on `port 8080`.
5. Start other services using the same above steps.
6. Try to hit an endpoint `http://localhost:8080/api/productlist/v1/getlist` or use the Frontend UI to create, read, update and delete products.
