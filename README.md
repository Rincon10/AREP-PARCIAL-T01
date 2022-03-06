# Parcial AREP-T01
AREP-PARCIAL-T01 

## Enunciado
Su compañía lo ha seleccionado para construir una aplicación web simple desplegada en Heroku para uno de los clientes más importantes.
La aplicación debe consultar el estado del clima en lugares específicos de la tierra.  La aplicación recibirá en un campo la descripción de una ciudad, por ejemplo “London” para Londres   y deberá mostrar la información del clima para esa ciudad. Para esto utilice el API gratuito de [openweathermap](https://openweathermap.org/) (Puede crear una cuenta para obtener la llave para realizar consultas). La petición debe pasar por su servicio web desplegado en Heroku, es decir desde su servicio en Heroku se debe invocar el servicio web de clima. El usuario no sabrá qué servicio está usted invocando por detrás. Utilice el servicio "Current Weather Data" de openweathermap.org.

* Debe usar sockets solamente no puede usar ni spark ni spring. Usted debe implementar al menos dos servicios web, uno que retorne la página (La página debe estár quemada en el código) y otro que retorne le Json con los datos del clima.

* La página debe invocar el servicio web de la ciudad de manera asíncrona y modificar la información directamente.

* El API de la página debe ser el siguiente:
{url del servicio en heroku}/clima

* El API de su servicio debe ser el siguiente:
{url del servicio en heroku}/consulta?lugar={ciudad o lugar}

* El servicio debe reornar un Json exactamente igual al que retorna el servicio de openweathermap denominado "Current Weather Data". Asegurese que el tipo de retorno sea Json.

Sugerencia realice la implementación de manera incremental. Haga commits regulares.

Entregue todo en GIT HUB y el enlace a Heroku.


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
