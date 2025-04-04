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
---

▶️ Pasos para Inicializar el Proyecto

1. Clonar el repositorio

git clone https://github.com/tu_usuario/monitor-performance.git
cd monitor-performance

2. Levantar PostgreSQL con Docker

Asegúrate de tener Docker instalado y activo.

docker run --name postgres-db \
  -e POSTGRES_USER=admin \
  -e POSTGRES_PASSWORD=admin \
  -e POSTGRES_DB=performance_db \
  -p 5432:5432 \
  -d postgres

> Si ya tenías un contenedor anterior corriendo, usa:



docker start postgres-db

3. Configurar base de datos en Spring Boot

El archivo application.properties ya debe estar así (pero revisa por si las moscas):

spring.datasource.url=jdbc:postgresql://localhost:5432/performance_db
spring.datasource.username=admin
spring.datasource.password=admin
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

4. Instalar dependencias y compilar el proyecto

Abre tu terminal en la raíz del proyecto y corre:

./mvnw clean install

ó si estás en Windows:

mvn clean install

5. Ejecutar la aplicación

Con Maven:

./mvnw spring-boot:run

o:

mvn spring-boot:run

También puedes ejecutarlo directamente desde IntelliJ con el botón verde de "Play".


---

🧪 Probar los endpoints con Postman

1. Abre Postman


2. Crea una colección nueva (por ejemplo: PerformanceAPI)


3. Usa los endpoints:



GET     http://localhost:8080/api/performance
POST    http://localhost:8080/api/performance
PUT     http://localhost:8080/api/performance/{id}
PATCH   http://localhost:8080/api/performance/{id}
DELETE  http://localhost:8080/api/performance/{id}

Cuerpo para POST/PATCH/PUT:

{
  "methodName": "getMetrics",
  "executionTimeMs": 120,
  "memoryUsageKb": 512,
  "requestCount": 5,
  "slowMethod": false,
  "timestamp": "2025-04-04T14:00:00"
}


---

✨ Extra: Resetear la DB

Si querés resetear todo para empezar fresco:

docker stop postgres-db
docker rm postgres-db

Y luego repetir el paso 2.


---

