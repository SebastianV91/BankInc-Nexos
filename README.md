✅ README.md — Versión profesional para tu proyecto BankInc Card System

📘 BankInc – Card System (Java 17 + Spring Boot + PostgreSQL)

Este proyecto implementa un sistema de gestión de tarjetas para la prueba técnica de desarrollador backend.
Incluye generación de tarjetas, activación, bloqueo, transacciones, anulación y consultas.

🛠️ Tecnologías utilizadas
Tecnología	Versión
Java	17
Spring Boot	3.4.12
PostgreSQL	18


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
