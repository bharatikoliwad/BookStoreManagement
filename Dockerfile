FROM maven:3.8.3-jdk-8

WORKDIR /BookStore-app
COPY . .
RUN mvn clean install -DskipTests
