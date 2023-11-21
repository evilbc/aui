FROM eclipse-temurin:17.0.6_10-jre

ENV VERSION="0.0.1-SNAPSHOT"

ENV SERVER_PORT=8080

EXPOSE 8080

COPY target/lab7.eureka-${VERSION}.jar /opt/lab7-eureka/lab7-eureka.jar

CMD ["java", "-jar", "/opt/lab7-eureka/lab7-eureka.jar"]
