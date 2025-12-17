# 📝 Java IO Notepad

Una implementación práctica de un Bloc de Notas en Java, diseñada para explorar y aplicar conceptos fundamentales de **Java IO** y **Swing**.

Este proyecto sirve como demostración de la manipulación de archivos (lectura/escritura) comparando diferentes estrategias de rendimiento (Character Streams vs Buffered Streams).

## 🚀 Características Principales

### Funcionalidades
* **Crear Nuevo Archivo:** Limpia el área de trabajo para iniciar una nueva nota.
* **Abrir Archivo:** Carga contenido desde archivos de texto existentes en el sistema.
* **Guardar Archivo:** Escribe el contenido actual en el disco.
* **Interfaz Moderna:** Implementación de **FlatLaf** (Flat Mac Light) para una apariencia limpia y profesional, superando el aspecto por defecto de Swing.

### Arquitectura Técnica
El proyecto desacopla la lógica de negocio (IO) de la interfaz gráfica mediante la interfaz `NotepadStream`, permitiendo intercambiar implementaciones fácilmente.

## 📚 Aprendizaje: Java IO

El núcleo de este proyecto es la comparación de dos métodos de manipulación de archivos:

### 1. Buffered Streams (Implementación Actual)
Ubicación: `NotepadBuffer.java`
* **Clases:** `BufferedReader` y `BufferedWriter`.
* **Ventaja:** Realiza operaciones de lectura/escritura en bloques (chunks) de memoria, reduciendo drásticamente las llamadas al disco y mejorando el rendimiento.
* **Uso:** Es la implementación inyectada por defecto en la aplicación.

### 2. Character Streams (Implementación Educativa)
Ubicación: `NotepadFile.java`
* **Clases:** `FileReader` y `FileWriter`.
* **Estado:** `@Deprecated`.
* **Propósito:** Se mantiene en el código para demostrar la lectura "carácter por carácter" y entender por qué es menos eficiente comparada con el uso de buffers.

## 🛠️ Tecnologías Utilizadas

* **Lenguaje:** Java 8
* **Build Tool:** Maven
* **GUI:** Java Swing
* **Librería UI:** [FlatLaf](https://www.formdev.com/flatlaf/) (Look and Feel)

## 💻 Instalación y Ejecución

1.  **Clonar el repositorio:**
    ```bash
    git clone <url-del-repositorio>
    ```

2.  **Compilar con Maven:**
    ```bash
    mvn clean install
    ```

3.  **Ejecutar:**
    Puedes ejecutar la clase `Main` desde tu IDE favorito o mediante línea de comandos.

## 📄 Estructura del Proyecto

```text
src/main/java/learning/io/operations
├── Main.java                  # Punto de entrada y configuración de UI
├── service
│   ├── NotepadStream.java     # Interfaz para operaciones IO
│   ├── NotepadBuffer.java     # Implementación optimizada (Buffer)
│   ├── NotepadFile.java       # Implementación básica (Deprecated)
│   ├── NoteReader.java        # Interface Segregation (Lectura)
│   └── NoteWriter.java        # Interface Segregation (Escritura)
└── ui
    └── Notepad.java           # Interfaz Gráfica (JFrame)
