mytaxi Server Applicant Test Service

# Task Description
You should be able to start the example application by executing com.mytaxi.Application, which starts a webserver on port 8080 (http://localhost:8080) and serves SwaggerUI where can inspect and try existing endpoints.

The project is based on a small web service which uses the following technologies:

* Java 1.8
* Spring MVC with Spring Boot
* Database H2 (In-Memory)
* Maven
* Intellij as IDE is preferred but not mandatory. We do provide code formatter for intellij and eclipse in the etc folder.


You should be aware of the following conventions while you are working on this exercise:

 * All new entities should have an ID with type of Long and a date_created with type of ZonedDateTime.
 * The architecture of the web service is built with the following components:
 	* DataTransferObjects: Objects which are used for outside communication via the API
   * Controller: Implements the processing logic of the web service, parsing of parameters and validation of in- and outputs.
   * Service: Implements the business logic and handles the access to the DataAccessObjects.
   * DataAccessObjects: Interface for the database. Inserts, updates, deletes and reads objects from the database.
   * DomainObjects: Functional Objects which might be persisted in the database.
 * TestDrivenDevelopment is a good choice, but it's up to you how you are testing your code.

You should commit into your local git repository and include the commit history into the final result.

## Task 1
 * Write a new Controller for maintaining cars.
   * Decide on your own how the methods should look like.
   * Entity Car: Should have at least the following characteristics: license_plate, seat_count, convertible, rating, engine_type (electric, gas, ...)
   * Entity Manufacturer: Decide on your own if you will use a new table or just a string column in the car table.
 * Extend the DriverController to enable drivers to select a car they are driving with.
 * Extend the DriverController to enable drivers to deselect a car.
 * Extend the DriverDo to map the selected car to the driver.

Ans: Looking into all classes you will find all task1 related implementation.
Note: There is some refactoring of packages and naming conventions based on standards.

## Task 2
First come first serve: A car can be selected by exactly one ONLINE Driver. If a second driver tries to select a already used car you should throw a CarAlreadyInUseException.
Ans: DriverController.selectCarByDriver, DriverController.deSelectCarByDriver and their following implementation

## Task 3
Make use of the filter pattern to implement an endpoint in the DriverController to get a list of drivers with specific characteristics. Reuse the characteristics you implemented in task 1.
Ans: Look into the DriverController.findDriverByCarAttributes(@RequestParam Map<String, String> params)


## Task 4
Security: secure the API. It's up to you how you are going to implement the security.
Ans: In this task Oauth2 is implemented along with driver credentials,
so once driver will provide the their user and pwd api will generate the token
and that token will be used to access any api.

Following URL is required to generate the token:
curl -X POST --user 'web:secret' -d 'grant_type=password&username=driver04&password=driver04pw' http://localhost:8080/oauth/token

Now resource can be accessed via following post url  :
http://localhost:8080/v1/drivers/select?driverId=4&carId=3&access_token=54c4093a-8599-4200-a55e-4808e3261a71

Note: evey resource must be accessed by providing parameter value in "access_token"
