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

/COLECCION ENDPOINTS MICROSERVICIOS/COLECCION ENDPOINTS MICROSERVICIOS BANK INC.json

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

🔵 8. Anular transacción
POST /transaction/anulation
