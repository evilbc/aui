## Docker
mvn clean install

docker build -t aui-configuration .

docker run --name configuration aui-configuration
