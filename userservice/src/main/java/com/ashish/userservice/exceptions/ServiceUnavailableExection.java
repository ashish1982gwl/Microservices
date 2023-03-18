package com.ashish.userservice.exceptions;

public class ServiceUnavailableExection extends RuntimeException {

    //extra properties that you want to mange
    public ServiceUnavailableExection() {
        super("Resource not found on server !!");
    }

    public ServiceUnavailableExection(String message) {
        super(message);
    }

}
