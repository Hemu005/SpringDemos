package com.doctorapp.Exception;

public class IdNotFoundException extends RuntimeException{
    public IdNotFoundException() {

    }

    public IdNotFoundException(String message) {
        super(message);
    }
}
