FROM openjdk:21-alpine

EXPOSE 8083

WORKDIR /app

ENV SPRING_SERVER_PORT=8080
ENV SPRING_JWT_SECRET="YmF0bWFuIGJhdG1hbiBiYXRtYW4="
ENV SPRING_URL_PRODUCT=http://localhost:8082

COPY .mvn/ .mvn/
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline

COPY src ./src

CMD [ "./mvnw", "spring-boot:run"]