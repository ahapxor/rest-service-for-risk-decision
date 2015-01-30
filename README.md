# rest-service-for-risk-decision
REST service in Java for a simplified risk decision process.

## Build and run service
Service project based on maven, so to run application in embeded tomcat 7 container just run command in the root directory: 
>mvn clean tomcat7:run 

When deployment complete, service will be able at this endpoint:
>http://localhost:8080/decisions

Implemented only POST request handler, any other requests will return http 405 error.

## Usage:
To call service via curl, please, use following command:

>$ curl 'http://localhost:8080/decisions' -H "Content-Type:application/json" -d '{"email": "a@b.se", "first_name" : "a", "last_name": "b", "amount": 100}'

>$ {"accepted":true,"reason":"ok"}

Content-Type header is nescessry to tell server that there is json in post data.

Tests:
To run unit tests via maven, please use:
>mvn clean test

To run unit tests + integration tests:
>mvn clean verify

In this case before firing integration tests tomcat container will be starter and application will be deployed there.

##Project structure:
Project have default maven files structure. Application use spring library for handling REST requests and dependency injection. It does not persist any information and use pretty simple non thread safe storage, create for demo purpose. 

Here a small description of packages and their purposes:
* *com.github.ahapxor.configuration* - application configuration classes, currently contains only purchase amount limits constants, but in general can contains any other application settings
* *com.github.ahapxor.controllers* - contains spring webmvc controlles, that handle requests to server
* *com.github.ahapxor.dtos* - conatins data transport objects. Main purpose of this objects is to transport data over the network
* *com.github.ahapxor.entities* - contains entities close to domain. This entities should be used in bisness logic layer and persisted in storage
* *com.github.ahapxor.repository* - contains classes, that responsible for communication with storage
* *com.github.ahapxor.services* - classes, that contains business logic of application
* *com.github.ahapxor.utils* - different helper classes, that responsible for json serialization/deserialization, dtos and entities convertation etc

Test:
all packages except *com.github.ahapxor.integrationTests* contains unit tests for most part of code, does not require any environment preparation. Test in *com.github.ahapxor.integrationTests* require deployed and working at *http://localhost:8080/decisions* endpoint service (in case of maven verify target deployment does automatically).