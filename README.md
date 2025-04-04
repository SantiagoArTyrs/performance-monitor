# 🧠 Sistema de Monitoreo de Performance con Decorators

Bienvenido al proyecto **Performance Monitor**, un sistema de backend construido con **Spring Boot** para monitorear métricas de rendimiento de métodos en una arquitectura de microservicios. Utiliza el **Patrón Decorator**, base de datos relacional (PostgreSQL) y expone una API RESTful completa (CRUD + PATCH). Ideal para proyectos avanzados de ingeniería de software o arquitecturas empresariales escalables.

---

## 🛠️ Tecnologías usadas

- **Java 21**
- **Spring Boot 3.4.4**
- **Spring Data JPA**
- **Spring AOP**
- **PostgreSQL** (con Docker)
- **Lombok**
- **Postman** para documentación y pruebas
- **Maven** para gestión de dependencias

---

## 🎯 Objetivos

✅ Implementar un sistema de monitoreo de performance  
✅ Usar decoradores dinámicos (Logging, Time, Memory)  
✅ Persistir datos de monitoreo en una base de datos  
✅ Exponer endpoints RESTful CRUD + PATCH  
✅ Aplicar buenas prácticas de desarrollo backend  
✅ Impresionar al profesor 😎

---


---

## 🧠 Decoradores Implementados

- `LoggingDecorator`: imprime logs personalizados al ejecutar métodos monitoreados.
- `TimeLoggingDecorator`: calcula y guarda el tiempo de ejecución.
- `MemoryUsageDecorator`: monitorea el uso de memoria durante la ejecución.

Los decoradores se aplican mediante AOP en el archivo `PerformanceAspect.java`.

---

## 🔧 Endpoints de la API

| Método  | Endpoint                     | Descripción                          |
|---------|------------------------------|--------------------------------------|
| GET     | `/api/performance`           | Listar todos los datos               |
| POST    | `/api/performance`           | Crear nuevo dato de performance      |
| PUT     | `/api/performance/{id}`      | Actualizar todos los campos          |
| PATCH   | `/api/performance/{id}`      | Actualización parcial                |
| DELETE  | `/api/performance/{id}`      | Eliminar un registro específico      |

> Todos los endpoints aceptan y retornan JSON.

---

## 🗃️ Modelo de Datos

```json
{
  "methodName": "getUserData",
  "executionTimeMs": 200,
  "memoryUsageKb": 1024,
  "requestCount": 15,
  "slowMethod": false,
  "timestamp": "2025-04-04T10:30:00"
}

