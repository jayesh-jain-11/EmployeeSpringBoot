# EmployeeSpringBoot

A Spring Boot application for managing employee data with REST API endpoints and containerized deployment.

## Project Description

EmployeeSpringBoot is a robust backend service built with Spring Boot that provides comprehensive employee management functionality. It features RESTful API endpoints for CRUD operations, database persistence, and is designed for easy deployment using Docker and Docker Compose.

## Project Structure

```
EmployeeSpringBoot/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/employee/
│   │   │       ├── controller/       # REST API controllers
│   │   │       ├── service/          # Business logic layer
│   │   │       ├── repository/       # Data access layer
│   │   │       ├── model/            # Entity models
│   │   │       └── Application.java  # Main entry point
│   │   └── resources/
│   │       └── application.properties # Configuration
│   └── test/                          # Unit and integration tests
├── docker-compose.yml                 # Docker Compose configuration
├── Dockerfile                         # Container image definition
├── pom.xml                            # Maven dependencies
└── README.md                          # This file
```

## Quick Start with Docker Compose

### Prerequisites
- Docker and Docker Compose installed on your system

### Steps

1. **Clone the repository**
   ```bash
   git clone https://github.com/jayesh-jain-11/EmployeeSpringBoot.git
   cd EmployeeSpringBoot
   ```

2. **Start the application**
   ```bash
   docker-compose up -d
   ```

3. **Verify the application is running**
   ```bash
   docker-compose ps
   ```

4. **Access the application**
   - Application URL: `http://localhost:8080`
   - API endpoints: `http://localhost:8080/api/employees`

5. **Stop the application**
   ```bash
   docker-compose down
   ```

## Environment Variables

Configure the following in your `docker-compose.yml` or `.env` file:
- `SPRING_DATASOURCE_URL` - Database connection URL
- `SPRING_DATASOURCE_USERNAME` - Database username
- `SPRING_DATASOURCE_PASSWORD` - Database password

## API Endpoints

- `GET /api/employees` - Get all employees
- `GET /api/employees/{id}` - Get employee by ID
- `POST /api/employees` - Create new employee
- `PUT /api/employees/{id}` - Update employee
- `DELETE /api/employees/{id}` - Delete employee

## License

This project is licensed under the MIT License.
