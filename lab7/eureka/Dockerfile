FROM eclipse-temurin:17.0.6_10-jre

ENV VERSION="0.0.1-SNAPSHOT"

ENV SERVER_PORT=8080

EXPOSE 8080

ENV EUREKA_CLIENT_SERVICEURL_DEFAULTZONE=http://localhost:8085/eureka
ENV EUREKA_INSTANCE_INSTANCE_ID=1

COPY target/lab7.eureka-${VERSION}.jar /opt/lab7-eureka/lab7-eureka.jar

CMD ["java", "-jar", "/opt/lab7-eureka/lab7-eureka.jar"]
