FROM openjdk:17
EXPOSE 8080
WORKDIR /app
COPY target/beerPub-0.0.1-SNAPSHOT.jar ./beer.jar
ENTRYPOINT java -jar ./beer.jar