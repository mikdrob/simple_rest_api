# Simple Spring Boot Rest API

## Description
The API uses local postrgeSQL database with create-drop option on 8888 port. Datainit class adds a record "Siim Toomingas" on startup.
Testing is done with in-memory H2 database.

## Setup
Start the database server (PostgreSQL)

Run the command:

    java -jar practice-0.0.1-SNAPSHOT.jar

In browser open the link

    localhost:8888/swagger-ui.html

Alternatively you can send requests manually:<br>

Get request:

    localhost:8888/api/v1/person

Post request:

    curl -X POST "http://localhost:8888/api/v1/person" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"name\": \"Firstname Lastname\"}"

Search by name that includes provided string. e.g.

    localhost:8888/api/v1/person/name?search=siim%20t
     
## Features
* Validation
* Exception Handling
* Unit and Mock tests
* No native sql queries
