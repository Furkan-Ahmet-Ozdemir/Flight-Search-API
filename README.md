# Flight Search API
* The purpose of this application is to searching available flights.

## Some Features of the Application
* Search for flights by departure and arrival airports, departure and arrival dates.
* CRUD operations for Flights.
* CRUD operations for Airports.

## Technologies Used
* JDK 17
* Spring Boot
* H2 Database
* Spring Security
* Spring Data JPA
* Swagger
* Lombok
* Maven
* IntelliJ IDE

## How to Run the Project
* Download the project.
* Extract the project if it's in a zip file.

### To Run Without an IDE:
* Make sure Maven is installed on your computer. If it's not installed, you can download it [here](https://maven.apache.org/download.cgi).
* Make sure the Path is set. If it's not set, you can check it [here](https://mkyong.com/maven/how-to-install-maven-in-windows/).
* When you type `mvn --version` in the CMD, you should get a response similar to `Apache Maven 3.8.4`.
* Then, open CMD and navigate to the directory where the **pom.xml** file is located.
* Run the command `mvn spring-boot:run`.
* If you see messages similar to the following, the project has run successfully:
```
2024-01-02T10:36:09.473+03:00  INFO 5548 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8080 (http) with context path ''
2024-01-02T10:36:09.490+03:00  INFO 5548 --- [           main] c.e.f.FlightSearchApiApplication         : Started FlightSearchApiApplication in 6.386 seconds (process running for 7.274)
2024-01-02T10:36:09.583+03:00  INFO 5548 --- [nio-8080-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2024-01-02T10:36:09.583+03:00  INFO 5548 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2024-01-02T10:36:09.584+03:00  INFO 5548 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 1 ms
```
* Open your browser and go to http://localhost:8080/swagger-ui/index.html#/.


### To Run With IntelliJ IDE:
* Open the project with IntelliJ IDE.
* Run `FlightSearchApiApplication`.
* If you see messages similar to the following in the Run section, the project has run successfully:
```
2024-01-02T10:36:09.473+03:00  INFO 5548 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8080 (http) with context path ''
2024-01-02T10:36:09.490+03:00  INFO 5548 --- [           main] c.e.f.FlightSearchApiApplication         : Started FlightSearchApiApplication in 6.386 seconds (process running for 7.274)
2024-01-02T10:36:09.583+03:00  INFO 5548 --- [nio-8080-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2024-01-02T10:36:09.583+03:00  INFO 5548 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2024-01-02T10:36:09.584+03:00  INFO 5548 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 1 ms
```
* Open your browser and go to http://localhost:8080/swagger-ui/index.html#/.


### To Entere The Swagger UI:
* You have to log in as Admin for accessing Swagger UI.
* ``` username: ``` ``` admin ```
* ``` password: ``` ``` admin ```
* Please note that you might need to log in twice on the Swagger UI page
### API Endpoints To Send Requests:
* `GET`  ```/api/flights``` returns all flights.
* `GET`  ```/api/flights/{id}``` returns a flight by id.
* `GET`  ```/api/flights/searchFlights``` returns a flight by departure and arrival airports, departure and return dates.
* `POST` ```/api/flights``` creates a flight.
* `PUT`  ```/api/flights/{id}``` updates a flight by id.
* `DELETE` ```/api/flights/{id}``` deletes a flight by id.


## Technical Choices 
* I used MySQL Database for this project but if you want to use H2, I added configuration settings for H2 in the **application.properties** file.




