FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY COPY target/Innovative-Solutions-0.0.1-SNAPSHOT.jar /app/app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080

