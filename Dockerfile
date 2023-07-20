FROM eclipse-temurin:17

LABEL mentainer="guruprasad1736@gmail.com"

WORKDIR /app

COPY Innovative-Solutions/target/Innovative-Solutions-0.0.1-SNAPSHOT.jar /app/innovative-solutions.jar

ENTRYPOINT ["java","-jar","innovative-solutions.jar"]