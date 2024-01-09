FROM eclipse-temurin:17.0.6_10-jre

ENV VERSION="0.0.1-SNAPSHOT"

ENV SERVER_PORT=8080

ENV EUREKA_INSTANCE_INSTANCE_ID=1

ENV SPRING_CONFIG_IMPORT=optional:configserver:http://localhost:8086

EXPOSE 8080

COPY target/lab4.game-${VERSION}.jar /opt/lab4-game/lab4-game.jar

CMD ["java", "-jar", "/opt/lab4-game/lab4-game.jar"]
