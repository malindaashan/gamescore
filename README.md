# gamescore

This project can be run with as embedded jar file.

Main Tech stack used - java 17 + spring boot 3.4 + hibernate + gradle

You can simply compile this by using gradle assemble and run as a  jar. Please make sure you change the appropriate database credentials in application.yml

if you are running this as jar file server will run on port 8080.

The postman collection can be found in the resources folder.

Below are the API's developed

### POST - "/api/v1/score" (A REST API that allows saving a user's game scores.)
Request Body - {
"userId":1,
"gameId1":1,
"score": 12.33
}

### GET - "/api/v1/score/top10" (Create a REST API to sort and retrieve a game's top ten highest scores.)
Request param - gameId (Integer)

### GET - "/api/v1/score/user-highest-score" ( A REST API to obtain the user's highest scores in each game.)
Request param - userId (Integer)

####  Improve Performances
And if we are improve the performance we can have an index on score table where userId and gameId is saved. 

Also we can use pagination on api retrievals.

We can implement caching service as an intermediate.

#### Assumptions made

A new table has been created called score which has many to one relationships with Game and User entities 
