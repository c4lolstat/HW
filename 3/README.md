Microservices homework
======================

Task
----
Your task is to build microservice that is responsible for handling payment requests that have to be forwarded to 
different payment providers.

The 3 different payment providers are available via docker. To deploy them, simply run the 
*docker-compose up* command in the project root.

They are available at the following URLs

* http://localhost:8085
* http://localhost:8086
* http://localhost:8087

To access documentation, just visit */swagger-ui.html* on any of them.

Build and run
-------------
In order to run:
* **Install docker** https://docs.docker.com/docker-for-windows/install/#download-docker-for-windows
* Build project: *mvn clean install*
* Package: *mvn package docker:build*
* Run: *docker run -p 8080:8080 -t microservice-homework/microservice.homework*
* Your microservice is available on localhost:8080

Contact
-------
If you have any questions about the task, feel free to contact me 
* via email: lajos_herendi@epam.com
* skype for business: lajos_herendi@epam.com
* skype: lajos.herendi.epam
* in person

