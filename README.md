# Ryanairtask

Create a MAVEN Java Project - Import the maven dependencies for the suite of Java Test Libraries 

Ryanair API Testing Strategy

    Test API status codes
        200 : Endpoint exists
        404 : Endpoint not existing
  
        Cannot test
        401 : Not authorized (no function to login available)
    
    Test API Headers
        Server name header
        Content-Type header
        
    Test response body 
        Id for pepe@pepe.pe1-0.1
        email for pepe@pepe.pe1
        
    Test API Options
        send options request to determine which requests are supported 
    
    Test POST option
        post a new user and look for response code 201
        try to post the same user and look for error response code 409
    

The tests can be run from the executable jar file generated by the maven project build 
<github repo>/target/WebApiAutomation-1.0-SNAPSHOT-tests.jar