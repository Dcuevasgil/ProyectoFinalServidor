# API REST de gestión de proyectos (a lo mejor cambio el titulo del README)

## Desarrollado por David Cuevas Gil
## Curso: 2º DAW

## Índice
    - **Introducción**
    - **Funcionalidades**
    - **Instalación**
    - **Uso**
    - **Figma de la interfaz** 
    - **Conclusion del proyecto**
    - **Contribuciones, agradecimientos, referencias**
    - **Licencias**
    - **Contacto**

## Introducción (Revisar)
Este proyecto es una API REST que gestiona informacion de diferentes proyectos, desarrolladores, tecnologías y estados de los proyectos. El objetivo principal es proporcionar una herramienta flexible y robusta para gestionar datos relacionados con proyectos de software. 

La API está hecha en Java con Springboot y diseñada siguiendo el patrón de diseño para el desarrollo de software que se utiliza especialmente en el desarrollo de las aplicaciones web MVC (Modelo Vista Controlador), pero en este caso está diseñada siguiendo el patrón CSR (Controlador Servicio Repositorio)

## Funcionalidades (mirar las funcionalidades detenidamente, revisar)
Esta API REST nos ofrece las siguientes funcionalidades:
    1. Gestión de proyectos: creacion, lectura, actualizacion y eliminacion de proyectos.
    2. Gestión de desarrolladores: creacion, lectura, actualizacion y eliminacion de desarrolladores.
    3. Gestión de tecnologías: creación, lectura, actualización y eliminación de tecnologías de los proyectos.
    4. Gestión de estados: creación, lectura, actualización y eliminación de los estados de los proyectos.
    5. Asignación de desarrolladores a proyectos.
    6. Asignación de tecnologías a proyectos.
    7. Cambios de estados de los proyectos.
    8. Búsqueda de proyectos por palabra clave.
    9. Obtención de proyectos paginados.
    10. Obtención de proyectos con una tecnología específica.

## Guía de instalación
Esta guía es sencilla, para instalar este proyecto he tenido que usar la página "Spring Initializr", dejo por aqui el enlace: <a href="https://start.spring.io/">Spring Initializr</a>. También podía haber creado el proyecto desde cero en Visual Studio Code pero me parecía más cómodo utilizar esta pagina.
(Pongo las dependencias usadas?) 
Para este proyecto ha sido realizado con las siguientes dependencias de Springboot:
    1. Spring Boot DevTools
    2. Lombok
    3. Spring Web
    4. Spring Data JPA
    5. MySQL Driver

## Guía de uso
Para utilizar la API REST, se puede utilizar Postman para hacer las peticiones HTTP con los metodos GET, POST, PUT, DELETE o PATH, o en este caso dentro de Visual Studio Code, en Thunder Client, que es más cómodo en mi opinión.

En esta API REST se llevan a cabo los siguientes Endpoints:

    1º. Mediante petición GET "/projects", para obtener todos los proyectos paginados con los diferentes estados, tecnologías con las que se realizó el proyecto y los desarrolladores que lo desarrollaron.

    2º. Mediante otra petición GET "/projects/{word}", con la que se obtienen todos los proyectos a partir de la palabra clave buscada, con los diferentes estados, tecnologías con las que se realizó el proyecto y los desarrolladores que lo desarrollaron.

    3º. POST "/projects", se realiza una petición mediante el método HTTP POST, que inserta un nuevo proyecto.

    4º. PUT "/projects/{id}", esta petición HTTP mediante el metodo PUT editaría el proyecto que haya creado por un id.

    5º. DELETE "/projects/{id}", esta petición HTTP mediante el metodo DELETE elimina cualquier proyecto creado por un id.

    6º. POST "/developers", se realiza una petición mediante el método HTTP POST, que inserta un nuevo programador en ¿todos los proyectos?.

    7º. DELETE "/developers/{id}", esta petición HTTP mediante el metodo DELETE, que elimina a cualquier desarrollador por un id.

    8º. POST "/technologies", petición HTTP que inserta una tecnología en ¿todos los proyectos?

    9º. DELETE "/technologies/{id}", petición HTTP mediante metodo DELETE que borra una tecnología eligida por el id de la tecnología.

## Conclusión

Esta API REST ha sido desarrollada como una solución práctica para la gestión de proyectos de software. Se ha priorizado la escalabilidad y la facilidad de uso para proporcionar a los usuarios una experiencia eficiente y confiable.

## Contribuciones, agradecimientos, referencias 
En proceso de realizacion

## Licencias
En proceso de realizacion

## Contacto
En proceso de realizacion

Podeis contactar conmigo por aqui: 
Correo electrónico: dcuevasgil@gmail.com
Github: Dcuevasgil 
