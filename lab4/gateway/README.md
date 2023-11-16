## Docker
mvn clean install

docker build -t aui-gateway .

docker run --name gateway aui-gateway
