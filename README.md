# RTO Processing app.
A real time order processing backend.

## Description
I created this application to learn more about Spring Boot and the various libraries surrounding it such as Spring Data and Spring Kafka. I operates on the flow of an http request sends in the order, then it is stored and put into kafka. The application features listeners that act on events being put into kafka to modify and process said orders.

## Dependencies

* Java 21 or greater
* Docker

### Installing
Run
```bash
docker build -t rto-processing-system:latest .
```

### Executing
```bash
docker compose up
```

## Author

Owen Bryan.
