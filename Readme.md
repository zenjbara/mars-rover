# MARS ROVER KATA

## Statement:

* You are given the initial starting point (x,y) of a rover and the direction (N,S,E,W) it is facing.
* The rover receives a character array of commands.
* Implement commands that move the rover forward/backward (f,b).
* Implement commands that turn the rover left/right (l,r).
* Implement wrapping at edges. But be careful, planets are spheres. Connect the x edge to the other x edge, so (1,1) for
  x-1 to (5,1), but connect vertical edges towards themselves in inverted coordinates, so (1,1) for y-1 connects to (
  5,1).
* Implement obstacle detection before each move to a new square. If a given sequence of commands encounters an obstacle,
  the rover moves up to the last possible point, aborts the sequence and reports the obstacle.

## TDD:

This kata is developed with TDD approach, this is why the commits are named as follows:

* test method name: KO  (red phase)
* test method name: OK  (green phase)
* refacto: description (refactor phase)

## Implementation:

This is a Spring Boot project providing two services:

* get rover location: `GET  localhost:8080/rover/coordinate/`
* move the rover : `POST localhost:8080/compute/5`
  with request body `{"commands": "..."}`

 ```bash
 Example request body:
{
  "commands": "FRB"
}
```

## Run the project:

mvn spring-boot:run

## Run the unit tests (JUnit 5) and generate the JAR:

mvn clean package