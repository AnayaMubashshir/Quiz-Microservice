🧠 Microservices Quiz Application (Spring Boot + Eureka + Gateway)
📋 Overview
This project demonstrates a microservices architecture using Spring Boot, Spring Cloud, Eureka Service Registry, and Spring Cloud Gateway. It includes two core services (Quiz Service and Question Service) registered with Eureka, and an API Gateway that routes client requests.
👉 Currently, no frontend UI is built — all endpoints are tested using Postman.

🚀 Features
- 🧩 Manage quizzes and questions as independent microservices
- 🔀 Service discovery via Eureka Server
- 🌐 Centralized routing through API Gateway
- 🗄️ PostgreSQL integration for quiz data
- ⚙️ RESTful API design — ready for frontend integration

🛠️ Tech Stack
|Component          |Technology                  | 
|Framework          |Java 17                     | 
|Service Discovery  |Spring Cloud Netflix Eureka | 
|API Gateway        |Spring Cloud Gateway        | 
|Database           |PostgreSQL                  | 
|ORM                |Hibernate/JPA               | 
|Build Tool         |Maven                       | 
|API Testing        |Postman                     | 
|IDE                |Eclipse                     | 


▶️ How to Run
- Start Eureka Server (service-registry) → http://localhost:8761
- Start Quiz Service (quiz-service) → runs on 8090
- Start Question Service (question-service) → runs on 8081
- Start API Gateway (api-gateway) → runs on 8765

🌐 Example Endpoints
- Direct Quiz Service → http://localhost:8090/quiz/get/1
- Via Gateway → http://localhost:8765/quiz-service/quiz/get/1
- Direct Question Service → http://localhost:8081/question/get/1
- Via Gateway → http://localhost:8765/question-service/question/get/1

🛠️ Tech Stack & Dependencies

spring-boot-starter-web : Builds RESTful web services using Spring MVC 
spring-boot-starter-data-jpa : Enables ORM with Hibernate and JPA 
postgresql : PostgreSQL JDBC driver for database connectivity 
spring-cloud-starter-netflix-eureka-server : Runs Eureka service registry 
spring-cloud-starter-netflix-eureka-client : Registers services with Eureka  
spring-cloud-starter-gateway : Enables API Gateway routing and filtering
spring-cloud-starter-openfeign : Enables declarative REST clients for inter-service communication 
spring-boot-starter-test : Provides testing libraries for unit and integration tests   






