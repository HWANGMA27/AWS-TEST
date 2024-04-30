FROM openjdk:17
ARG JAR_FILE_PATH=/build/libs/aws-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE_PATH} test.jar
ENTRYPOINT ["java", "-jar", "test.jar"]