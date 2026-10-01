# Task Manager API

A simple REST API built with **Spring Boot** to manage tasks (create, read, update, delete).

## Tech
- Java 21
- Spring Boot 4.1.1 (Spring Web, Spring Data JPA, Validation)
- H2 database (file-based)
- Maven

## Endpoints
| Method | URL | What it does |
|--------|-----|--------------|
| GET | /tasks | Get all tasks |
| POST | /tasks | Add a task |
| PUT | /tasks/{id} | Update a task |
| DELETE | /tasks/{id} | Delete a task |

## Run it
```
./mvnw spring-boot:run
```
Server starts at http://localhost:8080

## Example
```
POST /tasks
{ "title": "Learn Spring Boot", "done": false }
```

## What I learned
- Controller, Service, Repository layers
- Dependency injection
- Saving data with JPA and H2
- Input validation and proper 404 errors

## Frontend
React (Vite) app in the `frontend` folder. Run with `npm install` then `npm run dev`, and open http://localhost:5173
