# workorder-rest-webservice
This simple restful webservice is used to prioritize work orders for the employers according to their IDs.
The application is implemented using Spring Boot, Maven, and Java.

## Running the application:
The application is packaged as a 'war'.

## RESTful Web Service End Points:
|              URI                   |                               Description                               |
|------------------------------------|-------------------------------------------------------------------------|
|/workorders/add?id={id}&date={date} | Adds a new work order given employee id, and date entered the queue.    |
|/workorders                         | Returns sorted list of employee ids for all work orders in the queue.   |
|/workorders/{id}                    | Returns the position of a specific Id in the queue, indexed from 0.     |
|/workorders/top                     | Returns the employee's Id on the top of the queue.                      |
|/workorders/remove/{id}             | Removes the work order for the given employee Id.                       |/averagetime?date={date}            | Returns average wait time by all work orders in the queue.              |
