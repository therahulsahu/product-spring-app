Camunda Doc:

BPMN Service Task:
Use Camunda Modeller to model the process. The process model composes of four service tasks:

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
