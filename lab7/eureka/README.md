## Docker
mvn clean install

docker build -t aui-eureka .

docker run --name eureka aui-eureka
