FROM openjdk:17
#CMD ["./mvnw", "clean", "package"]
ARG JAR_FILE_PATH=/build/libs/aws-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE_PATH} app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]