# 🏦 VaultCore - Backend Fintech

## 📖 Descripción del Proyecto
VaultCore es el núcleo transaccional (backend) para una Billetera Virtual (Fintech). Está diseñado bajo una arquitectura de **Monolito Modular**, priorizando la consistencia de los datos financieros, la seguridad en la concurrencia y las buenas prácticas de ingeniería de software.

## 🛠️ Stack Tecnológico
* **Lenguaje:** Java 17
* **Framework:** Spring Boot 3 (Spring Web, Spring Data JPA, Validation)
* **Base de Datos:** Oracle Database (vía Docker)
* **Gestor de Dependencias:** Maven
* **Herramientas de Desarrollo:** Lombok, Docker Compose

## 🏗️ Arquitectura y Buenas Prácticas Implementadas
Este proyecto está diseñado con estándares de la industria bancaria y evita los errores comunes de las aplicaciones nivel Junior:

* **Precisión Financiera Inflexible:** Uso estricto de `BigDecimal` para el manejo de dinero y saldos. Evita por completo los tipos flotantes (`Double` / `Float`) para prevenir la pérdida de precisión en operaciones matemáticas.
* **Control de Concurrencia (Seguridad Transaccional):** Implementación de **Bloqueo Optimista (Optimistic Locking)** mediante la anotación `@Version` de JPA. Esto previene el problema de la "actualización perdida" (Lost Update), garantizando que transacciones simultáneas al mismo milisegundo no corrompan el saldo de las cuentas.
* **Empaquetado Moderno:** Empaquetado basado en **Fat JAR** con servidor Apache Tomcat integrado, lo que permite una ejecución 100% independiente y facilita la futura contenerización de la aplicación.
* **Manejo Seguro de Nulos:** Uso de `Optional` en la capa de persistencia (Repositorios) para prevenir errores de tipo `NullPointerException` al buscar cuentas o transacciones inexistentes.

## 🚀 Cómo ejecutar el proyecto en local

### 1. Levantar la Infraestructura (Base de Datos)
El proyecto requiere una instancia de Oracle Database. Asegúrate de tener Docker Desktop ejecutándose en segundo plano y lanza el contenedor con:
```bash
docker-compose up -d
