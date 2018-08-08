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
