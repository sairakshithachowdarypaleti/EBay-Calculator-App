# EBay-Calculator-App

This project is a production grade, extensible calculator built using Java and Spring Boot. It supports both simple and chained arithmetic operations like ADD, SUBTRACT, MULTIPLY, DIVIDE, stores history in an H2 in-memory database, and is designed following SOLID principles - especially Open/Close principle.

---

## Feature

- Perform single arithmetic operations via REST
- chain multiple operations in sequence
- Persist history of all calculations in H2 database.
- Extensible using Strategy design pattern
- IoC ready for DI and testing.
- Clean architecture with service, controller, DTO, helper, config, and exception layers.

---

## Tech Stack
- Java 17+
- Spring Boot 3+
- Spring Data JPA
- H2 In memory database
- Maven

---

## Project Structure

```bash
src/main/java/
└── com/ebay/rakshitha/calculator/
    ├── config/         # Configuration classes
    ├── controller/     # REST controllers
    ├── dto/            # Data Transfer Objects
    ├── exception/      # Custom exceptions and handlers
    ├── helper/         # Helper classes
    ├── model/          # Domain models
    ├── repository/     # Spring Data repositories
    ├── service/        # Service layer
    ├── strategy/       # Strategy pattern implementations
    ├── util/           # Utility classes
    └── CalculatorApplication.java  # Main Spring Boot application

src/main/resources/       # Application configuration and resources
``` 

## API usage

### 1. Single operation
**POST** `api/calc`

#### Request
```json
{
  "operation": "MULTIPLY",
  "numberOne": 10,
  "numberTwo": 5
}
```

#### Response
```json
15.0
```

### 2. Chained operation
**POST** `api/calc/chain`

#### Request
```json
{
  "initialValue": 5,
  "operationStepList": [
    {"operation": "ADD", "value": 3},
    {"operation": "SUBTRACT", "value": 2}
  ]
}
```

#### Response
```json
0.0
```

### 3. Get History operation
**GET** `api/calc/history`

#### Response
```json
[
  {
    "id": 1,
    "number1": 10.0,
    "number2": 5.0,
    "operation": "MULTIPLY",
    "result": 50.0,
    "timeStamp": "2025-06-03T14:20:07.306836"
  },
  {
    "id": 2,
    "number1": 5.0,
    "number2": 3.0,
    "operation": "ADD",
    "result": 8.0,
    "timeStamp": "2025-06-03T14:20:18.529106"
  },
  {
    "id": 3,
    "number1": 8.0,
    "number2": 2.0,
    "operation": "SUBTRACT",
    "result": 6.0,
    "timeStamp": "2025-06-03T14:20:18.530814"
  }
]
```

## Running the App
```bash
mvn spring-boot:run
```
Then test via postman
- http://localhost:8080/api/calc
- http://localhost:8080/api/calc/chain
- http://localhost:8080/api/calc/history