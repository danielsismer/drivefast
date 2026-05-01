# 🚗 DriveFast API

A RESTful API for vehicle rental management, built with **Java 17**, **Spring Boot 3**, and **MySQL** — following **CQRS**, **SOLID principles**, and a clean layered architecture.

---

## 📌 Overview

DriveFast is a backend API designed to manage the core operations of a vehicle rental platform. It handles clients, cars, and locations through a well-structured architecture that separates read and write responsibilities, making the codebase scalable, testable, and easy to maintain.

---

## 🏗️ Architecture

The project follows **CQRS (Command Query Responsibility Segregation)**, separating every operation into commands (write) and queries (read).

```
src/
└── main/java/com/drive/fast/
    ├── api/
    │   ├── controller/
    │   │   ├── ClientController.java
    │   │   ├── CarController.java
    │   │   └── LocationController.java
    │   └── dto/
    │       ├── request/
    │       │   ├── CreateClientRequest.java
    │       │   ├── UpdateClientRequest.java
    │       │   ├── CreateCarRequest.java
    │       │   └── CreateLocationRequest.java
    │       └── response/
    │           ├── ClientResponse.java
    │           ├── CarResponse.java
    │           └── LocationResponse.java
    │
    ├── application/
    │   ├── command/
    │   │   ├── client/
    │   │   │   ├── create/
    │   │   │   │   ├── CreateClientCommand.java
    │   │   │   │   └── CreateClientCommandHandler.java
    │   │   │   ├── update/
    │   │   │   │   ├── UpdateClientCommand.java
    │   │   │   │   └── UpdateClientCommandHandler.java
    │   │   │   └── delete/
    │   │   │       └── DeleteClientCommandHandler.java
    │   │   ├── car/
    │   │   └── location/
    │   │
    │   ├── query/
    │   │   ├── client/
    │   │   │   ├── getbyid/
    │   │   │   │   ├── GetClientByIdQuery.java
    │   │   │   │   └── GetClientByIdQueryHandler.java
    │   │   │   └── getall/
    │   │   │       └── GetAllClientsQueryHandler.java
    │   │   ├── car/
    │   │   └── location/
    │   │
    │   ├── facade/
    │   │   ├── client/
    │   │   │   ├── port/
    │   │   │   │   ├── ClientCommandFacadePort.java
    │   │   │   │   └── ClientQueryFacadePort.java
    │   │   │   ├── ClientCommandFacade.java
    │   │   │   └── ClientQueryFacade.java
    │   │   ├── car/
    │   │   └── location/
    │   │
    │   └── mapper/
    │       ├── client/
    │       │   └── ClientMapper.java
    │       ├── car/
    │       └── location/
    │
    ├── domain/
    │   ├── entity/
    │   │   ├── Client.java
    │   │   ├── Car.java
    │   │   └── Location.java
    │   └── exception/
    │       ├── client/
    │       │   ├── ClientNotFoundException.java
    │       │   └── EmailAlreadyExistsException.java
    │       ├── car/
    │       └── location/
    │
    └── infrastructure/
        └── persistence/
            ├── ClientRepository.java
            ├── CarRepository.java
            └── LocationRepository.java
```

---

## 🔄 Request Flow

Every request follows the same path across all entities:

```
HTTP Request
    ↓
Controller          (receives DTO request, calls facade)
    ↓
Facade              (orchestrates: mapper + handler)
    ↓
Mapper              (converts Request → Command/Query)
    ↓
Handler             (business logic, calls repository)
    ↓
Repository          (persists or retrieves from DB)
    ↓
Mapper              (converts Entity → Response DTO)
    ↓
HTTP Response
```

---

## 🧩 Design Decisions

### CQRS
Commands handle all write operations (create, update, delete). Queries handle all read operations (getById, getAll). Each operation has its own Handler, keeping responsibilities isolated.

### Facade + Port (Interface)
The Controller only knows the `FacadePort` interface — never the concrete implementation. This makes testing trivial (just mock the port) and allows swapping implementations without touching the controller.

### Factory Method on Entities
Entities expose a static `create()` method instead of relying on setters. This ensures objects are always created in a valid, consistent state.

```java
Client client = Client.create(command.nome(), command.cnh(), command.email());
```

### Mapper without annotations
Conversions between layers are done manually in a `@Component` mapper — no MapStruct or external annotation processors. Explicit, easy to read, easy to debug.

---

## 📦 Entities

### Client
Represents a driver registered in the platform.

| Field | Type | Description |
|-------|------|-------------|
| id | Long | Primary key |
| nome | String | Full name |
| cnh | String | Driver's license number |
| email | String | Unique email address |
| createdAt | LocalDateTime | Registration date |

### Car *(in progress)*
Represents a vehicle available for rental.

| Field | Type | Description |
|-------|------|-------------|
| id | Long | Primary key |
| modelo | String | Car model |
| placa | String | License plate |
| ano | Integer | Manufacturing year |
| disponivel | Boolean | Availability status |

### Location *(in progress)*
Represents a rental transaction between a client and a car.

| Field | Type | Description |
|-------|------|-------------|
| id | Long | Primary key |
| client | Client | Renting client |
| car | Car | Rented car |
| dataInicio | LocalDate | Rental start date |
| dataFim | LocalDate | Rental end date |

---

## 🛣️ Endpoints

### Client

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/clients` | Create a new client |
| PUT | `/clients/{id}` | Update a client |
| DELETE | `/clients/{id}` | Delete a client |
| GET | `/clients/{id}` | Get client by ID |
| GET | `/clients` | List all clients |

### Car *(in progress)*

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/cars` | Register a new car |
| PUT | `/cars/{id}` | Update a car |
| DELETE | `/cars/{id}` | Delete a car |
| GET | `/cars/{id}` | Get car by ID |
| GET | `/cars` | List all cars |

### Location *(in progress)*

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/locations` | Create a new rental |
| PUT | `/locations/{id}` | Update a rental |
| DELETE | `/locations/{id}` | Cancel a rental |
| GET | `/locations/{id}` | Get rental by ID |
| GET | `/locations` | List all rentals |

---

## ⚙️ Tech Stack

| Technology | Version |
|-----------|---------|
| Java | 17 |
| Spring Boot | 3.5 |
| Spring Data JPA | 3.5 |
| Hibernate | 6.6 |
| MySQL | 8+ |
| Lombok | 1.18 |
| Maven | 3.x |

---

## 🚀 Getting Started

### Prerequisites
- Java 17+
- MySQL 8+
- Maven 3+

### 1. Clone the repository
```bash
git clone https://github.com/danielsismer/drivefast.git
cd drivefast/fast
```

### 2. Create the database
```sql
CREATE DATABASE drivefast;
```

### 3. Configure `application.properties`
```properties
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/drivefast
spring.datasource.username=root
spring.datasource.password=your_password

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
spring.jpa.show-sql=true

server.port=8081
```

### 4. Run
```bash
mvn spring-boot:run
```

API available at `http://localhost:8081`

---

## 📋 Roadmap

- [x] Client CRUD with CQRS
- [ ] Custom queries for Client (filter by name, email, cnh)
- [ ] Pagination on list endpoints
- [ ] Car CRUD with CQRS
- [ ] Location CRUD with CQRS
- [ ] Global exception handler
- [ ] Input validation with detailed error responses
- [ ] API documentation with Swagger/OpenAPI

---

## 👤 Author

**Daniel Sismer**
[github.com/danielsismer](https://github.com/danielsismer)
