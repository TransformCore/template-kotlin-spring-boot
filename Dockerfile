FROM gradle:jdk8 as builder

COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build


# Use multi stage build to create runtime image
FROM openjdk:8-jre-slim

EXPOSE 8080

COPY --from=builder /home/gradle/src/build/libs/template-kotlin-spring-boot-0.0.1-SNAPSHOT.jar /app/app.jar
WORKDIR /app

# Add user appuser
RUN groupadd -g 1000 appuser && \
    useradd -r -u 1000 -g appuser appuser && \
    mkdir -p /app && chown -R appuser:appuser /app

USER appuser

# TODO Tune JVM_OPTS
ENV JAVA_OPTS=${JVM_OPTS:-"-Xms512m -Xmx512m -XX:+UseG1GC"}

CMD exec java $JAVA_OPTS -jar app.jar