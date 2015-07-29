# workorder-rest-webservice
This simple restful webservice is used to prioritize work orders for the employers according to their IDs.
The application is implemented using Spring Boot, Maven, and Java.

## Running the application:
The application is packaged as a 'war'.

## RESTful Web Service End Points:
/workorders/add?id={id}&date={date}
/workorders
/workorders/{id}
/workorders/top
/workorders/remove/{id}
/averagetime?date={date}
