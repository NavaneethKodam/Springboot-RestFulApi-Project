package com.nava.springbootproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)    // it marks a method or exception class with the status code and reason message that should be returned.
public class ResourceNotFoundException extends RuntimeException
{
    public ResourceNotFoundException(String message)  // constructor that takes messsage as input
    {
        super(message);
    }
}
