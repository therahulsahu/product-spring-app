echo "\nStart Creating Product Process"
curl --location --silent --output --request POST 'http://localhost:8080/api/productlist/v1/createproduct' --header 'Content-Type: application/json' --data-raw '{
     "variables": {
         "order": {
             "value": "null",
             "type": "String"
        }
    }
}'
