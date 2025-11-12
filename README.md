# 🧩 API de Productos - Spring Boot

Este proyecto es una **API RESTful** completa para la **gestión de un inventario de productos**.  
Fue desarrollada con **Spring Boot** como un ejercicio integral que cubre los fundamentos del desarrollo backend.

La API permite realizar operaciones **CRUD** (Crear, Leer, Actualizar, Eliminar), implementando patrones de diseño clave como:

- **DTOs (Data Transfer Objects)**
- **Validación de datos de entrada**
- **Manejo global de excepciones**
- **Documentación de API con Springdoc (Swagger)**

---

## ⚙️ Tecnologías Utilizadas

- ☕ **Java 17**
- 🌱 **Spring Boot 3.3.0**
- 🗃️ **Spring Data JPA (con Hibernate)**
- 🧠 **Base de Datos H2 (en memoria)**
- 📦 **Maven** (Gestor de dependencias)
- 🧰 **Project Lombok** (Reducción de código boilerplate)
- ✅ **Spring Boot Validation** (Validaciones a nivel de DTO)
- 📖 **Springdoc OpenAPI (Swagger)** (Documentación y prueba de API)

---

## 🚀 Instrucciones para Clonar y Ejecutar

1. **Clona este repositorio en tu máquina local:**

   ```bash
   git clone https://github.com/TU_USUARIO/productos-api.git
Navega al directorio del proyecto:

bash
Copiar código
cd productos-api
Ejecuta el proyecto (puedes usar Maven Wrapper o tu IDE favorito):

bash
Copiar código
./mvnw spring-boot:run
Una vez iniciado, la aplicación estará disponible en:

👉 http://localhost:8080

🔗 Acceso a Herramientas
Herramienta	Descripción	URL
🧭 Swagger UI	Documentación y prueba de la API	http://localhost:8080/swagger-ui/index.html
🗄️ Consola H2	Base de datos en memoria	http://localhost:8080/h2-console

Datos de conexión H2:

less
Copiar código
JDBC URL: jdbc:h2:mem:productosdb
Usuario: sa
Contraseña: (en blanco)
🌐 Tabla de Endpoints
Método	Ruta	Descripción
GET	/api/productos	Lista todos los productos.
GET	/api/productos/{id}	Obtiene un producto por su ID.
GET	/api/productos/categoria/{categoria}	Filtra productos por categoría.
POST	/api/productos	Crea un nuevo producto.
PUT	/api/productos/{id}	Actualiza un producto completo por ID.
PATCH	/api/productos/{id}/stock	Actualiza solo el stock de un producto.
DELETE	/api/productos/{id}	Elimina un producto por ID.

📸 Capturas de Pantalla (Pruebas de la API)
🟢 Creando un Producto (POST - 201)
<img width="1825" alt="image" src="https://github.com/user-attachments/assets/f124fd80-37fd-4c1e-a302-3fa65d62eb01" />
🟦 Listando Productos (GET - 200)
<img width="1821" alt="image" src="https://github.com/user-attachments/assets/df2afd37-55d9-419a-a181-9cd58921b3c4" />
🔴 Error 404 - ID Inexistente
<img width="1778" alt="image" src="https://github.com/user-attachments/assets/149db567-45ab-4dc7-86f3-0a64407dda23" />
🟠 Error 400 - Precio Inválido
<img width="1800" alt="image" src="https://github.com/user-attachments/assets/30bbd653-40b1-42ca-86a4-ec19e39b8061" />
🗃️ Consola H2 con Datos Persistidos
<img width="993" alt="image" src="https://github.com/user-attachments/assets/bed6264f-6490-4085-8368-5533b1523519" />
🧠 Autor
Sol Montenegro
Legajo: 51207
📚 Estudiante de Ingeniería en Sistemas de Información
💻 Proyecto académico - Desarrollo Backend con Spring Boot
