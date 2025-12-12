✅ README.md — Versión profesional para tu proyecto BankInc Card System

📘 BankInc – Card System (Java 17 + Spring Boot + PostgreSQL)

Este proyecto implementa un sistema de gestión de tarjetas para la prueba técnica de desarrollador backend.
Incluye generación de tarjetas, activación, bloqueo, transacciones, anulación y consultas.

🛠️ Tecnologías utilizadas
Tecnología	Versión
Java	17
Spring Boot	3.x
PostgreSQL	18
Maven	3.8+
Swagger UI (estático)	5.10.3
JUnit 5 + Mockito	Testing
📁 Estructura del proyecto
src/main/java/com/bankinc/cardsystem/
  ├── controller/
  ├── service/
  ├── repository/
  ├── model/
  ├── dto/
  ├── exception/
  ├── configuration/
src/main/resources/
  ├── application.properties
  ├── static/swagger-ui/
        ├── index.html
        ├── swagger-ui.css
        ├── swagger-ui-bundle.js
        ├── swagger-ui-standalone-preset.js
        ├── bankinc-openapi.yaml

⚙️ Configuración de base de datos

En application.yaml:
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/bankdb
    username: postgres
    password: 12345678
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        format_sql: true
server:
  port: 8080


Crea la base de datos:

CREATE DATABASE bankdb;

▶️ Cómo ejecutar el proyecto
1. Clonar el repositorio
git clone https://github.com/SebastianV91/BankInc-Nexos
cd BankInc-Nexos

🌐 Documentación Swagger UI

El proyecto incluye Swagger UI estático totalmente integrado.

Una vez iniciado, puedes abrir:

URL	Descripción
http://localhost:8080/swagger
Redirección automática
http://localhost:8080/docs
Alias
http://localhost:8080/swagger-ui/index.html
Swagger UI principal
http://localhost:8080/api-docs
OpenAPI YAML
http://localhost:8080/api-docs/json
OpenAPI JSON
📬 Colección Postman

Incluye todos los endpoints:

Generación de tarjeta

Activación

Bloqueo

Recarga

Consulta de saldo

Anulación

Consulta de transacción

Archivo incluido en:

/postman/bankinc-card-system.postman_collection.json

💳 Endpoints principales

🔵 1. Generar tarjeta
GET /card/{productId}/number

🔵 2. Activar tarjeta
POST /card/enroll

🔵 3. Bloquear tarjeta
DELETE /card/{cardId}

🔵 4. Recargar saldo
POST /card/balance

🔵 5. Consultar saldo
GET /card/balance/{cardId}

🔵 6. Comprar
POST /transaction/purchase

🔵 7. Consultar transacción
GET /transaction/{transactionId}
