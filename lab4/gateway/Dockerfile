FROM eclipse-temurin:17.0.6_10-jre

ENV VERSION="0.0.1-SNAPSHOT"

ENV SERVER_PORT=8080

ENV LAB4_GATEWAY_HOST=localhost:8083

ENV EUREKA_CLIENT_SERVICEURL_DEFAULTZONE=http://localhost:8085/eureka
ENV EUREKA_INSTANCE_INSTANCE_ID=1

EXPOSE 8080

COPY target/lab4.gateway-${VERSION}.jar /opt/lab4-gateway/lab4-gateway.jar

CMD ["java", "-jar", "/opt/lab4-gateway/lab4-gateway.jar"]
