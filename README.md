# profile-andreas-be

# Deploy Sprint Boot And Postegres on Render with Web Services and Docker

## Create Spring Boot Project

    https://start.spring.io/

## Add Dependencies Web : spring-boot-starter-web

    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

## Add Dependencies JPA
    
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>


### Create Dockerfile at the root folder

    #
    # Build stage
    #
    FROM maven:3.8.2-jdk-11 AS build
    COPY . .
    RUN mvn clean package -Pprod -DskipTests
    
    #
    # Package stage
    #
    FROM openjdk:11-jdk-slim
    COPY --from=build /target/profile-0.0.1-SNAPSHOT.jar profile.jar
    # ENV PORT=8080
    EXPOSE 8080
    ENTRYPOINT ["java","-jar","profile.jar"]
    

### Building a Dockerfile from the root folder
    By default docker uses the Dockerfile of the current folder if you run a single command like
    Run: docker build -t profile-andreas-be .
    
### Run image with docker on localhost
    Run docker run -p 8080:8080 profile-andreas-be


## Create Postegres database from Render.com
    https://dashboard.render.com/
