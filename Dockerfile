FROM adoptopenjdk/openjdk11:alpine-jre

EXPOSE 8080

COPY target/Authorization-0.0.1-SNAPSHOT.jar authapp.jar

CMD ["java", "-jar", "authapp.jar"]