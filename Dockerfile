FROM maven:3.8.1-openjdk-11-slim

COPY pom.xml fizzbuzz/

COPY src/ fizzbuzz/src/

WORKDIR fizzbuzz/

RUN mvn clean install

ENTRYPOINT [ "java", "-jar", "/fizzbuzz/target/fizzbuzz.jar"]