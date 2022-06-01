FROM maven:3.8.2-jdk-8

WORKDIR /BookStore-app
COPY . .
RUN mvn clean install -DskipTests
