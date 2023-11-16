## Docker
mvn clean install

docker build -t aui-developer .

docker run --name developer -e LAB4_GAME_URL='http://game:8080' aui-developer
