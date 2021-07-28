FROM maven:alpine

COPY pom.xml fizzbuzz/

COPY src/ fizzbuzz/src/

WORKDIR fizzbuzz/

RUN mvn clean install

ENTRYPOINT [ "java", "-jar", "/fizzbuzz/target/fizzbuzz.jar"]