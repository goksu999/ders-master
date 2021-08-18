
### Tech Stack

---
- Java 11
- Spring Boot
- Spring Data JPA
- Kotlin 1.5.0
- Restful API
- OpenAPI documentation
- PostgreSQL
- Docker
- Docker compose
- JUnit 4


### Prerequisites

---
- Maven
- Docker
- PostgreSql

### Run & Build

---
There are 2 ways of run & build the application.

#### Docker Compose

For docker compose usage, docker images already push to docker.io

You just need to run `docker-compose up` command
___
*$PORT: 8080*
```ssh
$ cd product
$ docker-compose up
```

#### Maven

file by `"http://localhost:8080"` due to the default value has been settled for docker image network proxy.
___
*$PORT: 8080*
```ssh
$ cd account/product-api
$ mvn clean install
$ mvn spring-boot:run



### Swagger UI will be run on this url
`http://localhost:${PORT}/swagger-ui.html`
