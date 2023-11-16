## Docker
mvn clean install

docker build -t aui-game .

docker run --name game aui-game
