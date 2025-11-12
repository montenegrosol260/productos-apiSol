# 🧩 Sistema de Gestión de Tareas – Fundamentos de Spring Boot

Proyecto integrador desarrollado para la materia **Programación III** (Tecnicatura Universitaria en Programación - UTN).  
El objetivo es aplicar los fundamentos de **Spring Boot**, incluyendo inyección de dependencias, estereotipos, configuración mediante properties y gestión de entornos con profiles.

---

## 📝 Descripción del Proyecto

El sistema permite gestionar una lista de tareas (To-Do List) con operaciones básicas:
- Listar tareas
- Agregar nuevas tareas
- Marcar tareas como completadas
- Consultar tareas pendientes
- Obtener estadísticas del sistema

Además, implementa **configuración dinámica** según el entorno (`dev` o `prod`), demostrando buenas prácticas de desarrollo con Spring Boot.

---

## ⚙️ Tecnologías Utilizadas

- ☕ **Java 17+**
- 🚀 **Spring Boot 3.x**
- 📦 **Maven**
- 🧩 **Lombok**
- 🧠 **Inyección de dependencias** y estereotipos (`@Service`, `@Repository`, `@Component`)
- 🧾 **Profiles** (`application-dev.properties`, `application-prod.properties`)

---

## 📁 Archivos de configuración:

**application-dev.properties → entorno de desarrollo**

**application-prod.properties → entorno de producción**

## 💭 Conclusiones Personales

Durante el desarrollo del proyecto pude:

- Comprender el ciclo de vida de los beans y su gestión por el contenedor de Spring.

- Aplicar inyección de dependencias por constructor como buena práctica.

- Diferenciar los estereotipos (@Service, @Repository, @Component).

- Configurar propiedades personalizadas con @Value.

- Implementar perfiles (@Profile) para adaptar el comportamiento según el entorno.

- Usar CommandLineRunner para ejecutar la lógica inicial.

## 👤 Autor

Sol Montenegro
📚 Legajo: 51207

📆 Noviembre 2025

## 🏁 Licencia

Proyecto académico sin fines comerciales.
Uso educativo bajo licencia MIT.
