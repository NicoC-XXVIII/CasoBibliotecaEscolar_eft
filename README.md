# Sistema Biblioteca Escolar

Aplicación de gestión para una biblioteca escolar desarrollada en Java con Swing y conexión a MySQL. El sistema permite administrar estudiantes, libros, categorías, usuarios y préstamos, además de ofrecer una interfaz gráfica para operar la biblioteca de forma simple y ordenada.

## Descripción del proyecto

Este repositorio corresponde a una entrega de la asignatura de Diseño de Objetos II (DOO2). El sistema está pensado para gestionar:

- Registro y control de usuarios
- Administración de estudiantes
- Gestión de libros y categorías
- Registro de préstamos y devoluciones
- Validación de RUT para usuarios y estudiantes
- Interfaz gráfica con pestañas para cada módulo

## Tecnologías utilizadas

- Java 23
- Maven
- JDBC / MySQL Connector
- Swing (GUI)
- MySQL

## Estructura del proyecto

```text
CasoBibliotecaEscolar_eft/
├── pom.xml
├── README.md
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/sgbiblioteca/
│   │   │       ├── controlador/
│   │   │       ├── dao/
│   │   │       ├── database/
│   │   │       ├── excepciones/
│   │   │       ├── interfaces/
│   │   │       ├── modelo/
│   │   │       ├── util/
│   │   │       ├── vista/
│   │   │       └── Main.java
│   │   └── resources/
│   └── script/
│       └── biblioteca.sql
└── .idea/
```

## Requisitos

Antes de ejecutar el proyecto asegúrate de tener instalado:

- JDK 23 o superior
- Maven
- MySQL Server
- Un IDE compatible con Java (IntelliJ IDEA, NetBeans o Eclipse)

## Base de datos

El esquema inicial de la base de datos se encuentra en:

- `src/script/biblioteca.sql`

Este script crea la base de datos `biblioteca`, las tablas necesarias y carga datos de ejemplo.

### Configuración de conexión

La aplicación intenta leer la configuración de conexión desde:

- `src/main/resources/config/db.properties`

Si el archivo no existe, debes crearlo con el siguiente formato:

```properties
url=jdbc:mysql://localhost:3306/biblioteca
user=root
password=tu_contraseña
```

Asegúrate de que tu usuario tenga permisos suficientes para crear y consultar la base de datos.

## Cómo ejecutar el proyecto

### Opción 1: desde un IDE

1. Clona o descarga este repositorio.
2. Importa el proyecto como proyecto Maven.
3. Asegúrate de que la base de datos esté creada y configurada.
4. Ejecuta la clase `com.sgbiblioteca.Main`.

### Opción 2: desde línea de comandos

```bash
mvn clean package
```

Luego, si se configura correctamente el punto de entrada principal, puedes ejecutar la aplicación desde el IDE o mediante Java CLI.

## Funcionalidades principales

- Login de usuario con rol bibliotecario/estudiante
- Gestión de libros por categoría
- Registro de estudiantes con validación de RUT
- Control de préstamos con fechas y estado de devolución
- Interfaz visual dividida por pestañas

## Autor

Proyecto desarrollado por NicoC-XXVIII.

## Nota

Este repositorio representa una entrega académica y se centra en la lógica de negocio, la persistencia y la interfaz gráfica de una biblioteca escolar.
