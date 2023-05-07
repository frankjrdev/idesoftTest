<h1>IDESOFT TEST</h1>
Descripción breve de tu aplicación.

# Requisitos previos

Java 17
Maven 3.0 o superior
Docker


# Cómo ejecutar la aplicación

Desde el código fuente
Clona el repositorio en tu máquina local.

git clone https://github.com/frankjrdev/idesoftTest.git

Abre una terminal y navega hasta la carpeta raíz de la aplicación.

Ejecuta el siguiente comando para compilar la aplicación:

Copy
mvn clean install

mvnw spring-boot:run


Desde Docker
Descarga la imagen de Docker desde Docker Hub:

docker pull frankjrdev/idesoft-test:1.0.0
Ejecuta el contenedor Docker:

Copy
docker run -p 8080:8080 frankjrdev/idesoft-test:1.0.0
La aplicación estará disponible en http://localhost:8080.

Cómo utilizar la aplicación
* Hacer Peticion GET hhacia: localhost:8080/api/idesoft/v1 -> Recibira todos locas locales disponibles.
* Hacer peticion GET hacia localhost:8080/api/idesoft/v1/locales/{Nombre-comuna} ---> Sustituir nombre de la comuna y recibira todos los locales que exisaten en dicha comuna



Contacto: frankjrdev@gmail.com
