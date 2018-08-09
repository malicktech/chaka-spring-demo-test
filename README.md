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
	
to lauch a service with docker , e.g : gateway

	./mvnw package -DskipTests=true dockerfile:build && docker tag marketcatalog:latest
	
run

	docker run -p 8080:8080 -e "SPRING_PROFILES_ACTIVE=dev" snecommerce/demo
	
push docker hub
docker login
	
	(snecommerce / aqwzsx123)
		
docker push

	./mvnw dockerfile:push
	
# Docker compose

docker-compose -f docker/mysql.yml up -d
docker-compose -f docker/mysql.yml down

	
## h2 localhost
localhost:8080/h2-console

# profile prod

* run the application

	./mvnw spring-boot:run -Drun.jvmArguments="-Dspring.profiles.active=prod"
	

	./mvnw spring-boot:run -Dsprng-boot.run.profiles=prod
	