# workorder-rest-webservice
This simple restful webservice is used to prioritize work orders for the employers according to their IDs.
The application is implemented using Spring Boot, Maven, and Java.

## Running the application:
The application is packaged as a 'war'. Data is tranformed into JSON.
###### Steps to execute:
- Clone the repository.
- Java version should be 1.7
- Build the application using the following command: mvn clean install
- Run maven goal spring-boot:run using the following command: mvn spring-boot:run

###### Note: Date provided should be in the following format: yyyy-MM-dd_hh:mm:ss. For example: 2015-07-29_09:10:20

## RESTful Web Service End Points:
|              URI                   |                               Description                               |
|------------------------------------|-------------------------------------------------------------------------|
|/workorders/add?id={id}&date={date} | Adds a new work order given employee id, and date entered the queue.    |
|/workorders                         | Returns sorted list of employee ids for all work orders in the queue.   |
|/workorders/{id}                    | Returns the position of a specific Id in the queue, indexed from 0.     |
|/workorders/top                     | Returns the employee's Id on the top of the queue.                      |
|/workorders/averagetime?date={date} | Returns average wait time by all work orders in the queue.              |
|/workorders/remove/{id}             | Removes the work order for the given employee Id.                       | 



