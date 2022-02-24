#Parcial AREP-T01

## **Prerrequisitos**

-   [Git](https://git-scm.com/downloads) - Sistema de control de versiones
-   [Maven](https://maven.apache.org/download.cgi) - Gestor de dependencias
-   [Java 8](https://www.java.com/download/ie_manual.jsp) - Entorno de desarrollo
-   [Intellij Idea](https://www.jetbrains.com/es-es/idea/download/) (Opcional)


## Heroku

[![Deployed to Heroku](https://www.herokucdn.com/deploy/button.png)](https://arep-parcial-ivan.herokuapp.com/Clima)

### **Instrucciones de uso**

Posibles PATH'S

* PATH /Clima, cuando colocamos este path, se cargara por defecto un formulario el cual realizara las peticiones a nuestro servidor creado con sockets

```
https://arep-parcial-ivan.herokuapp.com/Clima
```

<img src="https://github.com/Rincon10/AREP-PARCIAL-T01/blob/master/resources/img/clima.jpg" />

* PATH /Consulta?q={city}, se encargara de retornar un objeto JSON con la información del clima de la ciudad ingresada.
```
https://arep-parcial-ivan.herokuapp.com/Consulta?q=london
```
NOTA: **poner nombres validos de ciudades, al ser un entregable NO acepta ciudades no validas**

<img src="https://github.com/Rincon10/AREP-PARCIAL-T01/blob/master/resources/img/query.jpg" />

<img src="https://github.com/Rincon10/AREP-PARCIAL-T01/blob/master/resources/img/medellin.jpg" />

* Cualquier url no válido, retornara una página 404
```
https://arep-parcial-ivan.herokuapp.com/dsddsdsff
```
<img src="https://github.com/Rincon10/AREP-PARCIAL-T01/blob/master/resources/img/404.jpg" />

## **Construido con**
  -   [Maven](https://maven.apache.org/download.cgi) - Gestor de dependencias

## **Autor**

-   [Iván Camilo](https://github.com/Rincon10).