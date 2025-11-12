API de Productos - Spring Boot

Este proyecto es una API RESTful completa para la gestión de un inventario de productos. Ha sido desarrollada con Spring Boot como un ejercicio integral que cubre los fundamentos del desarrollo backend.

La API permite realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) completas, implementando patrones de diseño clave como DTOs (Data Transfer Objects), validación de datos de entrada, manejo global de excepciones y documentación de API con Springdoc (Swagger).

⚙️ Tecnologías Utilizadas

Java 17

Spring Boot 3.3.0

Spring Data JPA (con Hibernate)

Base de Datos H2 (en memoria)

Maven (Gestor de dependencias)

Project Lombok (Para reducir código boilerplate)

Spring Boot Validation (Para validaciones a nivel de DTO)

Springdoc OpenAPI (Swagger) (Para documentación y prueba de API)

🚀 Instrucciones para Clonar y Ejecutar

Clona este repositorio en tu máquina local:

git clone [https://github.com/TU_USUARIO/productos-api.git](https://github.com/TU_USUARIO/productos-api.git)


Navega al directorio del proyecto:

cd productos-api


El proyecto usa Maven. Puedes construirlo y ejecutarlo con el wrapper de Maven (recomendado) o directamente desde tu IDE (como IntelliJ o VSCode).

Para ejecutar desde la terminal:

./mvnw spring-boot:run


La aplicación se iniciará y estará disponible en http://localhost:8080.

🔗 Acceso a Herramientas

Una vez que la aplicación esté corriendo, puedes acceder a las siguientes herramientas desde tu navegador:

Swagger UI (Documentación y Prueba de API):
http://localhost:8080/swagger-ui/index.html

Consola H2 (Base de Datos):
http://localhost:8080/h2-console

Importante: Asegúrate de usar la siguiente URL en el campo JDBC URL para conectarte a la base de datos correcta:
jdbc:h2:mem:productosdb (Usuario: sa, Contraseña: en blanco)

🌐 Tabla de Endpoints

Método

Ruta

Descripción

GET

/api/productos

Lista todos los productos.

GET

/api/productos/{id}

Obtiene un producto por su ID.

GET

/api/productos/categoria/{categoria}

Filtra productos por categoría.

POST

/api/productos

Crea un nuevo producto.

PUT

/api/productos/{id}

Actualiza un producto completo por ID.

PATCH

/api/productos/{id}/stock

Actualiza solo el stock de un producto.

DELETE

/api/productos/{id}

Elimina un producto por ID.

📸 Capturas de Pantalla (Pruebas de la API)

A continuación, se muestran los resultados de las pruebas de validación de la API:

CREANDO UN PRODUCTO (Prueba POST Exitosa - 201)
<img width="1825" height="1794" alt="image" src="https://github.com/user-attachments/assets/f124fd80-37fd-4c1e-a302-3fa65d62eb01" />

LISTANDO PRODUCTOS (Prueba GET Exitosa - 200)
<img width="1821" height="1197" alt="image" src="https://github.com/user-attachments/assets/df2afd37-55d9-419a-a181-9cd58921b3c4" />

ERROR 404 ID INEXISTENTE (Prueba GET con ID no válido)
<img width="1778" height="1018" alt="image" src="https://github.com/user-attachments/assets/149db567-45ab-4dc7-86f3-0a64407dda23" />

ERROR 400 PRECIO INVÁLIDO (Prueba de Validación POST)
<img width="1800" height="1740" alt="image" src="https://github.com/user-attachments/assets/30bbd653-40b1-42ca-86a4-ec19e39b8061" />

CONSOLA H2 CON DATOS PERSISTIDOS (Verificación de Base de Datos)
<img width="993" height="447" alt="image" src="https://github.com/user-attachments/assets/bed6264f-6490-4085-8368-5533b1523519" />
