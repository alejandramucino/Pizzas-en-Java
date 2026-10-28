# API REST - Pizzería 🍕

Proyecto desarrollado con **Java 21, Spring Boot 4.1.1 y MongoDB** para implementar operaciones CRUD de pizzas, tamaños, bebidas y clientes mediante una API REST.

## 1. Descripción

La aplicación permite administrar los registros de una pizzería mediante peticiones HTTP.

Se implementaron cuatro CRUD independientes:

- **Pizzas:** registro, consulta, actualización y eliminación de pizzas.
- **Tamaños:** administración de tamaños de pizza, diámetro y precio extra.
- **Bebidas:** administración de bebidas, presentación, contenido y precio.
- **Clientes:** registro y administración de información de clientes.

## 2. Tecnologías utilizadas

- Java 21
- Spring Boot 4.1.1
- Spring Data MongoDB
- MongoDB 7
- Docker
- Gradle
- Postman
- Visual Studio Code

## 3. Estructura del proyecto

```text
src/main/java/mx/unam/aragon/tsp/anmh/pizzas/
├── controllers/
│   ├── PizzaController.java
│   ├── TamanoController.java
│   ├── BebidaController.java
│   └── ClienteController.java
├── models/
│   ├── Pizza.java
│   ├── Tamano.java
│   ├── Bebida.java
│   └── Cliente.java
├── repositories/
│   ├── PizzaRepository.java
│   ├── TamanoRepository.java
│   ├── BebidaRepository.java
│   └── ClienteRepository.java
├── services/
│   ├── PizzaService.java
│   ├── TamanoService.java
│   ├── BebidaService.java
│   └── ClienteService.java
└── PizzasApplication.java
```

La aplicación utiliza una arquitectura por capas:

- **Models:** representan los documentos de MongoDB.
- **Repositories:** proporcionan los métodos de acceso a la base de datos.
- **Services:** contienen la lógica de las operaciones CRUD.
- **Controllers:** reciben las peticiones HTTP y devuelven las respuestas.

## 4. Endpoints de la API

La API se ejecuta localmente en `http://localhost:8080`.

| Método | Endpoint | Descripción |
|---|---|---|
| GET | `/api/v1/pizzas` | Consultar todas las pizzas |
| GET | `/api/v1/pizzas/{id}` | Consultar una pizza |
| POST | `/api/v1/pizzas` | Registrar una pizza |
| PUT | `/api/v1/pizzas/{id}` | Actualizar una pizza |
| DELETE | `/api/v1/pizzas/{id}` | Eliminar una pizza |
| GET | `/api/v1/tamanos` | Consultar todos los tamaños |
| GET | `/api/v1/tamanos/{id}` | Consultar un tamaño |
| POST | `/api/v1/tamanos` | Registrar un tamaño |
| PUT | `/api/v1/tamanos/{id}` | Actualizar un tamaño |
| DELETE | `/api/v1/tamanos/{id}` | Eliminar un tamaño |
| GET | `/api/v1/bebidas` | Consultar todas las bebidas |
| GET | `/api/v1/bebidas/{id}` | Consultar una bebida |
| POST | `/api/v1/bebidas` | Registrar una bebida |
| PUT | `/api/v1/bebidas/{id}` | Actualizar una bebida |
| DELETE | `/api/v1/bebidas/{id}` | Eliminar una bebida |
| GET | `/api/v1/clientes` | Consultar todos los clientes |
| GET | `/api/v1/clientes/{id}` | Consultar un cliente |
| POST | `/api/v1/clientes` | Registrar un cliente |
| PUT | `/api/v1/clientes/{id}` | Actualizar un cliente |
| DELETE | `/api/v1/clientes/{id}` | Eliminar un cliente |

## 5. Configuración y ejecución

### Requisitos

- Java 21
- Docker
- Acceso a las dependencias de Gradle

### Iniciar MongoDB

Si el contenedor `mongo-pizzas` ya existe:

```bash
docker start mongo-pizzas
```

Para crear uno nuevo en un entorno local de desarrollo:

```bash
docker run -d \
  --name mongo-pizzas \
  -p 127.0.0.1:27017:27017 \
  -v mongo_pizzas_data:/data/db \
  mongo:7
```

### Configurar la conexión

En `src/main/resources/application.properties`:

```properties
spring.application.name=pizzas
spring.mongodb.uri=mongodb://localhost:27017/pizzeria
```

### Ejecutar Spring Boot

Desde la carpeta raíz del proyecto:

```bash
./gradlew bootRun
```

La aplicación estará disponible en:

`http://localhost:8080`

## 6. Ejemplos de peticiones JSON

### Registrar una pizza

**POST** `/api/v1/pizzas`

```json
{
  "nombre": "Hawaiana",
  "descripcion": "Pizza con jamón y piña",
  "precio": 150.0
}
```

### Registrar un tamaño

**POST** `/api/v1/tamanos`

```json
{
  "nombre": "Grande",
  "diametro": 35,
  "precioExtra": 40.0
}
```

### Registrar una bebida

**POST** `/api/v1/bebidas`

```json
{
  "nombre": "Coca-Cola",
  "presentacion": "Botella",
  "contenidoMl": 600,
  "precio": 25.0
}
```

### Registrar un cliente

**POST** `/api/v1/clientes`

```json
{
  "nombre": "María",
  "apellido": "López",
  "telefono": "5512345678",
  "correo": "maria@example.com",
  "direccion": "Calle Primavera 25"
}
```

Los datos de los ejemplos son ficticios.

## 7. Pruebas realizadas

Se utilizaron peticiones HTTP desde Postman para verificar las operaciones de los cuatro recursos.

Se comprobaron:

- GET para consultar todos los registros.
- GET por ID para consultar un registro específico.
- POST para crear nuevos documentos.
- PUT para actualizar documentos existentes.
- DELETE para eliminar documentos.

Los registros se almacenan en MongoDB dentro de la base de datos `pizzeria`.

## 8. Consideraciones

Este proyecto fue desarrollado con fines académicos y de aprendizaje.

Los CRUD son independientes y no implementan relaciones entre pizzas, tamaños, bebidas y clientes. Tampoco incorporan autenticación ni autorización; por ello, se recomienda utilizar datos ficticios y ejecutarlo únicamente en un entorno de desarrollo local.
