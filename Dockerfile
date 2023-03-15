FROM adoptopenjdk/openjdk8:ubi
ARG JAR_FILE_PATH=build/libs/projectlist-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE_PATH} projectlist-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "projectlist-0.0.1-SNAPSHOT.jar"]