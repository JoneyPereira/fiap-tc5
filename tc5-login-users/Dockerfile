FROM openjdk:21-alpine

EXPOSE 8080

WORKDIR /app

ENV SPRING_SERVER_PORT=8080
ENV SPRING_DATA_SOURCE_URL=jdbc:postgresql://auth-db:5434/api_login_users_db
ENV SPRING_DATA_SOURCE_USERNAME=admin
ENV SPRING_DATA_SOURCE_PASSWORD=admin
ENV SPRING_JWT_SECRET="YmF0bWFuIGJhdG1hbiBiYXRtYW4="

COPY .mvn/ .mvn/
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline

COPY src ./src

CMD [ "./mvnw", "spring-boot:run"]