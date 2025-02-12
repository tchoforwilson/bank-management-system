FROM eclipse-temurin:17-jdk-focal

RUN addgroup --gid 1000 app && adduser --system --uid 1000 --group app
USER app

WORKDIR /app

COPY target/*.jar app.jar

EXPOSE 9001
CMD ["mvn", "spring-boot:run"]

ENTRYPOINT ["java", "-jar", "app.jar"]
