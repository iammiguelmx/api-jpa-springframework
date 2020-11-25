FROM openjdk:11
WORKDIR /home
COPY ./target/Demo-API-JPA-0.0.1-SNAPSHOT.jar /usr/src/app/Demo-API-JPA-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/src/app/Demo-API-JPA-0.0.1-SNAPSHOT.jar"]