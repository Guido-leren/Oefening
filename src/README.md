# Intake 

This is the intake project for Strouwi BV
All necessery dependencies are already available but if required you can add more

## Functionality required

Write a Rest controller which calculates the surface for 2D objects
- Triangle
- Square
- Hexagon

For each request, store the timestamp of the request, the original parameters given to the controller and the calculated result in a DB.

### Controller

This handles the incoming request from users. You can test the controller using unit tests or applications like Postman.

### Service

This handles the actual calculations

### Repository

This handles the storage of requests and calculated results
