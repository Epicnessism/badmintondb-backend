# badmintondb-backend
Rebase Badmintondb as a standalone Java Spring Boot webapp, hoping to leverage JPA.

### References for future work
- https://www.baeldung.com/logback
- https://www.baeldung.com/spring-boot-logging

### Troubleshooting and setup/build issues I ran into
- Lombok + mapstruct not working nicely with springboot: https://stackoverflow.com/questions/70685602/springboot-lombok-mapstruct-not-working-together


### how to drop local db and migrate from fresh
- no idea tbd


### Running locally
- start the local db using docker compose 
  - ```docker compose -f compose.yaml up```
- start the application by running the run config in Intellij
- 