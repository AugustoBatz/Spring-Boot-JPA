# Proyecto con Java Maven, Spring Boot y MariaDB para una API Rest

Esta API esta hecha en NetBeans 11 para la creación de Eventos y Localidades a su como la relacion que
puede hacerse entre ellas

## Comenzando
Para el funcionamiento es necesario es necesario clonar el repositorio y tener Netbeanas 11, así como MariaDB 11.3.

_Instrucciones:_ 

* Abrir el proyecto en Netbens y darle **CLEAN & BUILD** para que descargue las dependencias necesarias.
* Cargar la base de datos a partir del **script.sql**
* En el proyecto configurar el archivo **application.properties** con la creedenciales de la base de datos
asi como la URI de la DB

## Plugins

**Checkstyle**: Con el fin de tener un código ordenado y de calidad se implementaron algunas reglas en un archivo
_checkstyle.xml_. Esto permite tener buenas prácticas a la hora de escribir código y que se entendible. Se recomienda
ver el archivo con las reglas. **El proyecto no compilará si estan reglas se ven violadas**

**Swagger**: Para mantener documentada nuestra API se implemento la GUI de Swagger que nos permite ver cada 
endpoint, la estructura del response así como el JSON que necesita en el body. Esta GUI sirve también como cliente HTTP
permitiendo probar los endpoints. Se configura por medio de anotaciones en cada Endpoint. Se recomienda ver la 
documentación de OpenAPI 3 para aprovechar esta herramienta.

**Integración con JUNIT**
Tiene las dependencias necesarias para hacer pruebas como también un ejemplo de como hacer pruebas 
a los enpoints.
