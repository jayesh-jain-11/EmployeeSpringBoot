# Project Title

## Table of Contents

# Employee Management System

A full-stack **Employee Management System** built with **Spring Boot**, **React**, **PostgreSQL**, and **Docker**, featuring **JWT authentication**, secure REST APIs, pagination & sorting, and a CI/CD pipeline using **GitHub Actions**. Designed with production-ready practices and containerized deployment. 🚀

---

## ✅ Features

### Backend (Spring Boot)

- **JWT authentication & authorization**
- **Spring Security** with custom JWT filter
- **Global exception handling**
- **RESTful APIs**
- Pagination & sorting (Spring Data JPA)
- PostgreSQL integration
- Consistent API response structure
- CORS configuration
- Dockerized backend service

### Frontend (React)

- Login & registration
- Protected routes
- Axios interceptor for JWT
- Employee CRUD operations
- Pagination-ready UI
- Nginx-based production build
- Dockerized frontend service

### DevOps & Deployment

- Docker & Docker Compose
- Multi-container architecture
- GitHub Actions CI/CD pipeline
- Docker Hub image publishing

---

## 🧰 Tech Stack

| Layer          | Technology                   |
| -------------- | ---------------------------- |
| Frontend       | React, Axios, React Router   |
| Backend        | Spring Boot, Spring Security |
| Database       | PostgreSQL                   |
| Authentication | JWT                          |
| DevOps         | Docker, Docker Compose       |
| CI/CD          | GitHub Actions               |
| Web Server     | Nginx                        |

---

## 📁 Project Structure

```
EMPLOYEE_PROJECT/
├── EmployeeDemo/           # Spring Boot Backend
│   ├── controller
│   ├── service
│   ├── repo
│   ├── model
│   ├── config
│   ├── exception
│   └── apiresponse
│
├── employee-frontend/      # React Frontend
│   ├── src
│   ├── public
│   └── Dockerfile
│
├── docker-compose.yml
├── README.md
└── .github/
		└── workflows/
				└── ci-cd.yml
```

---

## 🔐 Authentication Flow

1. User logs in via `POST /login`
2. Backend validates credentials
3. JWT token is generated and returned
4. Token is stored in browser `localStorage`
5. Axios interceptor attaches token to requests
6. Spring Security validates token on each request

---

## 🔁 API Response Format

All APIs follow a consistent response structure:

```json
{
  "success": true,
  "message": "Employees fetched successfully",
  "data": {
    "page": 0,
    "size": 5,
    "totalPages": 2,
    "totalElements": 10,
    "employees": []
  }
}
```

### Pagination Example

GET /api/employees?page=0&size=5&sortBy=empid&direction=asc

---

## 🐳 Docker Setup

### Start the Application

```bash
docker compose up -d
```

### Stop and Clean Containers

```bash
docker compose down -v
```

---

## ⚙️ Environment Configuration

### Backend (Docker Environment Variables)

```env
SPRING_DATASOURCE_URL=jdbc:postgresql://db:5432/employeedb
DB_USER=jayeshjain
DB_PASSWORD=******
JWT_SECRET=******
APP_CORS_ORIGINS=http://localhost:3000,http://192.168.0.39:3000
```

> 💡 Note: Spring Boot typically reads `SPRING_DATASOURCE_USERNAME` and `SPRING_DATASOURCE_PASSWORD` for data source authentication. If your app uses different env names, ensure the application properties or environment mapping are correct.

### Frontend (Build-Time Variable)

```env
REACT_APP_API_BASE_URL=http://localhost:8080
```

> ⚠️ React environment variables are injected at build time — changing them requires rebuilding the frontend.

---

## ⚙️ CI/CD Pipeline

- Triggered on every push to the `main` branch
- Builds the Spring Boot JAR
- Builds Docker images for frontend and backend
- Pushes images to Docker Hub  
  Pipeline file: `.github/workflows/ci-cd.yml`

---

## 🧪 API Testing

Use Postman or similar with the JWT token:

Header:

```
Authorization: Bearer <your_jwt_token>
```

---

## 🚀 Future Enhancements

- Role-based authorization (ADMIN / USER)
- Refresh token support
- Search and filtering
- Swagger / OpenAPI documentation
- Kubernetes deployment

---

## ✍️ Author

**Jayesh Jain**  
MCA Student | Full Stack Developer  
GitHub: https://github.com/jayeshjain11

---

Would you like me to also create a PR with this change? (I can open it and paste the PR description.)
