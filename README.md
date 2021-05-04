# Simple Spring Boot Rest API

## Setup
start the database server (PostgreSQL)

Run the command:

    java -jar practice-0.0.1-SNAPSHOT.jar

In browser open the link
localhost:8888/swagger-ui.html

Get request:
localhost:8888/api/v1/person

post request

    curl -X POST "http://localhost:8888/api/v1/person" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"name\": \"Firstname Lastname\"}"

search by name that includes provided string

    http://localhost:8888/api/v1/person/name="FirstName LastName"
     
## Features
* Validation
* Exception Handling
* Unit and Mock tests
* No native sql queries