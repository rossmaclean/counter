FROM zenika/alpine-maven as build
WORKDIR /app
ADD . .
RUN mvn clean install

FROM openjdk:8-jdk-alpine
COPY --from=build /app/target/counter-0.0.1-SNAPSHOT.jar .

CMD ["java", "-jar", "counter-0.0.1-SNAPSHOT.jar"]