package com.doctorapp.Exception;

public class DoctorNotFoundException extends RuntimeException{
    public DoctorNotFoundException() {

    }

    public DoctorNotFoundException(String message) {
        super(message);
    }
}
