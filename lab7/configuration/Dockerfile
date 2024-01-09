FROM eclipse-temurin:17.0.6_10-jre

ENV VERSION="0.0.1-SNAPSHOT"

ENV SERVER_PORT=8080

ENV EUREKA_CLIENT_SERVICEURL_DEFAULTZONE=http://localhost:8085/eureka
ENV EUREKA_INSTANCE_INSTANCE_ID=1

ENV SPRING_PROFILES_ACTIVE=native

ENV SPRING_CLOUD_CONFIG_SERVER_NATIVE_SEARCH_LOCATIONS=file:/var/lab7-configuration/configuration

VOLUME /var/lab7-configuration/configuration

EXPOSE 8080

COPY target/lab7.configuration-${VERSION}.jar /opt/lab7-configuration/lab7-configuration.jar

CMD ["java", "-jar", "/opt/lab7-configuration/lab7-configuration.jar"]
