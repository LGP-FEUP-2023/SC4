# Dead Man Switch - Backend

## Modules

### user-entity-core
For most of the business logic

### user-entity-entrypoint:user-entity-entrypoint-rest
This should contain all the logic of the restapi, and will usually be the entrypoint for the application

### user-entity-external:user-entity-external-database
database access object and logic should live here

### Running the application in dev mode

#### Linux + MacOs
```shell script
```shell script
## Build and run tests ##
./gradlew build test
```

```shell script
## Otherwise, just run ##
./gradlew quarkus:dev
```

#### Windows
```shell script
## Build and run tests ##
./gradlew.bat build test
```

```shell script
## Otherwise, just run ##
./gradlew.bat quarkus:dev
```

Running in dev mode enables live coding.<br/>
Swagger will be automatically redeployed with save.<br/>
Logs will be displayed in the same console window.<br/>

### Direct call to endpoint

```shell script
http://localhost:8080/api/user-entity/v1/user
```

### Swagger-ui

```shell script
http://localhost:8080/swagger-ui/#/
```

### Packaging and running the application
If you want to build an _über-jar_, execute the following command:

```shell script
./gradlew build -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar user-entity-entrypoint/user-entity-entrypoint-rest/build/user-entity-entrypoint-rest-1.0-SNAPSHOT-runner.jar`.
