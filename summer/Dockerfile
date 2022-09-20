FROM adoptopenjdk/openjdk11
CMD ["./gradlew", "clean"]

CMD ["./gradlew", "build"]

COPY ./build/libs/summer-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]