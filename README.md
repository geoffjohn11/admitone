admitone
=========
##design
Rest API backend with AngularJS frontend

## build 
After downloading the app, navigate to the root of the project and build with maven.  You will need Java 8 and Maven 3.x

    mvn clean install

The app can be launched by executing the jar

    java -jar target/admitone-0.1.0.jar

## navigate
To use the app GUI:

    navigate to https://localhost:8443/index.html#/search

## sample POST purchase data

    curl -k -H "Content-Type: application/json" -X POST -d '{"usernameShowIdPK":{"username":"me", "showId":"1"}, "ticketCount":"50"}' https://localhost:8443/purchase

## sample POST exchange purchase

    curl -k -H "Content-Type: application/json" -X POST -d '{"username":"me", "fromShowId":"1","toShowId":"2", "ticketCount":"35"}' https://localhost:8443/exchange

## sample POST cancel purchase

    curl -k -H "Content-Type: application/json" -X POST -d '{"username":"me", "showId":"2", "ticketCount":"2"}' https://localhost:8443/cancel                  
