FROM openjdk:11-jre-slim
ENV PARAMS=""
ADD *.jar /demo.jar
ENTRYPOINT ["sh", "-c", "java -jar /demo.jar $PARAMS"]