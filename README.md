# CampusHub GraphQL — CQRS Practice Project

**Software Architecture Course | Afeka College**

A Spring Boot 4 skeleton project demonstrating the **CQRS (Command Query Responsibility Segregation)** pattern implemented via **GraphQL** (Queries = Read Model, Mutations = Write Model).

## Tech Stack
- Java 25
- Spring Boot 4.0.0
- Spring for GraphQL
- PostgreSQL
- Maven

## Your Assignment

Open `StudentController.java` and complete the **4 TODO methods**.  
The reference solution is shown in **Slide 15** of the lecture presentation.

## Running the Project

1. Update `server.port` in `application.properties` to your team's assigned port (see lab guide)
2. Ensure PostgreSQL is running with a database named `campushub`
3. Run: `mvn spring-boot:run`
4. Open GraphiQL at: `http://localhost:<YOUR-PORT>/graphiql`
