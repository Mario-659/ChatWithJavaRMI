# Console Chat Application

Simple client-server chat app implemented with java rmi

## Technologies

* Lombok
* Log4j2
* JUnit 5
* Mockito

## Setup

Running server with gradle:

    C:\Users\User\ChatWithRMI> gradle server::run

Running client:

    C:\Users\User\ChatWithRMI> gradle --console plain client:run

Building jar with gradle:

    C:\Users\User\ChatWithRMI> gradle server::shadowJar

By default, server and client run on localhost, port 55. To run on given host and port:

    C:\Users\User\ChatWithRMI> gradle server:run --args="<host> <port>"

## Functionalities

* Create chat rooms
* Chat with multiple clients