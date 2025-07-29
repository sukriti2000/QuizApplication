# Quiz Application

A microservices-based Quiz Application built with Spring Boot.  
The project is divided into four independent microservices:

## Microservices

1. **Question Service**  
   Manages quiz questions — create, read, update, and delete questions.

2. **Quiz Service**  
   Handles quiz creation, management, and scoring logic.

3. **Service Registry**  
   Service discovery mechanism for all microservices using Eureka.

4. **API Gateway**  
   Routes incoming requests to the appropriate microservice, handles cross-cutting concerns like authentication.

## Technologies Used

- Java 8 / 11
- Spring Boot
- Spring Cloud Netflix Eureka (Service Registry)
- Spring Cloud Gateway (API Gateway)
- Maven for build management
- MongoDB (or your choice of DB) for persistence
- Docker (optional for containerization)
- RESTful APIs

## Getting Started

### Prerequisites

- Java 8 or higher installed
- Maven installed
- MongoDB running locally or connection string configured
- Docker (optional, if using containers)

### Running the Application

Each microservice can be run independently. For example, to run the Question Service:

```bash
cd question-service
mvn spring-boot:run
Make sure your Service Registry is running before starting other services.

Configuration
Each microservice contains its own application.yml file for configuration, including database connection details and service registry info.

API Documentation
You can use Swagger UI or Postman collections (if provided) to test the APIs of each microservice.

Project Structure
Copy
Edit
quiz-application/
│
├── question-service/
├── quiz-service/
├── service-registry/
└── api-gateway/
