FROM adoptopenjdk/openjdk11:jdk-11.0.9.1_1-slim
ENV JAVA_OPTS=""
ARG JAR_FILE
ADD ${JAR_FILE} app.jar
 # use a volume is mor efficient and speed that filesystem
VOLUME /tmp
EXPOSE 8080
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS  -jar /app.jar" ]