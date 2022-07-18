                            ELK 

1.	Make sure that JAVA_HOME environment is set up
2.	https://www.youtube.com/watch?v=9g-h1biMn2E is the main video that I have referred
3.	Make sure to install logstash-7.15.0, kibana-7.15.0-darwin-x86_64, elasticsearch-7.15.0
4.	In my project I have not created a config file but I have sent the parameters in terminal



ELK commands for staring the project

Logstash

cd Downloads/

cd logstash-7.15.0

bin/logstash -e 'input {file {path => "/Users/harshith.sr/Downloads/logs/elk-stack.log" start_position => "beginning"}}output {elasticsearch {hosts => ["localhost:9200"]}stdout { codec => rubydebug }}'

Elastic search

cd Downloads

cd elasticsearch-7.15.0

cd bin/

./elasticsearch


Kibana- you need to uncomment (elasticsearch.hosts: ["http://localhost:9200”]) in config file(kibana.yml)


cd Downloads

cd kibana-7.15.0-darwin-x86_64

cd bin/

 ./kibana


--------------------------------------------------------

Important URL’s

To check if Elasticsearch is working
http://127.0.0.1:9200/

To see the indexes of Elasticsearch
http://localhost:9200/_cat/indices

To see if Kibana is working

http://localhost:5601/




