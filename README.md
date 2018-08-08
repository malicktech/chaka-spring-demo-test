demo

# CMD

## Development

* run the application

	./mvnw spring-boot:run

*  build the JAR file with 

	./mvnw clean package
	
* run the JAR file:

	java -jar target/*.jar
	
## Spring data rest

* test

	curl -i -X POST -H "Content-Type:application/json" -d "{  \"firstName\" : \"Frodo\",  \"lastName\" : \"Baggins\" }" http://localhost:8080/people

## Actuator 

Activated default
	
	/health and /info 

to enable

	/info
	/actuator/metrics/metrics/jvm.gc.pause

Actuator now shares the security config with the regular App security rules

	localhost:8080/actuator/health
	
Custom endpoint 
	
	/actuator/features
	
## Docker 

	./mvnw install dockerfile:build