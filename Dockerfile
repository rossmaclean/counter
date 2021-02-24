FROM openjdk:8-jdk-alpine

ADD ./target/counter-0.0.1-SNAPSHOT.jar .

RUN ls

CMD ["java", "-jar", "counter-0.0.1-SNAPSHOT.jar"]