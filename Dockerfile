FROM openjdk:11-jre-slim
EXPOSE 8080
VOLUME /data
ENV PARAMS=""
ADD *.jar /xhs.jar
ENTRYPOINT ["sh", "-c", "java -jar /xhs.jar $PARAMS"]