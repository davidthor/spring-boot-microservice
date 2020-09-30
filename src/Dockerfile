FROM gradle:jdk11 as build
WORKDIR /home/gradle/src
COPY --chown=gradle:gradle . .
RUN gradle build

FROM openjdk:14-slim
COPY --from=build /home/gradle/src/build/libs/*.jar /app/app.jar
CMD [ "java", "-jar", "/app/app.jar" ]
